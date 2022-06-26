	package app.spring.third.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;
import app.spring.third.service.MemberService;

					//http://localhost:8081/myapp/member/join
@Controller	
@RequestMapping("member")

public class MemberController {
	// 1)컴파일타임:문법적인 에러 체크
		// 인테페이스의 메소드 체크
		// 2)런타임 : 실행시 체크
		// 객체를 생성해서 DI(자동주입)
		// MemberServiceImpl객체가 주입(다형성이용)
		// 필드선언은 인터페이스로
		@Autowired
		private MemberService memberService;

		// 가입폼으로 이동
		@GetMapping("join")
		public void join() {
		}

		// 가입버튼을 클릭시
		@PostMapping("join") 
		public String join(@ModelAttribute Member member, Model model, 
				RedirectAttributes rattr, HttpSession session) throws Exception {

			ErrorCode errorCode =  memberService.insert(member, session);
			rattr.addFlashAttribute("msg", errorCode.getMsg());

			return "redirect:/"; //홈으로 이동(/)
			
		}
		 
		//emailConfirm 처리 메소드(http://localhost:8081/myapp/member/emailConfirm?authCode=046732)
    	@GetMapping("emailConfirm")
		public String emailConfirm(@RequestParam String authCode, @RequestParam String member_id,
				HttpSession session, RedirectAttributes rattr ) { 
			String authCode_s = (String)session.getAttribute("authCode");
			System.out.println(authCode_s);
			if (authCode.equals(authCode_s)) {
				//db의 emailauth를 1로 변경
				memberService.update_emailauth(member_id);
				rattr.addFlashAttribute("msg", ErrorCode.SUCCESS_EMAILAUTH.getMsg());//인증번호가 일치할때 
			}else {
				rattr.addFlashAttribute("msg", ErrorCode.ERROR_EMAILAUTH.getMsg());//인증번호가 일치하지 않을때
			}

			return "redirect:/"; //홈으로 이동	
		}
		
		//가입정보
		@GetMapping("info")
		public String info(HttpSession session, Model model) {
			String member_id = (String) session.getAttribute("member_id");
			//한건조회
			Member member = memberService.selectOne(member_id);
			
			//forward방식 : 주소변경안됨, member + info.jsp  =>response
			model.addAttribute("member", member);
			
			return "member/info";	
	}
	
		// 가입정보에서 회원정보 수정 클릭시
		@PostMapping("info")
		public String info(RedirectAttributes rattr, Member member) throws Exception {
			int cnt = memberService.update(member);
			rattr.addAttribute("cnt", cnt);
			rattr.addFlashAttribute("msg", "수정되었습니다");
			return "redirect:/member/info";

		}
		
		//회원탈퇴로 이동
		@GetMapping("remove")
		public String remove(HttpSession session, Model model ) {
			//회원탈퇴 창으로 이동
			String member_id =(String) session.getAttribute("member_id");
			
			return "member/remove";
			
		}
		
		//가입정보에서 회원탈퇴 클릭시
		@GetMapping("removeCheck")
		public String info(RedirectAttributes rattr, HttpSession session) throws Exception {
			String member_id = (String)session.getAttribute("member_id");
			int cnt = memberService.delete(member_id);
			rattr.addAttribute("cnt", cnt);
			rattr.addFlashAttribute("msg", "탈퇴되었습니다. 다음에 또 찾아주세요.");
			return "redirect:/";
		}
		
		//이메일 중복체크 메소드
		@ResponseBody
		@RequestMapping("emailCheck/{email}")
		public Map<String, Object> emailChekck(@PathVariable String email) {
			ErrorCode errorCode = memberService.emailCheck(email);
			//에러코드를 문자열로 생성 후 반환
			Map<String, Object> map = new HashMap<>();
			map.put("code", errorCode.getCode());
			map.put("msg", errorCode.getMsg());
			
			return map;
		}

	}
