package Training.Training_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 캔버스
 */
public class CCanvas {
	private List<CShape> m_oShapes = new ArrayList<>();
	
	/** 도형을 추가한다 */
	public void addShape(CShape a_oShape) {
		/*
		 * add 메서드는 데이터를 컬렉션에 추가하는 역할을 수행한다. (+ 즉, add 메서드를 활용하면 특정 데이터를
		 * 컬렉션에 추가 후 필요에 따라 재사용하는 것이 가능하다.)
		 */
		m_oShapes.add(a_oShape);
	}
	
	/** 모든 도형을 그린다 */
	public void drawShapes_All() {
		/*
		 * size 메서드는 컬렉션에 존재하는 데이터의 개수를 가져오는 역할을 수행한다.
		 */
		for(int i = 0; i < m_oShapes.size(); ++i) {
			/*
			 * get 메서드는 컬렉션에 존재하는 데이터를 가져오는 역할을 수행한다. (+ 즉, get 메서드에 인덱스 번호를
			 * 명시하면 해당 순서에 존재하는 데이터를 반환한다는 것을 알 수 있다.)
			 */
			m_oShapes.get(i).draw();
		}
	}
}
