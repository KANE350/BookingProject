package app.spring.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.dto.Reply;
import app.spring.third.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyRepository replyRepository;
	
	
	@Override
	public int insert(Reply reply) {
		//1)글레벨 +1 , 글순서 +1
		reply.setRelevel(reply.getRelevel()+1);
		reply.setRestep(reply.getRestep()+1);
		//2)글순서가 현재데이터보다 크거가 작은데이터는 +1로 수정
		replyRepository.updateRestep(reply);
		//3)저장
		return replyRepository.insert(reply);
	}

	@Override
	public List<Reply> selectList(int board_idx) {
		// TODO Auto-generated method stub
		return replyRepository.selectList(board_idx);
	}

	@Override
	public int delete(int reply_idx) {
		// TODO Auto-generated method stub
		return replyRepository.delete(reply_idx);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return replyRepository.update(reply);
	}

}
