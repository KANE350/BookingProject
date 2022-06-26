package app.spring.third.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.Page;
import app.spring.third.dto.ReviewBoard;

@Repository
public class RboardRepositroyImpl implements RboardRepositroy {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int selectTotalCnt(Page page) {
		
		return sqlsession.selectOne("app.spring.third.R_BoardMapper.select_totalCnt",page);
	}

	@Override
	public List<ReviewBoard> selectList(Page page) {
		
		return sqlsession.selectList("app.spring.third.R_BoardMapper.selectList",page);
	}

	@Override
	public int updateLikeCnt(int board_idx) {
		
		return sqlsession.update("app.spring.third.R_BoardMapper.updateLikeCnt",board_idx);
	}

	@Override
	public ReviewBoard selectOne(int board_idx) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("app.spring.third.R_BoardMapper.selectOne",board_idx);
	}

	@Override
	public int insert(ReviewBoard reviewboard) {
		// TODO Auto-generated method stub
		return sqlsession.insert("app.spring.third.R_BoardMapper.insert",reviewboard);
	}

	@Override
	public int delete(int board_idx) {
		// TODO Auto-generated method stub
		return sqlsession.delete("app.spring.third.R_BoardMapper.delete",board_idx);
	}

	@Override
	public int update(ReviewBoard reviewboard) {
		// TODO Auto-generated method stub
		return sqlsession.update("app.spring.third.R_BoardMapper.update",reviewboard);
	}

	@Override
	public int update_readcnt(int board_idx) {
		// TODO Auto-generated method stub
		return sqlsession.update("app.spring.third.R_BoardMapper.update_readcnt",board_idx);
	}

}
