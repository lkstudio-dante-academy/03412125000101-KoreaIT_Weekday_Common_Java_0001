/*
 * import 키워드란?
 * - 특정 패키지를 가져오는 역할을 수행한다. (+ 즉, import 키워드를 활용하면 Java 가 지원하는 다양한 패키지를
 * 가져와서 활용하는 것이 가능하다.)
 *
 * Java 는 다양한 패키지를 지원하며 이러한 패키지를 활용하면 프로그램을 좀 더 수월하게 제작하는 것이 가능하다. (+ 즉,
 * 이미 완성 된 기능을 재활용함으로서 작성해야되는 명령문을 줄이는 것이 가능하다.)
 *
 * 패키지 (Package) 란?
 * - 다양한 클래스를 그룹화 시키는 기능을 의미한다. (+ 즉, 패키지 내부에는 여러 기능이 모여있다는 것을 알 수 있다.)
 *
 * Java 는 패키지 단위로 연관 된 기능이 그룹화되어있기 때문에 특정 패키지를 가져옴으로서 해당 패키지 하위에 존재하는
 * 여러 기능을 활용하는 것이 가능하다.
 */
import Example.Example_01.CE01Example_01;
import Example.Example_02.CE01Example_02;
import Example.Example_03.CE01Example_03;
import Example.Example_04.CE01Example_04;
import Example.Example_05.CE01Example_05;
import Example.Example_06.CE01Example_06;
import Example.Example_07.CE01Example_07;
import Example.Example_08.CE01Example_08;
import Example.Example_09.CE01Example_09;
import Example.Example_10.CE01Example_10;
import Example.Example_11.CE01Example_11;
import Example.Example_12.CE01Example_12;
import Example.Example_13.CE01Example_13;
import Example.Example_14.CE01Example_14;
import Example.Example_15.CE01Example_15;
import Example.Example_16.CE01Example_16;
import Example.Example_17.CE01Example_17;

import Practice.Practice_01.CP01Practice_01;
import Practice.Practice_02.CP01Practice_02;

import Training.Training_01.CT01Training_01;
import Training.Training_02.CT01Training_02;

/*
 * 클래스 (Class) 란?
 * - 연관 된 변수 or 메서드 등을 그룹화시킬 수 있는 기능을 의미한다. (+ 즉, 클래스 내부에는 여러 기능이 존재한다는
 * 것을 알 수 있다.)
 *
 * Java 는 객체 지향 프로그래밍 언어이기 때문에 명령문을 작성 할 수 있는 위치가 정해져있으며 그중 하나가 메서드이다.
 * (즉, 메서드 내부에 여러 명령문을 작성함으로서 특정 목적에 맞는 프로그램을 제작하는 것이 가능하다.)
 *
 * 메서드 (Method) 란?
 * - 특정 역할을 수행하는 하나의 기능을 의미한다. (+ 즉, 메서드를 호출하면 해당 메서드 내부에 존재하는 명령문이
 * 실행된다는 것을 알 수 있다.)
 *
 * Java 명령문은 메서드 내부에 작성하는 것이 가능하며 이러한 명령문은 메서드가 호출됨으로서 실행하는 것이 가능하다.
 * (+ 즉, 메서드가 호출되지 않으면 메서드 내부에 존재하는 명령문이 동작하지 않는다는 것을 의미한다.)
 *
 * 주석이란?
 * - 사용자 (프로그래머) 를 위한 기능으로서 메모를 작성 할 수 있는 기능을 의미한다. (+ 즉, 주석은
 * Java 컴파일러에 의해서 기계어로 변환되지 않는다는 것을 알 수 있다.)
 *
 * Jav 주석 종류
 * - 단일 행 주석
 * - 다중 행 주석
 *
 * 위와 같이 Java 는 단일 행 주석과 다중 행 주석을 제공하며 이를 활용해서 사용자 (프로그래머) 를 위한
 * 여러가지 메모를 작성하는 것이 가능하다.
 */
public class Main {
	/*
	 * 메인 메서드 (Main Method) 란?
	 * - Java 로 제작 된 프로그램이 실행 될 때 가장 먼저 호출되는 메서드를 의미한다. (+ 즉, 프로그램이 실행되면
	 * 가장 먼저 호출되는 메서드이기 때문에 진입 메서드라고도 불린다.)
	 *
	 * 메인 메서드가 호출되었다는 것은 프로그램이 실행되었다는 것을 의미하며 메인 메서드가 종료되었다는 것은
	 * 프로그램이 종료되었다는 것을 의미한다. (+ 즉, 메인 메서드의 실행 여부를 통해 프로그램의 실행 여부를
	 * 판단하는 것이 가능하다.)
	 *
	 * Java 명령문은 여러 파일에 작성하는 것이 가능하며 이때 해당 파일 중 어떤 파일에 존재하는 명령문을
	 * 가장 먼저 실행 할지 Java 컴파일러에게 알려 줄 필요가 있으며 이를 위해 존재하는 것이 메인 메서드이다.
	 */
	/** 메인 메서드 */
	public static void main(String[] args) {
//		CE01Example_01.start(args);
//		CE01Example_02.start(args);
//		CE01Example_03.start(args);
//		CE01Example_04.start(args);
//		CE01Example_05.start(args);
//		CE01Example_06.start(args);
//		CE01Example_07.start(args);
//		CE01Example_08.start(args);
//		CE01Example_09.start(args);
//		CE01Example_10.start(args);
//		CE01Example_11.start(args);
//		CE01Example_12.start(args);
		CE01Example_13.start(args);
//		CE01Example_14.start(args);
//		CE01Example_15.start(args);
//		CE01Example_16.start(args);
//		CE01Example_17.start(args);

//		CP01Practice_01.start(args);
//		CP01Practice_02.start(args);
		
//		CT01Training_01.start(args);
//		CT01Training_02.start(args);
	}
}
