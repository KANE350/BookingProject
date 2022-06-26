package app.spring.third.repository;

import java.util.List;

import app.spring.third.dto.ComuReply;
import app.spring.third.dto.Reply;

public interface CreplyRepository {
	//글순서 재수정
	

	
	public int insert(ComuReply creply);

	public List<ComuReply> selectList(int cboard_idx);

	public int delete(int creply_idx);

	public int update(ComuReply creply);


	int updateRestep(ComuReply creply);

}
