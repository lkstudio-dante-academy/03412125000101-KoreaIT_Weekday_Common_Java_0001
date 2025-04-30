package Example.Example_16;

/**
 * 도서
 */
public class CBook {
	private String m_oTitle = "";
	private String m_oAuthor = "";
	
	/** 생성자 */
	public CBook(String a_oTitle, String a_oAuthor) {
		this.m_oTitle = a_oTitle;
		this.m_oAuthor = a_oAuthor;
	}
	
	/** 제목을 반환한다 */
	public String getTitle() {
		return m_oTitle;
	}
	
	/** 저자를 반환한다 */
	public String getAuthor() {
		return m_oAuthor;
	}
	
	/** 정보를 반환한다 */
	@Override
	public String toString() {
		return String.format("%s (%s)", m_oTitle, m_oAuthor);
	}
}
