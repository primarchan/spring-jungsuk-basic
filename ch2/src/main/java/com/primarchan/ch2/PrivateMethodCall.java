package com.primarchan.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main();  // Hello 클래스의 main()메서드의 접근제어자가 private라면 호출 불가
		
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflect 패키지를 제공
		// Hello 크래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		Class helloClass = Class.forName("com.primarchan.ch2.Hello");
		Hello hello =  (Hello)helloClass.newInstance(); // Class 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);  // private인 main() 메서드를 호출가능하게 한다.
		
		main.invoke(hello);  // hello.main()
		
		// 스프링 프레임워크에서 Java의 Reflection API를 사용해서 자동으로 객체를 사용하기 때문에 
		// 따로 객체를 생성하지 않아도 필요에 따라 사용 가능하게 한다. 
	}
}
