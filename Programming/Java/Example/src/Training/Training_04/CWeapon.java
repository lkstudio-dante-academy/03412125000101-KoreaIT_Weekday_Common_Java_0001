package Training.Training_04;

/**
 * 무기
 */
public class CWeapon {
	private int m_nAtk = 0;
	
	/** 생성자 */
	public CWeapon(int a_nAtk) {
		this.m_nAtk = a_nAtk;
	}
	
	/** 공격력을 반환한다 */
	public int getAtk() {
		return m_nAtk;
	}
}
