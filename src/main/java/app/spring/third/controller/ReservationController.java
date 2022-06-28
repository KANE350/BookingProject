package app.spring.third.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.spring.third.dto.Member;
import app.spring.third.dto.Reservation;
import app.spring.third.service.ReservationServiceImpl;
import app.spring.third.service.RoomFileService;
import app.spring.third.service.RoomService;


@RequestMapping("reservation")
@Controller
public class ReservationController {

	// 에약
	@Autowired
	private ReservationServiceImpl reservationService;

	// 방 정보
	@Autowired
	private RoomService roomService;

	// 방 이미지
	@Autowired
	private RoomFileService roomfileService;

	// 홈
	@GetMapping("/")
	public String test(HttpSession session) {
		
		return "reservation/info";
	}

	// 기본 정보 페이지
	@GetMapping("info")
	public String info() {
		
		return "reservation/info";
	}

	// 예약 안내 페이지
	@GetMapping("reservationinfo")
	public String reservationinfo(Model model, HttpSession session) {
		System.out.println("reservationinfo");
		System.out.println("세션 값 "+session.getAttribute("member_id"));
		// 룸정보 + 룸 이미지
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		
		model.addAttribute("roomNroomfile", roomNroomfile);
		return "reservation/reservationinfo";
	}



	@GetMapping("reservation")
	public String reservation(Model model, HttpSession session) {
		// 룸정보 + 룸 이미지
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		
		model.addAttribute("roomNroomfile", roomNroomfile);

		return "reservation/reservation";
	}

	// 예약 신청
	@PostMapping("reservation")
	public String reservation(Reservation reservation, RedirectAttributes rattr, HttpSession session) throws ParseException {
		System.out.println(session.getAttribute("member_id"));
		reservation.setMember_id(session.getAttribute("member_id").toString());		
		
		reservation.setRe_status("n");
		
	
		  
		  int cnt = reservationService.insert(reservation, session);
		  // 정상
		 if(cnt == 0) { 
			 rattr.addFlashAttribute("msg","예약이 되었습니다.");
			 // 이미 예약이 되어있음.
			 return "redirect:reservation";
		 }else {
			 rattr.addFlashAttribute("msg","이미 예약이 되어있습니다.");
			 return "reservation";
		 }
		
	}
	   //방 상세보기를 클릭했을 때 
	   @GetMapping("roominfo")
	   public String roominfo (int room_idx, Model model) {
	      model.addAttribute("room_idx", roomService.selectOne(room_idx));
	      return "reservation/roominfo";
	   }
	@GetMapping("userreservation")
	public String userreservation(HttpSession session, Model model, RedirectAttributes ratrr) {
		System.out.println("user 아이디 : "+session.getAttribute("member_id"));
		String userid = session.getAttribute("member_id").toString();
		List<Reservation> rlist = reservationService.getreserv(userid);

		System.out.println(rlist);
		model.addAttribute("rlist", rlist);
		return "reservation/userreservation";
	}
	
	// 예약 취소 , 업데이트  선택할수있는곳
	@PostMapping("userreservation")
	
	public String userreservation(HttpSession session, @RequestParam List<String> idx) throws Exception {
		System.out.println("세션 받아온 id"+session.getAttribute("member_id"));
		String userid =session.getAttribute("member_id").toString();

		reservationService.delreservation(idx, userid);
		 
		
		return "redirect:/reservation/userreservation";
	}
	
	
	// 예약 업데이트 (유저별)
	@GetMapping("updatereservation")
	public String updatereservation(@RequestParam int idx, Model model, HttpSession session) {
		// 룸정보 + 룸 이미지
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		model.addAttribute("roomNroomfile", roomNroomfile);
		session.setAttribute("reservidx", idx);
		
		
		
		return "/reservation/updatereservation";
	}
	
	// 수정
	@PostMapping("updatereservation")
	public String updatereservation(RedirectAttributes rattr ,Reservation reservation,Model model, @RequestParam String roominfo, HttpSession session) {
		String idx =session.getAttribute("reservidx").toString();
		String userid =session.getAttribute("member_id").toString();
		
//		  System.out.println("roominfo" + roominfo); System.out.println("enddate" +
//		  reservation.getRe_enddate()); System.out.println("startdate" +
//		  reservation.getRe_startdate());
		 
		reservation.setMember_id(userid);
		reservation.setReservation_idx(Integer.parseInt(idx));
		System.out.println(reservation);
		// 해당 예약건 수정
		int cnt = reservationService.updatereservation(reservation, roominfo);
		if(cnt == 1) {
			rattr.addFlashAttribute("msg","예약 정보 수정 완료");
			return "redirect:/reservation/userreservation";
		}else {
			rattr.addFlashAttribute("msg", "수정중 이상 발생 다시 시도해주세요");
			return "redirect:/reservation/updatereservation";
		}
	}
	
	/*
	 * // 예약 취소
	 * 
	 * @PostMapping("cancelreservation") public String
	 * cancelreservation(@RequestParam int idx[]) { System.out.println(idx);
	 * reservationService.delreservation(map, userid); return ""; }
	 */
	
// 캘린더 
	@ResponseBody
	@RequestMapping("CallCalendar")
	public List<Map<String, Object>> home(Model model, HttpServletRequest request) {

		// 조인목록
		List<Map<String, Object>> mlist = reservationService.getuserNreserv();
		System.out.println("mlist"+mlist);
		// 리턴값
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		 // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		  //원하는 데이터 포맷 지정 // 항목추가 
		  Map<String, Object> map = new HashMap<String, Object>(); 

		  // 캘린더 색상
		  String color = "";
		  // #ff7f00 주황
		  // #0080ff 하늘색
		  // #33FF33 초록색
		  // #7F00FF 보라색
		  for (Map<String, Object> mmap : mlist) { 
			  System.out.println("list" + mmap);
			  map.put("title", mmap.get("ROOM_NAME")); // 방번호
			  switch (mmap.get("ROOM_NAME").toString()) {
			  case "하늘": color = "ff7f00";
					break;
			  case "땅": color = "#0080ff";
				  	break;  
			  case "지하": color = "#33FF33";
					break;
			  case "용암": color = "#7F00FF";
					break;
			  case "천국": color = "#000000";
					break;
			default: color = "#000000";
				break;
			}
			  map.put("color", color); 
			  color = "";
			  //String start = simpleDateFormat.format(mmap.get("RE_STARTDATE"));
			  //String start =;
			  map.put("start",  mmap.get("RE_STARTDATE"));
			  //String end = simpleDateFormat.format(mmap.get("RE_ENDDATE"));
			  //String end = .toString();
			  map.put("end", mmap.get("RE_ENDDATE")+"T23:01:01");
			  
			  resultList.add(map); 
			  map = new HashMap<String, Object>(); 
			   
			  } //
		
		 
		return resultList;

	}
}
