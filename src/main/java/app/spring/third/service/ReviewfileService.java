package app.spring.third.service;

import java.util.List;

import app.spring.third.dto.Reviewfile;

public interface ReviewfileService {

	public List<Reviewfile> selectList(int board_idx); 
	
}
