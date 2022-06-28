package app.spring.third.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.third.dto.Reviewfile;
import app.spring.third.repository.ReviewfileRepository;

@Service
public class ReviewfileServiceImpl implements ReviewfileService {

	@Autowired
	private ReviewfileRepository reviewfileRepository;
	
	@Override
	public List<Reviewfile> selectList(int board_idx) {
		// TODO Auto-generated method stub
		return reviewfileRepository.selectlist(board_idx);
	}

}
