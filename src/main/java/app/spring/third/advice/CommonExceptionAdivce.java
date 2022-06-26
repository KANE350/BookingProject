package app.spring.third.advice;

import javax.mail.MessagingException;

import org.springframework.mail.MailAuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//컨트롤러에서 발생되는 예외를 전문적으로 처리하는 클래스
//스프링이 객체 생성

@ControllerAdvice
public class CommonExceptionAdivce {
	
	
//	//객체생성 안될때
//	@ExceptionHandler(NullPointerException.class)
//	public String commonNullpointException(NullPointerException e) {
//		System.out.println("NullponinterException 예외발생");
//		e.printStackTrace();
//		return"error";
//	}
	
	
	
	
//	//MailAuthenticationException 
//	@ExceptionHandler(MailAuthenticationException.class)
//	public String commonMessagingException(MailAuthenticationException e) {
//		System.out.println("MessagingException 예외 발생");
//		System.out.println("메일접속 환경설정을 확인!");
//		System.out.println(e.toString());
//		
//		return "error";
//	}
	
	
	//모든예외처리
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e,Model model) {
		System.out.println("예외 발생");
		System.out.println(e.toString());
		model.addAttribute("exception",e);
		//리졸버 작동
		return"error";
	}
}
