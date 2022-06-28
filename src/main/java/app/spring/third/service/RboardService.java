package app.spring.third.service;

import java.util.List;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Page;
import app.spring.third.dto.ReviewBoard;

public interface RboardService {

	List<ReviewBoard> selectlist(Page page);

	ErrorCode insert(ReviewBoard reviewboard) throws Exception;

	int update_readcnt(int board_idx);

	ReviewBoard selectOne(int board_idx);

	ErrorCode delete(int board_idx);

	ErrorCode update(ReviewBoard reviewboard, List<Integer> removeFiles) throws Exception;

	int updateLikeCnt(int board_idx);

}
