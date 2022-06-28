package app.spring.third.advice;

public class EnumTest {

	public static void main(String[] args) {
		
		System.out.println(ErrorCode.SUCCESS_ADD);
		System.out.println(ErrorCode.SUCCESS_ADD.getCode());
		System.out.println(ErrorCode.SUCCESS_ADD.getMsg());
		
		System.out.println(ErrorCode.SUCCESS_REMOVE.getMsg());

	}

}
