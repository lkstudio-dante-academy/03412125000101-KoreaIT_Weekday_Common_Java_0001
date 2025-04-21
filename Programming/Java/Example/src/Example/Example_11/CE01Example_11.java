package Example.Example_11;

import java.util.ArrayList;
import java.util.Random;

/**
 * Example 11 (람다)
 */
public class CE01Example_11 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		ArrayList<Integer> oListValues = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) {
			oListValues.add(oRandom.nextInt(1, 100));
		}
		
		System.out.println("=====> 리스트 요소 <=====");
		printValues(oListValues);
		
		/*
		 * 아래와 같이 익명 내부 클래스를 활용하면 일회성 객체를 생성하는 것이 가능하다. (+ 즉, 익명 내부 클래스는
		 * 일반적으로 재사용 되지 않는 임시 객체를 생성 할 때 주로 활용 된다는 것을 알 수 있다.)
		 */
		sortValues(oListValues, new ICompare() {
			/** 값을 비교한다 */
			@Override
			public int compare(int a_nLhs, int a_nRhs) {
				return a_nLhs - a_nRhs;
			}
		});
		
		System.out.println("\n=====> 리스트 요소 - 오름 차순 정렬 후 <=====");
		printValues(oListValues);
		
		/*
		 * 아래와 같이 람다를 활용하면 익명 내부 클래스를 사용하는 것보다 명령문을 간소화 시키는 것이 가능하다. (+ 즉,
		 * 람다 내부에 작성 된 명령문과 매개 변수를 Java 컴파일러가 분석해서 메서드 유형을 유추한다는 것을
		 * 알 수 있다.)
		 */
		sortValues(oListValues, (a_nLhs, a_nRhs) -> {
			return a_nRhs - a_nLhs;
		});
		
		System.out.println("\n=====> 리스트 요소 - 내름 차순 정렬 후 <=====");
		printValues(oListValues);
	}
	
	/** 값을 정렬한다 */
	private static void sortValues(ArrayList<Integer> a_oListValues, ICompare a_oCompare) {
		for(int i = 0; i < a_oListValues.size(); ++i) {
			for(int j = 0; j < a_oListValues.size() - (i + 1); ++j) {
				int nLhs = a_oListValues.get(j);
				int nRhs = a_oListValues.get(j + 1);
				
				// 정렬이 필요 없을 경우
				if(a_oCompare.compare(nLhs, nRhs) <= 0) {
					continue;
				}
				
				a_oListValues.set(j, nRhs);
				a_oListValues.set(j + 1, nLhs);
			}
		}
	}
	
	/** 값을 출력한다 */
	private static void printValues(ArrayList<Integer> a_oListValues) {
		for(int i = 0; i < a_oListValues.size(); ++i) {
			System.out.printf("%d, ", a_oListValues.get(i));
		}
		
		System.out.println();
	}
}
