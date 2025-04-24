package Training.Training_02;

/*
 * Java 연습 문제 2
 * - 싱글턴 클래스 제작하기
 *
 * 싱글턴 패턴 (Singleton Pattern) 이란?
 * - 생성 가능한 객체 수를 1 개로 제한하는 구조를 의미한다. (+ 즉, 싱글턴 패턴은 객체의 생성 방식을 제한하는 구조라는
 * 것을 알 수 있다.)
 */

/**
 * Training 2
 */
public class CT01Training_02 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * 아래와 같이 CSingleton 클래스의 생성자는 private 수준으로 보호 되고 있기 때문에 클래스 외부에서
		 * new 키워드를 통해 객체를 직접적으로 생성하는 것이 불가능하다. (+ 즉, 생성자 호출이 불가능하기 때문에
		 * 객체 생성이 안된다는 것을 알 수 있다.)
		 */
//		CSingleton oInst = new CSingleton();
		
		CSingleton oInstA = CSingleton.getInst();
		CSingleton oInstB = CSingleton.getInst();
		
		oInstA.setVal(10);
		oInstB.setVal(20);
		
		System.out.println("=====> 싱글턴 - A <=====");
		oInstA.showInfo();
		
		System.out.println("\n=====> 싱글턴 - B <=====");
		oInstB.showInfo();
	}
}
