package _03410121000101_KoreaIT_Weekday_Java_0001.Programming.E01.Training.Classes.Runtime.Training_01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Training 1
 */
public class CT01Training_01 {
	/** 초기화 */
	public static void start(String[] args) {
		int nMenu = 0;
		CT01Canvas_01 oCanvas = new CT01Canvas_01();
		
		Scanner oScanner = new Scanner(System.in);
		
		do {
			printMenu();
			nMenu = oScanner.nextInt();
			
			switch(nMenu) {
				case MENU_ADD_LINE:
				case MENU_ADD_TRIANGLE:
					CT01Shape_01 oShape = createShape(nMenu);
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
	
	/** 메뉴 */
	private static final int MENU_ADD_LINE = 1;
	private static final int MENU_ADD_TRIANGLE = 2;
	private static final int MENU_DRAW_SHAPES_ALL = 3;
	private static final int MENU_EXIT = 4;
	
	/**
	 * 도형
	 */
	private static abstract class CT01Shape_01 {
		// Do Something
	}
	
	/**
	 * 선
	 */
	private static class CT01Line_01 extends CT01Shape_01 {
		// Do Something
	}
	
	/**
	 * 삼각형
	 */
	private static class CT01Triangle_01 extends CT01Shape_01 {
		// Do Something
	}
	
	/**
	 * 캔버스
	 */
	private static class CT01Canvas_01 {
		private ArrayList<CT01Shape_01> m_oListShapes = new ArrayList<CT01Shape_01>();
		
		/** 도형을 추가한다 */
		public void addShape(CT01Shape_01 a_oShape) {
			// Do Something
		}
		
		/** 모든 도형을 그린다 */
		public void drawShapes_All() {
			// Do Something
		}
	}
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 선 추가");
		System.out.println("2. 삼각형 추가");
		System.out.println("3. 모든 도형 그리기");
		System.out.println("4. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 도형을 생성한다 */
	private static CT01Shape_01 createShape(int a_nMenu) {
		return null;
	}
}
