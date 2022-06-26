package app.spring.third.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



//aop구현
@Component //스프링이 자동객체 생성
@Aspect
public class LoggingAdvice {
	
	//매개변수를 출력
	//execution : 반환형 패키지명.클래스명.메소드명(..)
	//포인트컷 작성
	@Before("execution(* app.spring.third.controller.*.*(..))")
	public void beforeLog(JoinPoint jp) {
			System.out.println("매개변수:"+jp.getSignature().toShortString() + Arrays.toString(jp.getArgs()));
		
	}
	
	//리턴값 출력
	//Object obj: 리턴 오브젝트
	@AfterReturning(pointcut="execution(* app.spring.third.repository.*.*(..))",returning="obj")
	public void afterLog(JoinPoint jp, Object obj) {
		
		if(obj != null) {
			System.out.println("---------------------------");
			System.out.println("리턴값:" + jp.getSignature().toShortString());
			System.out.println(obj.toString());
			System.out.println("---------------------------");
		}
		
		
	}
	
	//메소드 실행 소요시간 체크
//	@Around("execution(* com.mycompany.myapp.service.MemberServiceImpl.insert(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//시작시간
		long startTime = System.currentTimeMillis(); //시스템의 시간을 1/1000초 단위로 읽기
		System.out.println(pjp.getSignature().toShortString());
		Object result = pjp.proceed(); //실행메소드 객체
		
		//끝시간
		long endTime = System.currentTimeMillis();
		
		//소요시간 
		System.out.println("소요시간:"+(endTime-startTime));
		
		
	


		
		
		return result;
	}
	
}

