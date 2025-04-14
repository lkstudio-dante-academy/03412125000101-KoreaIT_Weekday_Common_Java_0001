package Training.Training_01;

import java.util.Random;
import java.util.Scanner;

/**
 * Training 1
 */
public class CTraining_01 {
	/** 초기화 */
	public static void start(String[] args) {
		int nMenu = 0;
		CCanvas oCanvas = new CCanvas();
		
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
