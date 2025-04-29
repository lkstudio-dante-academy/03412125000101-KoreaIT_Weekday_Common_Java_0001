package Practice.Practice_01;

/*
 * Java 과제 1
 * - 회원 관리 프로그램 제작하기
 * - 회원 정보는 이름과 전화 번호 존재
 * - 회원 추가, 제거, 검색 가능 (+ 제거 및 검색은 이름으로 가능)
 * - 동일한 이름을 지닌 회원은 추가 불가
 * - 회원 정보를 관리 할 초기 배열 크기는 5 (+ 단, 5 를 초과 할 시 동적으로 배열 크기 조정)
 *
 * Ex)
 * =====> 메뉴 <=====
 * 1. 회원 추가
 * 2. 회원 제거
 * 3. 회원 검색
 * 4. 모든 회원 출력
 * 5. 종료
 *
 * 선택 : 1
 * 이름 입력 : 회원 A
 * 전화 번호 입력 : 1234
 *
 * Case 1. 신규 회원 일 경우
 * 회원 A 을(를) 추가 시켰습니다.
 *
 * Case 2. 동일한 이름의 회원이 존재 할 경우
 * 회원 A 은(는) 이미 추가 된 회원입니다.
 *
 * 선택 : 2
 * 이름 입력 : 회원 A
 *
 * Case 1. 회원이 존재 할 경우
 * 회원 A 을(를) 제거했습니다.
 *
 * Case 2. 회원이 없을 경우
 * 회원 A 은(는) 존재하지않습니다.
 *
 * 선택 : 3
 * 이름 입력 : 회원 A
 *
 * Case 1. 회원이 존재 할 경우
 * =====> 회원 정보 <=====
 * 이름 : 회원 A
 * 전화 번호 : 1234
 *
 * Case 2. 회원이 없을 경우
 * 회원 A 은(는) 존재하지않습니다.
 *
 * 선택 : 4
 * =====> 모든 회원 정보 <=====
 * 이름 : 회원 A
 * 전화 번호 : 1234
 *
 * 이름 : 회원 B
 * 전화 번호 : 1234
 *
 * ...이하 생략
 *
 * 선택 : 5
 * 프로그램을 종료합니다.
 */

import java.util.Scanner;

/**
 * Practice 1
 */
public class CP01Practice_01 {
	/** 초기화 */
	public static void start(String[] args) {
		int nMenu = 0;
		CManager_Member oManager = new CManager_Member();
		
		Scanner oScanner = new Scanner(System.in);
		
		do {
			printMenu();
			nMenu = oScanner.nextInt();
			
			switch(nMenu) {
				case MENU_ADD_MEMBER:
					addMember(oManager);
					break;
					
				case MENU_REMOVE_MEMBER:
					removeMember(oManager);
					break;
					
				case MENU_SEARCH_MEMBER:
					searchMember(oManager);
					break;
					
				case MENU_SHOW_MEMBERS_ALL:
					showMembers_All(oManager);
					break;
			}
			
			System.out.println();
		} while(nMenu != MENU_EXIT);
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	/**
	 * 메뉴
	 */
	private static final int MENU_ADD_MEMBER = 1;
	private static final int MENU_REMOVE_MEMBER = 2;
	private static final int MENU_SEARCH_MEMBER = 3;
	private static final int MENU_SHOW_MEMBERS_ALL = 4;
	private static final int MENU_EXIT = 5;
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 제거");
		System.out.println("3. 회원 검색");
		System.out.println("4. 모든 회원 출력");
		System.out.println("5. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 회원을 추가한다 */
	private static void addMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String oName = oScanner.nextLine();
		
		System.out.print("전화 번호 : ");
		String oPNumber = oScanner.nextLine();
		
		CMember oMember = a_oManager.findMember(oName);
		
		// 회원이 존재 할 경우
		if(oMember != null) {
			System.out.printf("\n%s 은(는) 가입 된 회원입니다.\n", oName);
		} else {
			oMember = new CMember(oName, oPNumber);
			a_oManager.addMember(oMember);
			
			System.out.printf("\n%s 을(를) 추가했습니다.\n", oName);
		}
	}
	
	/** 회원을 제거한다 */
	private static void removeMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String oName = oScanner.nextLine();
		
		CMember oMember = a_oManager.findMember(oName);
		
		// 회원이 존재 할 경우
		if(oMember != null) {
			a_oManager.removeMember(oName);
			System.out.printf("\n%s 을(를) 제거했습니다.\n", oName);
		} else {
			System.out.printf("\n%s 은(는) 존재하지않습니다.\n", oName);
		}
	}
	
	/** 회원을 탐색한다 */
	private static void searchMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String oName = oScanner.nextLine();
		
		CMember oMember = a_oManager.findMember(oName);
		
		// 회원이 존재 할 경우
		if(oMember != null) {
			System.out.println("\n=====> 회원 정보 <=====");
			oMember.showInfo();
		} else {
			System.out.printf("\n%s 은(는) 존재하지않습니다.\n", oName);
		}
	}
	
	/** 회원을 출력한다 */
	private static void showMembers_All(CManager_Member a_oManager) {
		System.out.println("\n=====> 모든 회원 정보 <=====");
		a_oManager.showMembers_All();
	}
}
