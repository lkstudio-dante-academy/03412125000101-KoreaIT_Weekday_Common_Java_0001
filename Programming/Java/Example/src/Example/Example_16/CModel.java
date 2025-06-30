package Example.Example_16;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 모델
 */
public class CModel {
	private List<CBook> m_oListBooks = new ArrayList<>();
	private DefaultListModel<Object> m_oListModel = new DefaultListModel<>();
	
	/** 리스트 모델을 반환한다 */
	public DefaultListModel<Object> getListModel() {
		return m_oListModel;
	}
	
	/** 도서를 추가한다 */
	public void addBook(CBook a_oBook) {
		m_oListBooks.add(a_oBook);
		m_oListModel.addElement(a_oBook.toString());
	}
	
	/** 도서를 제거한다 */
	public void removeBook(String a_oTitle) {
		int nResult = this.findBook_At(a_oTitle);
		
		// 도서 제거가 불가능 할 경우
		if(nResult < 0) {
			return;
		}
		
		m_oListBooks.remove(nResult);
		m_oListModel.removeElementAt(nResult);
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
