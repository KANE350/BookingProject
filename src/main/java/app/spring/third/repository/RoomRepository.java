package app.spring.third.repository;

import java.util.List;
import java.util.Map;

import app.spring.third.dto.Room;
import app.spring.third.dto.RoomNReserv;

public interface RoomRepository {

	List<Room> select_all();

	List<RoomNReserv> select_roomNreser();

	List<Map<String, Object>> roomNroomfile();

	int getroom_idx(String room_name);
	
	Room selectOne(int room_idx);
}
