package Training.Training_04;

/*
 * Java 연습 문제 4
 * - 텍스트 게임 제작하기
 * - 플레이어는 처음 시작 시 소지 할 금액을 입력 받는다
 * - 게임이 시작되면 상점과 던전을 방문 할 수 있는 메뉴가 출력
 * - 상점에서는 무기를 구입 할 수 있다
 * - 던전에서는 몬스터가 등장 (+ 몬스터 스탯은 플레이어 기본 스탯의 50 %)
 * - 스탯은 공격력과 방어력 2 개 존재 (+ 무기를 구입하면 공격력 증가)
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Training 5
 */
public class CT01Training_04 {
	/** 초기화 */
	public static void start(String[] args) {
		File oFile = new File("P_T01Training_04_01.bin");
		CPlayer oPlayer = new CPlayer(50, 10, 5);
		
		Scanner oScanner = new Scanner(System.in);
		
		try {
			// 파일이 존재 할 경우
			if(oFile.exists()) {
				try(ObjectInputStream oReader = new ObjectInputStream(new FileInputStream(oFile))) {
					oPlayer = (CPlayer)oReader.readObject();
				}
			} else {
				System.out.print("플레이어 초기 소지 금액 입력 : ");
				oPlayer.setMoney(oScanner.nextInt());
				
				System.out.println();
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
		
		int nMenu = 0;
		
		do {
			printMenu_Main();
			nMenu = oScanner.nextInt();
			
			switch(nMenu) {
				case MAIN_MENU_STORE:
					handleOnMenu_Store(oPlayer);
					break;
					
				case MAIN_MENU_DUNGEON:
					handleOnMenu_Dungeon(oPlayer);
					break;
			}
			
			System.out.println();
		} while(nMenu != MAIN_MENU_EXIT);
		
		try(ObjectOutputStream oWriter = new ObjectOutputStream(new FileOutputStream(oFile))) {
			oWriter.writeObject(oPlayer);
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/**
	 * 메인 메뉴
	 */
	private static final int MAIN_MENU_STORE = 1;
	private static final int MAIN_MENU_DUNGEON = 2;
	private static final int MAIN_MENU_EXIT = 3;
	
	/** 메인 메뉴를 출력한다 */
	private static void printMenu_Main() {
		System.out.println("=====> 메인 메뉴 <=====");
		System.out.println("1. 상점 방문");
		System.out.println("2. 던전 입장");
		System.out.println("3. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 상점 방문 메뉴를 처리한다 */
	private static void handleOnMenu_Store(CPlayer a_oPlayer) {
		CStore oStore = new CStore();
		oStore.visit(a_oPlayer);
	}
	
	/** 던전 입장 메뉴를 처리한다 */
	private static void handleOnMenu_Dungeon(CPlayer a_oPlayer) {
		CDungeon oDungeon = new CDungeon();
		oDungeon.enter(a_oPlayer);
	}
}
