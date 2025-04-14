package Training.Training_01;

/**
 * 삼각형
 */
public class CTriangle extends CShape {
	/** 생성자 */
	public CTriangle(String a_oColor) {
		super(a_oColor);
	}
	
	/** 모양을 반환한다 */
	@Override
	public String getShape() {
		return "삼각형";
	}
}
