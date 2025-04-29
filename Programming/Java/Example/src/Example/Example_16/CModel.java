package Example.Example_16;

import java.util.ArrayList;
import java.util.List;

/**
 * 모델
 */
public class CModel {
	private List<CBook> m_oListBooks = new ArrayList<CBook>();
	
	/** 도서를 추가한다 */
	public void addBook(CBook a_oBook) {
		m_oListBooks.add(a_oBook);
	}
	
	/** 도서를 제거한다 */
	public void removeBook(String a_oTitle) {
		CBook oBook = this.findBook(a_oTitle);
		
		// 도서가 없을 경우
		if(oBook == null) {
			return;
		}
		
		m_oListBooks.remove(oBook);
	}
	
	/** 도서를 탐색한다 */
	public CBook findBook(String a_oTitle) {
		int nResult = this.findBook_At(a_oTitle);
		return (nResult >= 0) ? m_oListBooks.get(nResult) : null;
	}
	
	/** 도서를 탐색한다 */
	public int findBook_At(String a_oTitle) {
		for(int i = 0; i < m_oListBooks.size(); ++i) {
			// 제목이 동일 할 경우
			if(a_oTitle.equals(m_oListBooks.get(i).getTitle())) {
				return i;
			}
		}
		
		return -1;
	}
}
