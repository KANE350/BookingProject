package app.spring.third.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.dto.Del_userNreserv;
import app.spring.third.dto.Reservation;
import app.spring.third.repository.ReservationRepository;
import app.spring.third.repository.ReservationRepositoryImpl;

@Service
public class ReservationServiceImpl implements ReservationService{

	
	@Autowired
	private ReservationRepository reservationrepo;
	
	@Autowired
	private RoomService roomServicerepo;
	
	// 예약등록
	@Override
	public int insert(Reservation reservation, HttpSession session) {
		
		//return reservationrepo.insert(reservation);
		
		System.out.println("예약 등록 service - 예약내용"+reservation);
		// 사용자 예약 현황
		List<Map<String, Object>> userNreserv = reservationrepo.getuserNreserv();
		
		// 결과 담는 용도
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	
		
		for(Map<String, Object> map : userNreserv) {
			System.out.println("사용자 아이디 : "+map.get("MEMBER_ID"));
			System.out.println("방 이름"+map.get("ROOM_NAME"));
			System.out.println("예약 날짜"+map.get("RE_STARTDATE"));
			System.out.println("퇴소 날짜"+map.get("RE_ENDDATE"));
			//예약 날짜가 동일하다면 && 방번호 동일 유무 확인
			if(reservation.getRe_startdate() == map.get("RE_STARTDATE") && reservation.getRoom_idx() == (int) map.get("ROOM_IDX")){
				return 1;
					// 예약 불가 다른사람 예약
			}
		
		}
		
		
		
		reservation.setRe_personnel(3);
		// 파라미터로 넘어온 값과  저장된 사용자 예약 현황을 비교한다.
		System.out.println(reservation); 
		System.out.println("해당 날짜 겹치는 숙소 없음.");
		reservationrepo.insert(reservation);
		return 0;
	}
	
	
	// 사용자 예약현황
	@Override
	public List<Map<String, Object>> getuserNreserv() {
		// TODO Auto-generated method stub
		return reservationrepo.getuserNreserv();
	}
	 
	 // 아이디별 예약현황
	@Override
	public List<Reservation> getreserv(String userid) {
		// TODO Auto-generated method stub
		return reservationrepo.getreserv(userid);
	}

	// 회원 예약 취소
	@Override
	public void delreservation(List<String> idx, String userid) {
		// TODO Auto-generated method stub
		System.out.println("파라미터"+idx);
		 List<Del_userNreserv> dellist = new ArrayList<Del_userNreserv>();
		 for(String reserv_id : idx) {
			Del_userNreserv del = new Del_userNreserv();
			System.out.println("배열 하나씩 출력"+reserv_id);
			System.out.println("사용자 iod" + userid);
			del.setReservation_idx(reserv_id);
			del.setUserid(userid);
			dellist.add(del);
			
		 }
		
		 System.out.println("서비스단"+dellist);
		 for(Del_userNreserv del : dellist) {
		 reservationrepo.delreservation(del);
		 }
	}
	// 예약정보 1건
	@Override
	public Reservation getonereservation(int idx) {
		
		return reservationrepo.getonereservation(idx);
	}

	@Override
	public int updatereservation(Reservation reservation, String roominfo) {
		// 방 번호 구하기 
		
		
		int cnt = reservationrepo.updatereservation(reservation);
		 
		return cnt;
	}


	
	// 방 전체 예약 목록
	@Override
	public List<Map<String, Object>> getAllreserv() {
		
		List<Map<String, Object>> mlist = reservationrepo.getAllreserv();
		return mlist;
	}

	// 컨펌 필요목록
	@Override
	public List<Map<String, Object>> getConfirm() {
		List<Map<String, Object>> mlist = reservationrepo.getConfirm();
		return mlist;
	}

// 관리자로부터 예약 삭제
	@Override
	public void upreserv(String reserv_num) {
		reservationrepo.upreserv(reserv_num);
		
	}






	
}
