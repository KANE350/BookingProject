package app.spring.third.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.Room;
import app.spring.third.dto.RoomNReserv;

@Repository
public class RoomRepositoryImpl implements RoomRepository{
	
	@Autowired
	private SqlSession sqlSession;
	String path = "app.spring.third.RoomMapper";
	
	// 전체 방정보
	@Override
	public List<Room> select_all(){
		return sqlSession.selectList(path+".select_all");
	}
	
	// 사용자에 대한 예약정보
	@Override
	public List<RoomNReserv> select_roomNreser(){
		return sqlSession.selectList(path+".select_roomNreservation");
	}
	
	//방정보와 방이미지파일
	@Override
	public List<Map<String, Object>> roomNroomfile() {

		return sqlSession.selectList(path+".select_roomNroomfile");
	}

	// 룸이름에 맞는 방 번호 가져오기
	@Override
	public int getroom_idx(String room_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(path+".getroom_idx", room_name);
	}
	
	//룸 상세정보 조회
	@Override
	public Room selectOne(int room_idx) {
		return sqlSession.selectOne(path+".selectOne", room_idx);
	}
}
