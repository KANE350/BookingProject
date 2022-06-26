package app.spring.third.repository;

import java.util.List;

import app.spring.third.dto.Reply;

public interface ReplyRepository {
	//글순서 재수정
	int updateRestep(Reply reply);

	
	public int insert(Reply reply);

	public List<Reply> selectList(int board_idx);

	public int delete(int reply_idx);

	public int update(Reply reply);

}
