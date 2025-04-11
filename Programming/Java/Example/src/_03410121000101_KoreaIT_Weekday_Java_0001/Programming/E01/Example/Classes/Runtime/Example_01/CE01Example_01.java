/*
 * 패키지 (Package) 키워드란?
 * - 패키지를 정의하는 역할을 수행하는 키워드를 의미한다. (+ 즉, 패키지 키워드를 활용하면 Java 클래스를 특정 패키지
 * 하위에 포함시키는 것이 가능하다.)
 *
 * Java 에서 패키지는 디렉토리를 의미하기 때문에 패키지에 명시하는 경로는 반드시 파일 시스템 상에 경로와 일치해야한다.
 * (+ 즉, 경로가 일치하지 않으면 컴파일 에러가 발생한다는 것을 알 수 있다.)
 */
package _03410121000101_KoreaIT_Weekday_Java_0001.Programming.E01.Example.Classes.Runtime.Example_01;

/**
 * Example 1 (기초)
 */
public class CE01Example_01 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * System.out 클래스란?
		 * - 콘솔 창에 문장을 출력하는 역할을 수행하는 클래스를 의미한다. (+ 즉, 해당 클래스를 활용하면 콘솔 창에
		 * 다양한 문장을 출력하는 것이 가능하다.)
		 *
		 * System.out.print 메서드 vs System.out.println 메서드
		 * - 두 메서드 모두 콘솔 창에 문장을 출력하는 역할을 수행한다.
		 *
		 * System.out.print 메서드는 단순히 주어진 문장을 출력하는 반면 System.out.println 메서드는
		 * 주어진 문장을 출력 후 자동으로 개행 처리해주는 차이점이 존재한다. (+ 즉, System.out.print 메서드는
		 * 명시적으로 개행 처리를 해주지 않으면 이후 동일한 라인에 문장이 출력된다는 것을 알 수 있다.)
		 */
		System.out.println("Hello, World!");
	}
}
