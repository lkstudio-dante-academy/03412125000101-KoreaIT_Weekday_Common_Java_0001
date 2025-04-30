package Example.Example_16;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * 컨트롤러
 */
public class CController {
	private CView m_oView = null;
	private CModel m_oModel = null;
	
	/** 생성자 */
	public CController(CView a_oView, CModel a_oModel) {
		this.m_oView = a_oView;
		this.m_oModel = a_oModel;
		
		this.m_oView.init(this.m_oModel.getListModel());
		this.setupHandlers_View();
	}
	
	/** 뷰 핸들러를 설정한다 */
	private void setupHandlers_View() {
		m_oView.getBtn_Add().addActionListener(this::handleOnTouch_AddBtn);
		m_oView.getBtn_Remove().addActionListener(this::handleOnTouch_RemoveBtn);
		m_oView.getBtn_Search().addActionListener(this::handleOnTouch_SearchBtn);
	}
	
	/** 추가 버튼을 처리한다 */
	private void handleOnTouch_AddBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		JTextField oInput_Author = m_oView.getInput_Author();
		
		String oTitle = oInput_Title.getText();
		String oAuthor = oInput_Author.getText();
		
		// 항목이 비어 있을 경우
		if(oTitle.isEmpty() || oAuthor.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 or 저자 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oTitle);
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			String oMsg = String.format("%s 이(가) 이미 존재합니다.", oTitle);
			JOptionPane.showMessageDialog(null, oMsg, "알림", JOptionPane.INFORMATION_MESSAGE);
		} else {
			m_oModel.addBook(new CBook(oTitle, oAuthor));
		}
	}
	
	/** 제거 버튼을 처리한다 */
	private void handleOnTouch_RemoveBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		String oTitle = oInput_Title.getText();
		
		// 항목이 비어 있을 경우
		if(oTitle.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oTitle);
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			m_oModel.removeBook(oInput_Title.getText());
		} else {
			String oMsg = String.format("%s 은(는) 존재하지 않습니다.", oTitle);
			JOptionPane.showMessageDialog(null, oMsg, "알림", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/** 검색 버튼을 눌렀을 경우 */
	private void handleOnTouch_SearchBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		String oTitle = oInput_Title.getText();
		
		// 항목이 비어 있을 경우
		if(oTitle.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oTitle);
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			int nResult = m_oModel.findBook_At(oTitle);
			m_oView.getList().setSelectedIndex(nResult);
		} else {
			String oMsg = String.format("%s 은(는) 존재하지 않습니다.", oTitle);
			JOptionPane.showMessageDialog(null, oMsg, "알림", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
