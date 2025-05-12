package Training.Training_04;

/**
 * 유닛
 */
public class CUnit {
	private int m_nHp = 0;
	private int m_nAtk = 0;
	private int m_nDef = 0;
	
	/** 생성자 */
	public CUnit(int a_nHp, int a_nAtk, int a_nDef) {
		this.m_nHp = a_nHp;
		this.m_nAtk = a_nAtk;
		this.m_nDef = a_nDef;
	}
	
	/** 공격력을 반환한다 */
	public int getAtk() {
		return m_nAtk;
	}
	
	/** 대상을 공격한다 */
	public void attack(CUnit a_oTarget) {
		int nAtk = this.getAtk();
		int nDamage = Math.max(0, nAtk - a_oTarget.m_nDef);
		
		a_oTarget.m_nHp = Math.max(0, a_oTarget.m_nHp - nDamage);
	}
}

/**
 * 플레이어
 */
class CPlayer extends CUnit {
	private int m_nMoney = 0;
	private CWeapon m_oWeapon_Equip = null;
	
	/** 생성자 */
	public CPlayer(int a_nHp, int a_nAtk, int a_nDef) {
		super(a_nHp, a_nAtk, a_nDef);
	}
	
	/** 소지 금액을 반환한다 */
	public int getMoney() {
		return m_nMoney;
	}
	
	/** 공격력을 반환한다 */
	@Override
	public int getAtk() {
		int nAtk = super.getAtk();
		return (m_oWeapon_Equip != null) ? nAtk + m_oWeapon_Equip.getAtk() : nAtk;
	}
	
	/** 소지 금액을 변경한다 */
	public void setMoney(int a_nMoney) {
		m_nMoney = a_nMoney;
	}
	
	/** 무기를 변경한다 */
	public void setWeapon(CWeapon a_oWeapon) {
		m_oWeapon_Equip = a_oWeapon;
	}
}

/**
 * 몬스터
 */
class CMonster extends CUnit {
	/** 생성자 */
	public CMonster(int a_nHp, int a_nAtk, int a_nDef) {
		super(a_nHp, a_nAtk, a_nDef);
	}
}
