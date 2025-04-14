package Training.Training_01;

/**
 * 선
 */
public class CLine extends CShape {
	/** 생성자 */
	public CLine(String a_oColor) {
		super(a_oColor);
	}
	
	/** 모양을 반환한다 */
	@Override
	public String getShape() {
		return "선";
	}
}
