package app.spring.third.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;
import app.spring.third.service.LoginService;
import app.spring.third.service.MemberService;
import app.spring.third.service.NaverService;
import app.spring.third.service.ReservationService;

@Controller
public class HomeController {
	@Autowired
	private LoginService loginService;			
	@Autowired
	private NaverService naverService;			
	@Autowired 
	private MemberService memberService;
	@Autowired
	private ReservationService reservationService;
	
	
	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("login")
	public void login(HttpSession session, Model model) throws Exception {
		//네이버 간편가입 위해서 apiURL얻어오기 
		Map<String, String> rmap = naverService.getApiUrl();
		
		//섹션에 state넣기(서비스 임플에서 삽입한 값을 넘겨받았다)(callback메소드에서 인증하기 위해서) 
		session.setAttribute("state", rmap.get("state"));	
		//jsp에 보내기(서비스 임플에서 삽입한 값을 넘겨받았다)
		model.addAttribute("apiURL", rmap.get("apiURL"));
	}
	//로그인 버튼을 눌렀을 때 
	@PostMapping("login")
	public String login(@RequestParam String member_id, @RequestParam String member_pw, RedirectAttributes rattr,
							HttpSession session) {	
		ErrorCode  errorCode = loginService.loginCheck(member_id, member_pw, session);
		//성공이면 list, 아니면 login으로 이동하기
		int code = errorCode.getCode();
		rattr.addFlashAttribute("msg", errorCode.getMsg());//둘 다 같은 방식으로 보내기 때문에 상단에 작성했다.
		
		if(code == 0) {//0하고 같을 경우 성공이다
			return "redirect:/";			//성공할 경우 홈으로 이동
		}
		return "redirect:login";			//실패했을 경우 로그인으로 이동하도록
	}
	
	//로그아웃 버튼을 눌렀을 때
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//세션지우기
		session.invalidate();		//세션을 지우는 역할을 해준다
		
		return "redirect:/";
	}
	
	// page
	@GetMapping("room_management")
	public void room_management() {
		System.out.println("Get Page");
		
		
	}
	
	// 방 처리할 confirm 목록
	@GetMapping("/room_management/room_confirm")
	public String roomconfirm(HttpSession session, Model model) {
		System.out.println("RoomConfirm");
		List<Map<String, Object>> mlist =reservationService.getConfirm();
		System.out.println(mlist);
		model.addAttribute("confirm", mlist);
		return "room_confirm_management";
	}
	
	@PostMapping("/room_management/room_confirm")
	public String roomconfirmcheck(RedirectAttributes rattr, HttpSession session, @RequestParam String reserv_num) {
		
		 reservationService.upreserv(reserv_num);
		rattr.addFlashAttribute("msg", "예약확인완료");
		return "redirect:/room_management/room_confirm";
	}
	
	
	
	//객실관리  ajx
	@ResponseBody
	@GetMapping("Allreserv")
	public List<Map<String, Object>> room_management(HttpSession session, Model model) {
		//1. 전체 리스트
		List<Map<String, Object>> mlist = reservationService.getAllreserv();
		
	
		return mlist;
	}
	
	
	// 멤버관리 - 관리자
	@GetMapping("member_management")
	public String member_management(Model model) {
		List<Member> mlist = memberService.AllUser();
			model.addAttribute("mlist", mlist);
		return "member_management";
	}
	
	
		
		
	
	

	//네이버 콜백주소
	//code:네이버에서 만들어준 코드(동의했다)
	@GetMapping("naverCallback")//코드는 네이버에서 만든, 정상적으로 로그인 되었다는 인증이다.(정보 제공에 동의했다.)
								//state는 내가 만든 것.
	public String vacerCallback(@RequestParam String code, @RequestParam String state,
			HttpSession session, RedirectAttributes rattr) {
		//세션의 state와 파라미터의 state가 일치한다면 정상 사용자로 판단하겠다.
		//(url을 조작해서 들어오지 않은 사용자)
		String state1 = (String) session.getAttribute("state");
	
		if (state1 != null && state1.equals(state1)) { //인증키(state)가 일치한다면 
			//세션이 끊어졌을 경우를 대비해서 널하고 같지 않을때 이퀄스를 따질 수 있도록.
			//&& and연산자. 앞뒤가 모두 트루여야 실행된다.
			ErrorCode errorCode = naverService.naverLogin(code, state1, session);//인증처리(네이버서비스임플 네이버 로그인으로 이동)
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			//code가 0(성공)이면 session에 email넣고 redirect방식 home.jsp로 이동
			if (errorCode.getCode()==0) {//위의 코드가 아니다. 리턴받은 코드이다(네이버 간편가입 코드)
				return "redirect:/";//jsp로 이동 불가. 상단의 /참고
			}
			//아니면(실패) redirect 방식으로 login.jsp로 이동
			return "redirect:login";
			
		}else {
			//state_s이 null이거나 state_s가 일치하지 않는다면
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_NAVERAUTH.getMsg());
			return "redirect:login";
		}

	}
	//회사정보(map)
	@GetMapping("company")
	public void company() {
		
	}
	

	

}
