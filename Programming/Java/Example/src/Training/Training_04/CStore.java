package Training.Training_04;

import java.util.Random;
import java.util.Scanner;

/**
 * 상점
 */
public class CStore {
	/**
	 * 메뉴
	 */
	private static final int MENU_BUY_WEAPON_A = 1;
	private static final int MENU_BUY_WEAPON_B = 2;
	private static final int MENU_EXIT = 3;
	
	/** 상점을 방문한다 */
	public void visit(CPlayer a_oPlayer) {
		int nMenu = 0;
		Scanner oScanner = new Scanner(System.in);
		
		do {
			this.printMenu();
			nMenu = oScanner.nextInt();
			
			switch(nMenu) {
				case MENU_BUY_WEAPON_A:
				case MENU_BUY_WEAPON_B:
					this.handleOnMenu_BuyWeapon(nMenu, a_oPlayer);
					break;
			}
			
			System.out.println();
		} while(nMenu != MENU_EXIT);
	}
	
	/** 메뉴를 출력한다 */
	private void printMenu() {
		System.out.println("=====> 상점 메뉴 <=====");
		System.out.println("1. 무기 A 구입 (공격력 : 3, 금액 : 500)");
		System.out.println("2. 무기 B 구입 (공격력 : 1 ~ 5, 금액 : 1000)");
		System.out.println("3. 나가기");
		
		System.out.print("\n선택 : ");
	}
	
	/** 무기 구입 메뉴를 처리한다 */
	private void handleOnMenu_BuyWeapon(int a_nMenu, CPlayer a_oPlayer) {
		int nPrice = (a_nMenu == 1) ? 500 : 1000;
		
		// 금액이 부족 할 경우
		if(a_oPlayer.getMoney() < nPrice) {
			System.out.println("소지 금액이 부족합니다.");
			return;
		}
		
		Random oRandom = new Random();
		int nAtk = (a_nMenu == 1) ? 3 : oRandom.nextInt(1, 5);
		
		CWeapon oWeapon = new CWeapon(nAtk);
		a_oPlayer.setWeapon(oWeapon);
		a_oPlayer.setMoney(Math.max(0, a_oPlayer.getMoney() - nPrice));
		
		System.out.printf("%s (공격력 : %d) 을(를) 구입했습니다\n",
				(a_nMenu == 1) ? "무기 A" : "무기 B", nAtk);
		
		System.out.printf("\n소지 금액 : %d\n", a_oPlayer.getMoney());
	}
}
