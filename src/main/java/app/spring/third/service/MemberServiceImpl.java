package app.spring.third.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import app.spring.third.advice.ErrorCode;
import app.spring.third.dto.Member;
import app.spring.third.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired	//비밀번호 암호화
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired	//이메일 전송
	private JavaMailSender mailsender;
	

	@Override
	@Transactional //트랜잭션을 메소드단위로 제어(commit, rollback을 스프링이 관리)
	public ErrorCode insert(Member member,HttpSession session) throws Exception {
		
		//1)중복이메일 체크
		Member dbmember = memberRepository.selectOne(member.getMember_id());
		if (dbmember != null) {
			return ErrorCode.ERROR_JOIN_ID_EXIST;
		}
		
		//2)비밀번호 암호화
		String cryptPasswd =  bCryptPasswordEncoder.encode(member.getMember_pw());
		member.setMember_pw(cryptPasswd);
		
		//3)저장
		int cnt = memberRepository.insert(member);
		
		//4)이메일전송
		String authCode = sendAuthMail(member.getMember_id());
		
		//5)성공시 세션 저장
		session.setMaxInactiveInterval(60*60*2);
		session.setAttribute("authCode", authCode);//이메일 인증번호
		
		return ErrorCode.SUCCESS_JOIN;
		
		
	}
	

	//인증번호 랜덤으로 6자리 만들기 
	private String getAuthCode() {
		StringBuffer authCode = new StringBuffer();
		Random random = new Random();
		for(int i=0; i<6; i++)
			authCode.append(random.nextInt(10));	//0부터 9까지의 정수 랜덤으로 발생
		
		return authCode.toString();
	}
	
	//이메일 전송하고 인증번호를 리턴
	private String sendAuthMail(String member_id) throws MessagingException {
		//6자리 인증번호 
		String authCode = getAuthCode();
		//보낼 이메일 내용
		StringBuffer content = new StringBuffer();
		content.append(member_id + "님 반갑습니다. 아래 링크를 클릭해 주세요<br>");
		content.append("<a href='http://localhost:8081/myapp/member/emailConfirm?authCode="+authCode+"&member_id="+member_id+"'>이메일인증확인</a>");
		
		//보낼메일 및 메시지 객체 생성
		MimeMessage message = mailsender.createMimeMessage();
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(member_id));
		
		//메일 보내기
		mailsender.send(message);
		return authCode;
		
		
	}


	@Override
	public void update_emailauth(String member_id) {
		//이메일 인증
		int cnt = memberRepository.update_emailauth(member_id);
	}

	@Override
	public Member selectOne(String member_id) {
		//개인정보 조회
		return memberRepository.selectOne(member_id);
	}


	@Override
	public int update(Member member) throws Exception{
		//개인정보 수정
		return memberRepository.update(member);

	}

	@Override
	public int delete(String member_id) throws Exception {
		//회원탈퇴
		return memberRepository.delete(member_id);
	}


	@Override
	public ErrorCode emailCheck(String email) {
		//join에서 이메일 존재 체크 
		Member member = memberRepository.selectOne(email);
		if(member==null) {//이메일이 존재하지 않는다면 
			return ErrorCode.ERROR_EMAIL_EXIT;
			
		}
		//이메일이 존재할 경우
		return ErrorCode.SUCCESS_EMAIL_NOEXITXT;
	}

	

}









