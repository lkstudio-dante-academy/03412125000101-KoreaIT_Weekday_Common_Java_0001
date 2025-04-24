package Training.Training_02;

/**
 * 싱글턴
 */
public class CSingleton {
	private int m_nVal = 0;
	private static CSingleton m_oInst = null;
	
	/** 생성자 */
	private CSingleton() {
		// Do Something
	}
	
	/** 인스턴스를 반화한다 */
	public static CSingleton getInst() {
		// 인스턴스가 없을 경우
		if(CSingleton.m_oInst == null) {
			CSingleton.m_oInst = new CSingleton();
		}
		
		return CSingleton.m_oInst;
	}
	
	/** 값을 변경한다 */
	public void setVal(int a_nVal) {
		m_nVal = a_nVal;
	}
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("정수 : %d\n", m_nVal);
	}
}
