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
		m_oView = a_oView;
		m_oModel = a_oModel;
		
		m_oView.getBtn_Add().addActionListener(this::handleOnTouch_AddBtn);
		m_oView.getBtn_Remove().addActionListener(this::handleOnTouch_RemoveBtn);
		m_oView.getBtn_Search().addActionListener(this::handleOnTouch_SearchBtn);
	}
	
	/** 추가 버튼을 눌렀을 경우 */
	private void handleOnTouch_AddBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		JTextField oInput_Author = m_oView.getInput_Author();
		
		// 입력 항목이 비어있을 경우
		if(oInput_Title.getText().isEmpty() || oInput_Author.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 or 저자 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oInput_Title.getText());
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			JOptionPane.showMessageDialog(null,
					String.format("%s 은(는) 이미 존재하는 도서입니다.", oInput_Title.getText()), "알림", JOptionPane.INFORMATION_MESSAGE);
		} else {
			oBook = new CBook(oInput_Title.getText(), oInput_Author.getText());
			m_oModel.addBook(oBook);
			
			m_oView.getList_Model().addElement(oBook.toString());
		}
	}
	
	/** 제거 버튼을 눌렀을 경우 */
	private void handleOnTouch_RemoveBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		
		// 입력 항목이 비어있을 경우
		if(oInput_Title.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oInput_Title.getText());
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			int nResult = m_oModel.findBook_At(oInput_Title.getText());
			m_oModel.removeBook(oInput_Title.getText());
			
			m_oView.getList_Model().removeElementAt(nResult);
		} else {
			JOptionPane.showMessageDialog(null,
					String.format("%s 은(는) 존재하지 않습니다.", oInput_Title.getText()), "알림", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/** 검색 버튼을 눌렀을 경우 */
	private void handleOnTouch_SearchBtn(ActionEvent a_oEvent) {
		JTextField oInput_Title = m_oView.getInput_Title();
		
		// 입력 항목이 비어있을 경우
		if(oInput_Title.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"제목 항목이 비어있습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
		
		CBook oBook = m_oModel.findBook(oInput_Title.getText());
		
		// 도서가 존재 할 경우
		if(oBook != null) {
			int nResult = m_oModel.findBook_At(oInput_Title.getText());
			m_oView.getList_Contents().setSelectedIndex(nResult);
		} else {
			JOptionPane.showMessageDialog(null,
					String.format("%s 은(는) 존재하지 않습니다.", oInput_Title.getText()), "알림", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
