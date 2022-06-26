package app.spring.third.advice;


import org.springframework.mail.MailAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//컨트롤러에서 발생되는 예외를 전문적으로 처리하는 클래스를 정의 
//스프링이 객체를 생성해준다
@ControllerAdvice
public class CommonExceptionAdvice {
	
	//객체생성 안될때
	@ExceptionHandler(NullPointerException.class)
	public String commonNullPointerException(NullPointerException e) {
		System.out.println("NullPointerException 예외발생");
		e.printStackTrace();
		return "error";
	}
	//MailAuthenticationException:인증예외
	@ExceptionHandler(MailAuthenticationException.class)
	public String commonMassageinException(MailAuthenticationException e) {
		System.out.println("MailAuthenticationException 예외발생");
		System.out.println("메일접속 환경설정을 확인!");
		System.out.println(e.toString());
		return "error";
	}
	
	//모든 예외 처리
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e) {//가장 최상이 부모를 배치(모든 예외를 잡아준다)
		System.out.println("예외 발생");
		System.out.println(e.toString());
		e.printStackTrace();
		//리졸버 작동 
		return "error";
		
	}
}
