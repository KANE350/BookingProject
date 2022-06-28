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

@RequestMapping("Reservation")
@Controller
public class ReservationController {

	// �뿉�빟
	@Autowired
	private ReservationServiceImpl reservationService;

	// 諛� �젙蹂�
	@Autowired
	private RoomService roomService;

	// 諛� �씠誘몄�
	@Autowired
	private RoomFileService roomfileService;

	// �솃
	@GetMapping("/")
	public String test(HttpSession session) {
		// 濡쒓렇�씤 �꽦怨듭떆 �꽭�뀡�뿉 媛� �꽔湲�
		Member member = new Member();
		session.setMaxInactiveInterval(60 * 60 * 1); // �꽭�뀡 �떆媛�
		System.out.println("member : " + member);
		return "reservation/info";
	}

	// 湲곕낯 �젙蹂� �럹�씠吏�
	@GetMapping("info")
	public String info() {
		System.out.println("info");
		return "reservation/info";
	}

	//방 상세보기를 클릭했을 때 
	@GetMapping("roominfo")
	public String roominfo (int room_idx, Model model) {
		model.addAttribute("room_idx", roomService.selectOne(room_idx));
		return "reservation/roominfo";
	}
	
	// �삁�빟 �븞�궡 �럹�씠吏�
	@GetMapping("reservationinfo")
	public String reservationinfo(Model model, HttpSession session) {
		System.out.println("reservationinfo");
		System.out.println("�꽭�뀡 媛� " + session.getAttribute("member_id"));
		// 猷몄젙蹂� + 猷� �씠誘몄�
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		System.out.println(roomNroomfile);
		model.addAttribute("roomNroomfile", roomNroomfile);
		return "reservation/reservationinfo";
	}

	@GetMapping("infoimg")
	public String infoimg(@RequestParam String info) {
		System.out.println("�뙆�씪誘명꽣 : " + info);
		return "test";
	}

	@GetMapping("reservation")
	public String reservation(Model model) {

		// 猷몄젙蹂� + 猷� �씠誘몄�
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		model.addAttribute("roomNroomfile", roomNroomfile);

		return "reservation/reservation";
	}

	// �삁�빟 �떊泥�
	@PostMapping("reservation")
	public String reservation(Reservation reservation, @RequestParam String roominfo, RedirectAttributes rattr,
			HttpSession session) throws ParseException {
		// @RequestParam String roominfo, @RequestParam String re_startdate,
		// @RequestParam String re_enddate

		

		// model.addAttribute("userNreserv",userNreserv);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("PostMapping �뱾�뼱�샂");
		System.out.println("roominfo" + roominfo);
		System.out.println("enddate" + reservation.getRe_enddate());
		System.out.println("startdate" + reservation.getRe_startdate());
//		

		/*
		 * Reservation reserv = new Reservation(); Date date =
		 * 
		 * simpleDateFormat.parse(re_startdate); reserv.setRe_startdate(date); Date
		 * date2 = simpleDateFormat.parse(re_enddate); reserv.setRe_enddate(date2);
		 */

		int cnt = reservationService.insert(reservation, roominfo,session);
		// �젙�긽
		if (cnt == 0) {
			rattr.addFlashAttribute("msg", "�삁�빟�씠 �릺�뿀�뒿�땲�떎.");
			// �씠誘� �삁�빟�씠 �릺�뼱�엳�쓬.
			return "redirect:reservation";
		} else {
			rattr.addFlashAttribute("msg", "�씠誘� �삁�빟�씠 �릺�뼱�엳�뒿�땲�떎.");
			return "reservation";
		}
	}

	@GetMapping("userreservation")
	public String userreservation(HttpSession session, Model model, RedirectAttributes ratrr) {
		System.out.println("user �븘�씠�뵒 : " + session.getAttribute("member_id"));
		String userid = session.getAttribute("member_id").toString();
		List<Reservation> rlist = reservationService.getreserv(userid);

		System.out.println(rlist);
		model.addAttribute("rlist", rlist);
		return "reservation/userreservation";
	}

	// �삁�빟 痍⑥냼 , �뾽�뜲�씠�듃 �꽑�깮�븷�닔�엳�뒗怨�
	@PostMapping("userreservation")

