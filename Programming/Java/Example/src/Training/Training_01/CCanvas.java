package Training.Training_01;

import java.util.ArrayList;

/**
 * 캔버스
 */
public class CCanvas {
	private ArrayList<CShape> m_oShapes = new ArrayList<CShape>();
	
	/** 도형을 추가한다 */
	public void addShape(CShape a_oShape) {
		m_oShapes.add(a_oShape);
	}
	
	/** 모든 도형을 그린다 */
	public void drawShapes_All() {
		for(int i = 0; i < m_oShapes.size(); ++i) {
			m_oShapes.get(i).draw();
		}
	}
}
