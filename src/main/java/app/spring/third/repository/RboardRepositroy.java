package app.spring.third.repository;

import java.util.List;

import app.spring.third.dto.Page;
import app.spring.third.dto.ReviewBoard;

public interface RboardRepositroy {

	public int selectTotalCnt(Page page);

	public List<ReviewBoard> selectList(Page page);

	public int updateLikeCnt(int board_idx);

	public ReviewBoard selectOne(int board_idx);

	public int insert(ReviewBoard reviewboard);

	public int delete(int board_idx);

	public int update(ReviewBoard reviewboard);

	public int update_readcnt(int board_idx);

}
