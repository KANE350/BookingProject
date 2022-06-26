package app.spring.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.dto.ComuReply;
import app.spring.third.dto.Reply;
import app.spring.third.repository.CreplyRepository;
import app.spring.third.repository.ReplyRepository;

@Service
public class CreplyServiceImpl implements CreplyService{
	@Autowired
	private CreplyRepository creplyRepository;
	
	@Override
	public int insert(ComuReply creply) {
		//1)글레벨 +1 , 글순서 +1
		creply.setCr_relevel(creply.getCr_relevel()+1);
		creply.setCr_restep(creply.getCr_restep()+1);
		//2)글순서가 현재데이터보다 크거가 작은데이터는 +1로 수정
		creplyRepository.updateRestep(creply);
		//3)저장
		return creplyRepository.insert(creply);
	}

	@Override
	public List<ComuReply> selectList(int cboard_idx) {
		// TODO Auto-generated method stub
		return creplyRepository.selectList(cboard_idx);
	}

	@Override
	public int delete(int creply_idx) {
		// TODO Auto-generated method stub
		return creplyRepository.delete(creply_idx);
	}

	@Override
	public int update(ComuReply creply) {
		// TODO Auto-generated method stub
		return creplyRepository.update(creply);
	}

	
	
	
	
}
