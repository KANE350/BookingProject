package app.spring.third.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;
import app.spring.third.repository.MemberRepository;

@Service
public class LoginServiceImpl implements LoginService{//인터페이스를 구현한다는 뜻으로 작성
	
	@Autowired
	private MemberRepository memberRepository;
	
	//암호화를 만들기 위한 객체
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public ErrorCode loginCheck(String member_id, String member_pw, HttpSession session) {
		Map<String , Object> rmap = new HashMap<>();
		//code, msg를 넣어서 보내도록 한다.
		//0:로그인 완료
		//1: 이메일 미존재
		//2:비밀번호 불일치 
		//3:이메일 미인증
		
		//한건조회
		Member member = memberRepository.selectOne(member_id);
		//1)//조회했을때 이메일이(회원이) 존재하지 않는다면
		if (member == null) {
			rmap.put("code", 1);
			rmap.put("msg", "등록된 이메일이 존재하지 않습니다");
			return ErrorCode.ERROR_LOGIN_EMAIL;
		}
		//존재시
		//2)비밀번호
		//평문과 암호문을 비교(매개변수는 평문과 암호문)
		//앞의거는 평문, 뒤의것은 멤버에서 가져온 암호화된 패스워드를 가져와서 넣은 것
		
		boolean match = bCryptPasswordEncoder.matches(member_pw, member.getMember_pw());
		if (!match) {//비밀번호가 일치하지 않았을 경우
			rmap.put("code", 2);
			rmap.put("msg", "비밀번호 불일치");
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		//위의 경우가 모두 맞을 시
		//3)이메일 미인증시
		if(!member.getMember_emailauth().equals("1")) {
			rmap.put("code", 3);
			rmap.put("msg", "미인증된 이메일 입니다");
			return ErrorCode.ERROR_LOGIN_EMAILAUTH;
		}
		//성공
		rmap.put("code", 0);
		rmap.put("msg", "로그인 완료");
		session.setMaxInactiveInterval(60*60*2);
		session.setAttribute("member_id", member_id);
		session.setAttribute("member_level", member.getMember_level());	
		
		return ErrorCode.SUCCESS_LOGIN;
	}
}
