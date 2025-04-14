package Training.Training_01;

/**
 * 도형
 */
public abstract class CShape {
	private String oColor = "";
	
	/** 생성자 */
	public CShape(String a_oColor) {
		this.oColor = a_oColor;
	}
	
	/** 도형을 그린다 */
	public void draw() {
		String oShape = this.getShape();
		System.out.printf("%s %s 을(를) 그렸습니다.\n", oColor, oShape);
	}
	
	/** 모양을 반환한다 */
	public abstract String getShape();
}
