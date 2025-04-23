package Training.Training_01;

/*
 * Java 연습 문제 1
 * - 콘솔 그림판 제작하기
 * - 도형은 선, 삼각형, 사각형 존재
 * - 각 도형은 색상을 지니고 있다 (+ 색상은 도형 생성 시 랜덤하게 지정)
 * - 각 도형을 추가 후 그리기를 하면 추가 된 모든 도형이 한번에 그려진다
 *
 * Ex)
 * =====> 메뉴 <=====
 * 1. 선 추가
 * 2. 삼각형 추가
 * 3. 사각형 추가
 * 4. 모든 도형 그리기
 * 5. 종료
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 1
 */
public class CT01Training_01 {
	/** 초기화 */
	public static void start(String[] args) {
		int nMenu = 0;
		CCanvas oCanvas = new CCanvas();
		
		/*
		 * Scanner 클래스란?
		 * - 스트림으로부터 데이터를 입력 받는 다양한 기능을 제공하는 클래스를 의미한다. (+ 즉, Scanner 클래스를
		 * 활용하면 사용자로부터 데이터를 입력 받는 것이 가능하다.)
		 *
		 * Ex)
		 * Scanner oScanner = new Scanner(System.in);
		 * int nVal = oScanner.nextInt();
		 *
		 * 위와 같이 System.in 과 nextInt 메서드를 활용하면 콘솔 창으로부터 정수 데이터를 입력 받는 것이 가능하다.
		 * (+ 즉, 사용자와 상호 작용이 가능한 프로그램을 제작하는 것이 가능하다.)
		 */
		Scanner oScanner = new Scanner(System.in);
		
		do {
			printMenu();
			nMenu = oScanner.nextInt();
			
			switch(nMenu) {
				case MENU_ADD_LINE:
				case MENU_ADD_TRIANGLE:
				case MENU_ADD_RECTANGLE:
					CShape oShape = createShape(nMenu);
					oCanvas.addShape(oShape);
					
					break;
				
				case MENU_DRAW_SHAPES_ALL:
					oCanvas.drawShapes_All();
					break;
			}
			
			System.out.println();
		} while(nMenu != MENU_EXIT);
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	/**
	 * 상수
	 */
	private static final int MENU_ADD_LINE = 1;
	private static final int MENU_ADD_TRIANGLE = 2;
	private static final int MENU_ADD_RECTANGLE = 3;
	private static final int MENU_DRAW_SHAPES_ALL = 4;
	private static final int MENU_EXIT = 5;
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 선 추가");
		System.out.println("2. 삼각형 추가");
		System.out.println("3. 사각형 추가");
		System.out.println("4. 모든 도형 그리기");
		System.out.println("5. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 도형을 생성한다 */
	private static CShape createShape(int a_nMenu) {
		String[] oColors = new String[] {
				"빨간색", "녹색", "파란색"
		};
		
		/*
		 * Random 클래스란?
		 * - 난수를 생성하기 위한 다양한 기능을 제공하는 클래스를 의미한다. (+ 즉, Random 클래스를 활용하면
		 * 실행 될 때마다 결과가 달라지는 프로그램을 제작하는 것이 가능하다.)
		 *
		 * Ex)
		 * Random oRandom = new Random();
		 * int nVal = oRandom.nextInt(1, 10);
		 *
		 * 위와 같이 nextInt 메서드를 활용하면 특정 범위 내에 존재하는 수를 무작위로 추출하는 것이 가능하다. (+ 즉,
		 * nextInt 메서드를 호출 할 때마다 다른 결과가 나온다는 것을 알 수 있다.)
		 */
		Random oRandom = new Random();
		
		int nIdx = oRandom.nextInt(0, oColors.length);
		String oColor = oColors[nIdx];
		
		switch(a_nMenu) {
			case MENU_ADD_LINE:
				return new CLine(oColor);
				
			case MENU_ADD_TRIANGLE:
				return new CTriangle(oColor);
				
			case MENU_ADD_RECTANGLE:
				return new CRectangle(oColor);
		}
		
		return null;
	}
}
