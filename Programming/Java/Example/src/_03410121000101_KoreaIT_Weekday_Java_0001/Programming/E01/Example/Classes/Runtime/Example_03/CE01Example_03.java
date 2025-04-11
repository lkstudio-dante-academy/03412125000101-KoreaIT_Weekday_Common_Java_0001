package _03410121000101_KoreaIT_Weekday_Java_0001.Programming.E01.Example.Classes.Runtime.Example_03;

/**
 * 추상 클래스 (Abstract Class) 란?
 * - 일반적인 클래스와 달리 객체화 시키는 것이 불가능한 클래스를 의미한다. (+ 즉, new 키워드를 통해 객체화를 시도하면
 * 컴파일 에러가 발생한다는 것을 알 수 있다.)
 *
 * 추상 클래스는 직접적으로 객체화 시키는 것은 불가능하지만 자식 클래스를 통해 간접적으로 객체화 시키는 것은 가능하다.
 *
 * 따라서 추상 클래스는 주로 클래스 간에 공통적인 특성을 지니고 있는 부모 클래스를 선언하는데 주로 활용된다. (+ 즉,
 * 추상 클래스를 선언함으로서 해당 클래스는 상속용으로 활용된다는 의미를 내포한다는 것을 알 수 있다.)
 *
 * Java 추상 클래스 선언 방법
 * - abstract + class + 클래스 이름 + 클래스 멤버 (+ 변수, 메서드 등등...)
 *
 * Ex)
 * abstract class CBase {
 * 		// Do Something
 * }
 *
 * class CDerived extends CBase {
 * 		// Do Something
 * }
 *
 * CDerived oDerived = new CDerived();
 *
 * 위와 같이 추상 클래스는 자식 클래스를 통해 간접적으로 객체화 시키는 것이 가능하다.
 *
 * 추상 메서드 (Abstract Method) 란?
 * - 일반적인 메서드와 달리 구현부가 존재하지 않는 메서드를 의미한다. (+ 즉, 메서드 몸체가 존재하지 않는다는 것을
 * 알 수 있다.)
 *
 * 특정 클래스에 추상 메서드가 하나라도 선언되어있을 경우 해당 클래스는 객체화가 불가능한 추상 클래스가 된다. (+ 즉,
 * 클래스가 미완성이기 때문에 객체화가 불가능하다는 것을 알 수 있다.)
 *
 * 따라서 추상 메서드를 지니고 있는 클래스를 객체화시키기 위해서는 자식 클래스가 필요하며 이때 자식 클래스는
 * 부모 클래스에 존재하는 추상 메서드를 반드시 구현해줘야한다.
 *
 * 만약 자식 클래스에서 부모 클래스에 존재하는 추상 메서드 중 하나라도 구현하지 않을 경우 자식 클래스 또한 객체화가
 * 불가능한 추상 클래스가 된다. (+ 즉, 클래스 내부에 추상 메서드가 하나라도 존재 할 경우 해당 클래스는
 * 미완성 클래스라는 것을 알 수 있다.)
 *
 * Java 추상 메서드 선언 방법
 * - abstract + 반환 형 + 메서드 이름 + 매개 변수
 *
 * Ex)
 * abstract class CBase {
 * 		public abstract void SomeMethod();
 * }
 *
 * class CDerived extends CBase {
 * 		public void SomeMethod() {
 * 			// Do Something
 * 		}
 * }
 *
 * CBase oBase = new CDerived();
 * oBase.SomeMethod();
 *
 * 위와 같이 추상 메서드는 자식 클래스에서 구현함으로서 해당 메서드를 호출했을 때 실행 될 명령문을 작성하는 것이
 * 가능하다.
 */

/**
 * Example 3 (추상 클래스)
 */
public class CE01Example_03 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * Base 클래스는 추상 클래스이기 때문에 아래와 같이 new 키워드를 통해서 직접적으로 객체화시키는 것이
		 * 불가능하다는 것을 알 수 있다. (+ 즉, 컴파일 에러가 발생한다.)
		 */
//		CE01Base_03 oBaseA = new CE01Base_03(10, 3.14f);
		
		CE01Derived_03 oBaseB = new CE01Derived_03(10, 3.14f, "Hello, World!");
		oBaseB.abstractMethod();
		
		System.out.println("\n=====> 자식 클래스 정보 <=====");
		oBaseB.showInfo();
	}
	
	/**
	 * 부모 클래스
	 */
	private static abstract class CE01Base_03 {
		private int m_nVal = 0;
		private float m_fVal = 0.0f;
		
		/** 생성자 */
		public CE01Base_03(int a_nVal, float a_fVal) {
			this.m_nVal = a_nVal;
			this.m_fVal = a_fVal;
		}
		
		/** 추상 메서드 */
		public abstract void abstractMethod();
		
		/** 정보를 출력한다 */
		public void showInfo() {
			System.out.printf("정수 : %d\n", m_nVal);
			System.out.printf("실수 : %f\n", m_fVal);
		}
	}
	
	/**
	 * 자식 클래스
	 */
	private static class CE01Derived_03 extends CE01Base_03 {
		private String m_oStr = "";
		
		/** 생성자 */
		public CE01Derived_03(int a_nVal, float a_fVal, String a_oStr) {
			super(a_nVal, a_fVal);
			this.m_oStr = a_oStr;
		}
		
		/** 추상 메서드 */
		@Override
		public void abstractMethod() {
			System.out.println("자식 클래스에서 추상 메서드를 구현했습니다.");
		}
		
		/** 정보를 출력한다 */
		@Override
		public void showInfo() {
			super.showInfo();
			System.out.printf("문자열 : %s\n", m_oStr);
		}
	}
}
