package Example.Example_17;

/**
 * 카운터
 */
public class CCounter {
	private int m_nTimes = 0;
	
	/** 횟수를 반환한다 */
	public int getTimes() {
		return m_nTimes;
	}
	
	/** 횟수를 증가 시킨다 */
	public void incrTimes(int a_nTimes) {
		m_nTimes += a_nTimes;
	}
}
