package app.spring.third.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.spring.third.dto.Reply;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int updateRestep(Reply reply) {
		
		return sqlSession.update("app.spring.third.ReplyMapper.updateRestep",reply);
	}

	@Override
	public int insert(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("app.spring.third.ReplyMapper.insert",reply);
	}

	@Override
	public List<Reply> selectList(int board_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("app.spring.third.ReplyMapper.selectList",board_idx);
	}

	@Override
	public int delete(int reply_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("app.spring.third.ReplyMapper.delete",reply_idx);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("app.spring.third.ReplyMapper.update",reply);
	}
	
}
