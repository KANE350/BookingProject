package app.spring.third.service;

import javax.servlet.http.HttpSession;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;

public interface MemberService {

	 ErrorCode insert(Member member, HttpSession session) throws Exception;

	 Member selectOne(String member_id);

	 void update_emailauth(String member_id);

	 int update(Member member) throws Exception;

	 int delete(String member_id) throws Exception;

	ErrorCode emailCheck(String email);


	

	 

	

	
}
