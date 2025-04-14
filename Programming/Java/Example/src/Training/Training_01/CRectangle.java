package Training.Training_01;

/**
 * 사각형
 */
public class CRectangle extends CShape {
	/** 생성자 */
	public CRectangle(String a_oColor) {
		super(a_oColor);
	}
	
	/** 모양을 반환한다 */
	@Override
	public String getShape() {
		return "사각형";
	}
}
