package app.spring.third.service;

import java.util.List;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.ComuBoard;
import app.spring.third.dto.Page;


public interface CboardService {

	List<ComuBoard> selectlist(Page page);

	ErrorCode insert(ComuBoard comuboard);

	int update_readcnt(int cboard_idx);

	ComuBoard selectOne(int cboard_idx);

	ErrorCode delete(int cboard_idx);

	ErrorCode update(ComuBoard comuboard);

}
