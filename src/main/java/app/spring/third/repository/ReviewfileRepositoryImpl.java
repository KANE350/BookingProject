package app.spring.third.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.Reviewfile;

@Repository
public class ReviewfileRepositoryImpl implements ReviewfileRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Reviewfile> selectlist(int board_idx) {
		
		return sqlSession.selectList("app.spring.third.R_BoardFileMapper.selectList",board_idx);
	}

	@Override
	public int insert(Reviewfile reviewFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("app.spring.third.R_BoardFileMapper.insert",reviewFile);
	}

	@Override
	public int delete(int rf_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("app.spring.third.R_BoardFileMapper.delete",rf_idx);
	}

}
