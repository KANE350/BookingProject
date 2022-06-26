package app.spring.third.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.ComuBoard;
import app.spring.third.dto.Page;

@Repository
public class CboardRepositoryImpl implements CboardRepository{

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int selectTotalCnt(Page page) {
		return sqlsession.selectOne("app.spring.third.C_BoardMapper.select_totalCnt",page);
	}

	@Override
	public List<ComuBoard> selectList(Page page) {
		
		return sqlsession.selectList("app.spring.third.C_BoardMapper.selectList",page);
	}

	@Override
	public int insert(ComuBoard comuboard) {
		
		return sqlsession.insert("app.spring.third.C_BoardMapper.insert",comuboard);
	}

	@Override
	public int update_readcnt(int cboard_idx) {
		// TODO Auto-generated method stub
		return sqlsession.update("app.spring.third.C_BoardMapper.update_readcnt",cboard_idx);
	}

	@Override
	public ComuBoard selectOne(int cboard_idx) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("app.spring.third.C_BoardMapper.selectOne",cboard_idx);
	}

	@Override
	public int delete(int cboard_idx) {
		// TODO Auto-generated method stub
		return sqlsession.delete("app.spring.third.C_BoardMapper.delete",cboard_idx);
	}

	@Override
	public int update(ComuBoard comuboard) {
		// TODO Auto-generated method stub
		return sqlsession.update("app.spring.third.C_BoardMapper.update",comuboard);
	}

}