	public String userreservation(HttpSession session, @RequestParam List<String> box) throws Exception {
		System.out.println("�꽭�뀡 諛쏆븘�삩 id" + session.getAttribute("member_id"));
		String userid = session.getAttribute("userId").toString();
		System.out.println("ajax 諛쏆븘�샂");
		System.out.println(box);

		reservationService.delreservation(box, userid);

		return "redirect:/reservation/userreservation";
	}

	// �삁�빟 �뾽�뜲�씠�듃 (�쑀��蹂�)
	@GetMapping("updatereservation")
	public String updatereservation(@RequestParam int idx, Model model, HttpSession session) {
		// 猷몄젙蹂� + 猷� �씠誘몄�
		List<Map<String, Object>> roomNroomfile = roomService.roomNroomfile();
		model.addAttribute("roomNroomfile", roomNroomfile);
		session.setAttribute("reservidx", idx);

		return "/reservation/updatereservation";
	}

	// �닔�젙
	@PostMapping("updatereservation")
	public String updatereservation(RedirectAttributes rattr, Reservation reservation, Model model,
			@RequestParam String roominfo, HttpSession session) {
		System.out.println("updatereservation �닔�젙 �뱾�뼱�샂");
		String idx = session.getAttribute("reservidx").toString();
		System.out.println("�꽭�뀡�뿉 ���옣�맂 �븘�씠�뵒媛� " + idx);
		System.out.println(reservation);
		String userid = session.getAttribute("member_id").toString();

//		  System.out.println("roominfo" + roominfo); System.out.println("enddate" +
//		  reservation.getRe_enddate()); System.out.println("startdate" +
//		  reservation.getRe_startdate());

		reservation.setMember_id(userid);
		reservation.setReservation_idx(Integer.parseInt(idx));
		System.out.println(reservation);
		// �빐�떦 �삁�빟嫄� �닔�젙
		int cnt = reservationService.updatereservation(reservation, roominfo);
		if (cnt == 1) {
			rattr.addFlashAttribute("msg", "�삁�빟 �젙蹂� �닔�젙 �셿猷�");
			return "redirect:/Reservation/userreservation";
		} else {
			rattr.addFlashAttribute("msg", "�닔�젙以� �씠�긽 諛쒖깮 �떎�떆 �떆�룄�빐二쇱꽭�슂");
			return "redirect:/Reservation/updatereservation";
		}
	}

// 罹섎┛�뜑 
	@ResponseBody
	@RequestMapping("CallCalendar")
	public List<Map<String, Object>> home(Model model, HttpServletRequest request) {

		// 議곗씤紐⑸줉
		List<Map<String, Object>> mlist = reservationService.getuserNreserv();
		System.out.println("mlist" + mlist);
		// 由ы꽩媛�
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// �썝�븯�뒗 �뜲�씠�꽣 �룷留� 吏��젙 // �빆紐⑹텛媛�
		Map<String, Object> map = new HashMap<String, Object>();

		// 罹섎┛�뜑 �깋�긽
		String color = "";
		// #ff7f00 二쇳솴
		// #0080ff �븯�뒛�깋
		// #33FF33 珥덈줉�깋
		// #7F00FF 蹂대씪�깋
		for (Map<String, Object> mmap : mlist) {
			System.out.println("list" + mmap);
			map.put("title", mmap.get("ROOM_NAME")); // 諛⑸쾲�샇
			switch (mmap.get("ROOM_NAME").toString()) {
			case "�븯�뒛":
				color = "ff7f00";
				break;
			case "�븙":
				color = "#0080ff";
				break;
			case "吏��븯":
				color = "#33FF33";
				break;
			case "�슜�븫":
				color = "#7F00FF";
				break;
			case "泥쒓뎅":
				color = "#000000";
				break;
			default:
				color = "#000000";
				break;
			}
			map.put("color", color);
			color = "";
			// String start = simpleDateFormat.format(mmap.get("RE_STARTDATE"));
			// String start =;
			map.put("start", mmap.get("RE_STARTDATE"));
			// String end = simpleDateFormat.format(mmap.get("RE_ENDDATE"));
			// String end = .toString();
			map.put("end", mmap.get("RE_ENDDATE") + "T23:01:01");

			resultList.add(map);
			map = new HashMap<String, Object>();

		} //

		return resultList;

	}
}
