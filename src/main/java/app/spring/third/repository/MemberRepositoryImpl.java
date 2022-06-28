package app.spring.third.repository;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.spring.third.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member selectOne(String member_id) {
		//마이페이지 조회
		return sqlSession.selectOne("app.spring.third.MemberMapper.selectOne", member_id);
	}

	@Override
	public int insert(Member member) {
		//회원가입
		return sqlSession.insert("app.spring.third.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member)throws Exception {
		//회원정보 수정
		return sqlSession.update("app.spring.third.MemberMapper.update", member);
	}

	@Override
	public int update_emailauth(String member_id) {
		//이메일 인증
		return sqlSession.update("app.spring.third.MemberMapper.update_emailauth", member_id);
	}

	@Override
	public int insert_simplejoin(Member member) {
		//간편가입
		return sqlSession.insert("app.spring.third.MemberMapper.insert_simplejoin", member);
	}

	@Override
	public int delete(String member_id) throws Exception {
		//회원탈퇴
		return sqlSession.delete("app.spring.third.MemberMapper.delete", member_id);
	}



	

}
