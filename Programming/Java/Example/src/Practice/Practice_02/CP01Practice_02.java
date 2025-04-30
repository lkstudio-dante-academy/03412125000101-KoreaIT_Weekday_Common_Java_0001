package Practice.Practice_02;

/*
 * Java 과제 2
 * - 미로 탈출 경로 계산하기
 * - 미로가 주어지면 미로를 탈출 할 수 있는 경로 계산
 * - 공백 일 경우 이동 가능
 * - # 일 경우 이동 불가능
 * - 이동한 경로는 * 로 표기
 * - 탈출 할 수 있는 경로가 없을 경우 기존 미로 그대로 표기
 *
 * Ex)
 * =====> 탈출 경로 계산 전 <=====
 * ##S##
 * #   #
 * # # #
 * # # #
 * ###G#
 *
 * =====> 탈출 경로 계산 후 <=====
 * ##S##
 * # **#
 * # #*#
 * # #*#
 * ###G#
 */

/**
 * Practice 2
 */
public class CP01Practice_02 {
	/** 초기화 */
	public static void start(String[] args) {
		char[][] oMap = new char[][] {
				{ '#', '#', 'S', '#', '#' },
				{ '#', ' ', ' ', ' ', '#' },
				{ '#', ' ', '#', ' ', '#' },
				{ '#', ' ', '#', ' ', '#' },
				{ '#', '#', '#', 'G', '#' }
		};
		
		System.out.println("=====> 탈출 경로 계산 전 <=====");
		printMap(oMap);
		
		findPath(oMap, new CCoordinate(2, 0), 'S');
		
		System.out.println("\n=====> 탈출 경로 계산 후 <=====");
		printMap(oMap);
	}
	
	/** 경로를 탐색한다 */
	private static boolean findPath(char[][] a_oMap, CCoordinate a_oCoordinate, char a_chFilter) {
		boolean bIsValidA = a_oCoordinate.m_nX >= 0 && a_oCoordinate.m_nX < a_oMap[0].length;
		boolean bIsValidB = a_oCoordinate.m_nY >= 0 && a_oCoordinate.m_nY < a_oMap.length;
		
		// 경로 탐색이 불가능 할 경우
		if(!bIsValidA || !bIsValidB) {
			return false;
		}
		
		char chLetter_Prev = a_oMap[a_oCoordinate.m_nY][a_oCoordinate.m_nX];
		a_oMap[a_oCoordinate.m_nY][a_oCoordinate.m_nX] = (chLetter_Prev == ' ') ? '*' : chLetter_Prev;
		
		// 목적지에 도착했을 경우
		if(chLetter_Prev == 'G') {
			return true;
		}
		
		bIsValidA = chLetter_Prev == a_chFilter;
		bIsValidB = chLetter_Prev == ' ';
		
		// 경로 탐색이 불가능 할 경우
		if(!bIsValidA && !bIsValidB) {
			return false;
		}
		
		CCoordinate[] oOffsets = new CCoordinate[] {
				new CCoordinate(-1, 0),
				new CCoordinate(1, 0),
				
				new CCoordinate(0, -1),
				new CCoordinate(0, 1)
		};
		
		for(int i = 0; i < oOffsets.length; ++i) {
			CCoordinate oCoordinate_Next = new CCoordinate(a_oCoordinate.m_nX + oOffsets[i].m_nX,
					a_oCoordinate.m_nY + oOffsets[i].m_nY);
			
			// 목적지에 도달했을 경우
			if(findPath(a_oMap, oCoordinate_Next, '\0')) {
				return true;
			}
		}
		
		a_oMap[a_oCoordinate.m_nY][a_oCoordinate.m_nX] = chLetter_Prev;
		return false;
	}
	
	/** 맵을 출력한다 */
	private static void printMap(char[][] a_oMap) {
		for(int i = 0; i < a_oMap.length; ++i) {
			for(int j = 0; j < a_oMap[i].length; ++j) {
				System.out.printf("%c", a_oMap[i][j]);
			}
			
			System.out.println();
		}
	}
}
