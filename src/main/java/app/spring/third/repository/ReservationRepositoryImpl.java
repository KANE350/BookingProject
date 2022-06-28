package app.spring.third.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.Del_userNreserv;
import app.spring.third.dto.Reservation;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository{

	@Autowired
	private SqlSession sqlSession;
	String path = "app.spring.third.ReservationMapper";
	
	@Override
	public int insert(Reservation reservation) {
		// TODO Auto-generated method stub
		//System.out.println("레파지토리 출력 " + reservation);
		return sqlSession.insert("app.spring.third.ReservationMapper.insert_reservation", reservation);
	}

	
	
	// 고객의 전체 예약 정보 
	@Override
	public List<Map<String, Object>> getuserNreserv() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(path+".getuserNreserv");
	}

	// 사용자 별 예약 목록
	@Override
	public List<Reservation> getreserv(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(path+".getreserv", userid);
	}

	// 데이터 삭제
	@Override
	public int delreservation(Del_userNreserv dellist) {
	return sqlSession.delete(path+".deluserNreserv",dellist);	
		
	}

	// 1건 예약 데이터
	@Override
	public Reservation getonereservation(int idx) {
		
		return sqlSession.selectOne(path+".getonereservation", idx);
	}


	// 데이터 업데이트
	@Override
	public int updatereservation(Reservation reservation) {

		return sqlSession.update(path+".updatereservation", reservation);
	}

	// 전체예약데이터
	@Override
	public List<Map<String, Object>> getAllreserv() {
		return sqlSession.selectList(path+".getAllreservation");
	}


	// 컨펌 필요목록
	@Override
	public List<Map<String, Object>> getConfirm() {
		String type="n";
		return sqlSession.selectList(path+".getConfirm",type);
	}



	@Override
	public int upreserv(String reserv_num) {

		return sqlSession.update(path+".upreserv", reserv_num);
	}


	
	
}
