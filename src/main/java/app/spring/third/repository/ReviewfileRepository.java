package app.spring.third.repository;

import java.util.List;

import app.spring.third.dto.Reviewfile;



public interface ReviewfileRepository {

	List<Reviewfile> selectlist(int board_idx);

	int insert(Reviewfile reviewFile);

	int delete(int rf_idx);

}
