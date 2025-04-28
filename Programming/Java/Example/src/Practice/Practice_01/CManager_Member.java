package Practice.Practice_01;

/**
 * 회원 관리자
 */
public class CManager_Member {
	private int m_nNumMembers = 0;
	private CMember[] m_oMembers = null;
	
	/** 생성자 */
	public CManager_Member() {
		m_oMembers = new CMember[5];
	}
	
	/** 회원을 추가한다 */
	public void addMember(CMember a_oMember) {
		// 배열이 가득 찼을 경宇
		if(m_nNumMembers >= m_oMembers.length) {
			CMember[] oMembers_New = new CMember[m_oMembers.length * 2];
			
			for(int i = 0; i < m_oMembers.length; ++i) {
				oMembers_New[i] = m_oMembers[i];
			}
			
			m_oMembers = oMembers_New;
		}
		
		m_oMembers[m_nNumMembers++] = a_oMember;
	}
	
	/** 회원을 제거한다 */
	public void removeMember(String a_oName) {
		int nResult = this.findMember_At(a_oName);
		
		// 회원이 없을 경우
		if(nResult < 0) {
			return;
		}
		
		for(int i = nResult; i < m_nNumMembers - 1; ++i) {
			m_oMembers[i] = m_oMembers[i + 1];
		}
		
		m_nNumMembers -= 1;
	}
	
	/** 회원을 탐색한다 */
	public CMember findMember(String a_oName) {
		int nResult = this.findMember_At(a_oName);
		return (nResult >= 0) ? m_oMembers[nResult] : null;
	}
	
	/** 회원 정보를 출력한다 */
	public void showMembers_All() {
		for(int i = 0; i < m_nNumMembers; ++i) {
			m_oMembers[i].showInfo();
			System.out.println();
		}
	}
	
	/** 회원을 탐색한다 */
	private int findMember_At(String a_oName) {
		for(int i = 0; i < m_nNumMembers; ++i) {
			String oName_Member = m_oMembers[i].getName();
			
			// 이름이 동일 할 경우
			if(a_oName.equals(oName_Member)) {
				return i;
			}
		}
		
		return -1;
	}
}
