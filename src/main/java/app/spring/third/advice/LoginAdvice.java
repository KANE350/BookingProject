package app.spring.third.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

//로깅을 대신 찍어주기 위한 목적
@Component //스프링이 객체를 자동 생성해주도록 만들어준다.
@Aspect//이렇게 붙이는 순간 aop가 생성된다(aop를 구현하는 로깅을 할 수 있는 객체를 만들겠다)
 
public class LoginAdvice {
	
	//매개변수를 자동으로 출력해주는 메소드 
	//execution:반환형 패키지명.클래스명.메소드명(..매개변수라는 의미)
	//포인트컷 작성
	@Before//어노테이션, 반드시 메소드 위에 붙여야 한다. 
	//새로고침을 했을때, 조회를 눌렀을 때 잘 뜨는지 확인(엔터쳤을땐 매개변수가 없고 조회 누를땐 매개변수가 있다)
	//확인 후 뷰에 벨류값을 추가하면 url과 콘솔에 값이 담기는 걸 볼 수 있다.
	("execution(*  app.spring.third.repository.*.*(..))")//execution을 실행하라. 패키지명 넣었다.
									//logger를 쓰지 않고도 서비스를 넣고 싶으면 서비시를, 레파지토리를 찍고 싶으면 레파지토리를 넣으면 된다.
									//(*  com.mycompany.myapp.Controller.HomeController.*(..)")
									//이렇게 하면 홈컨트롤러로 범위가 줄어든다.
									//파라미터로 읽어들이는 것들	
	public void beforeLog(JoinPoint jp) {//화살표가 뜬걸 확인할 수 있다. 실행 전에 끼워넣겠다. 모든 컨트롤러가 매개변수로 작동한다. (홈컨트롤러는 화살표가 안으로 들어간걸 볼 수 있는데, 
	//로그인이 진행되기 전에 얘가 먼저 띄워진다는 뜻이다. 다른 컨트롤러 모두 마찬가지. 이를 포인트컷이라 한다.
		System.out.println("매개변수"+jp.getSignature().toShortString() + Arrays.toString(jp.getArgs()	));//자동으로 실행되었는지 아닌지 확인
	}
	
	//리턴값을 출력할때 쓰는 매개변수 
	//Object obj: 리턴값
	@AfterReturning(pointcut = "execution(* org.company.myapp.repository.*.*(..))", returning = "obj")
	//리턴값을 넘겨서 저장해야하는 기능이 필요하기 떄문에 pointcut 작성, returning = "obj"리턴값을 어디에 지정할지 작성한다.
	//@AfterReturning:before의 컨트롤러의 앞의 끼워드는 표시와는 달리 after는 밑으로 향한것을 볼 수 있다.
	//리턴값이 없이 보이드면 오브젝트가 없기 때문에 찍을 수 없다.(getEmailauth의 경우 인증시 오류가 난다. 때문에 널체크 해주어야 한다.)
 	public void afterLog(JoinPoint jp, Object obj) {//어떠한 애를 실행하겠는가.JoinPoint는 클래스이다.
		if(obj != null) {
		System.out.println("----------------------------------------------------");
		System.out.println("리턴값:"+ jp.getSignature().toShortString());
		System.out.println(obj);//널값인 경우에 tostring으로 찍으면 오류가 난다.(obj=리턴값)
		System.out.println("----------------------------------------------------");
		}
	}
	
	//메소드 실행 소요 시간 체크
	//위의 것들은 직접 실행하는게 아니라 위의 값만 가로채서 찍어주는 역할을 하지만, 아래는
	//객체를 통해 직접 실행하기 때문에 반환값이 있다.
	//insert를 통해 실행되고 반환하는 값을 처리해야하기 때문이다.
	//@Around("execution(*  com.spring.myapp.service.*.*(..))")//서비스를 대상으로 얼마나 시간이 소요되는지 체크
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//시작시간 
		
		long startTime = System.currentTimeMillis();		//시스템의 시간을 1000/1초 단위로 반환
															//1971년부터 지금까지 1초단위로 세고 있기 때문에 long형에 담는다
		System.out.println(pjp.getSignature().toShortString()); 		//실행되는 메소드의 이름
		
		//result:실행메소드가 반환하는 값
		Object result = pjp.proceed();//실행 메소드 객체
		
		//끝시간	
		long endTime = System.currentTimeMillis();	
		
		//소요시간
		System.out.println("소요시간:"+(endTime-startTime));//앞에서부터 계산되기 때문에 꼭 소괄호를 넣어야 한다.
		//실행메소드가 반환하는 값을 호출한 메소드에 전달
		return result;
	}
}
