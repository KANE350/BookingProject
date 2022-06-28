package app.spring.third.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.ComuReply;
import app.spring.third.dto.Reply;

@Repository
public class CreplyRepositoryImpl implements CreplyRepository {

	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ComuReply creply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("app.spring.third.C_replyMapper.insert",creply);
	}

	@Override
	public List<ComuReply> selectList(int cboard_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("app.spring.third.C_replyMapper.selectList",cboard_idx);
	}

	@Override
	public int delete(int creply_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("app.spring.third.C_replyMapper.delete",creply_idx);
	}

	@Override
	public int update(ComuReply creply) {
		// TODO Auto-generated method stub
		return sqlSession.update("app.spring.third.C_replyMapper.update",creply);
	}

	@Override
	public int updateRestep(ComuReply creply) {
		// TODO Auto-generated method stub
		return sqlSession.update("app.spring.third.C_replyMapper.updateRestep",creply);
	}
	
	
	
}
