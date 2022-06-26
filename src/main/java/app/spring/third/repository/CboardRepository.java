package app.spring.third.repository;

import java.util.List;

import app.spring.third.dto.ComuBoard;
import app.spring.third.dto.Page;

public interface CboardRepository {

	public int selectTotalCnt(Page page);

	public List<ComuBoard> selectList(Page page);

	public int insert(ComuBoard comuboard);

	public int update_readcnt(int cboard_idx);

	public ComuBoard selectOne(int cboard_idx);

	public int delete(int cboard_idx);

	public int update(ComuBoard comuboard);

}
