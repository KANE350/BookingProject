package app.spring.third.service;

import java.util.List;

import app.spring.third.dto.Reply;

public interface ReplyService {

	int insert(Reply reply);

	List<Reply> selectList(int board_idx);

	int delete(int reply_idx);

	int update(Reply reply);

}
