package app.spring.third.repository;

import java.util.List;
import java.util.Map;

import app.spring.third.dto.Del_userNreserv;
import app.spring.third.dto.Reservation;

public interface ReservationRepository {
	
	// 예약 등록
	int insert(Reservation reservation);
	
	// 사용자 예약 현황
	List<Map<String, Object>> getuserNreserv();
	
	//아이디 예약현황
	List<Reservation> getreserv(String userid);
	
	
	// 사용자별 예약 취소
	int delreservation(Del_userNreserv dellist);
	
	//  사용자 예약상태 변경 
	int upreserv(String reserv_num);
	
	// 예약 1건 
	Reservation getonereservation(int idx);

	// 예약 내용 수정 
	int updatereservation(Reservation reservation);
	
	
	// 전체 예약내역
	List<Map<String, Object>> getAllreserv();
	
	//컨펌 필요목록
	List<Map<String, Object>> getConfirm();
}
