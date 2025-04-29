package Example.Example_16;

import javax.swing.*;
import java.awt.*;

/**
 * 뷰
 */
public class CView {
	private DefaultListModel<Object> m_oListModel = new DefaultListModel<Object>();
	private JList<Object> m_oListContents = null;
	
	private JTextField m_oInput_Title = null;
	private JTextField m_oInput_Author = null;
	
	private JButton m_oBtn_Add = null;
	private JButton m_oBtn_Remove = null;
	private JButton m_oBtn_Search = null;
	
	/** 생성자 */
	public CView() {
		this.setupInputUI();
		m_oListContents = new JList<Object>(m_oListModel);
		
		CApp.getInst().getWnd().add(new JScrollPane(m_oListContents), BorderLayout.CENTER);
	}
	
	/** 모델 리스트를 반환한다 */
	public DefaultListModel<Object> getList_Model() {
		return m_oListModel;
	}
	
	/** 컨텐츠 리스트를 반환한다 */
	public JList<Object> getList_Contents() {
		return m_oListContents;
	}
	
	/** 제목 입력 필드를 반환한다 */
	public JTextField getInput_Title() {
		return m_oInput_Title;
	}
	
	/** 저자 입력 필드를 반환한다 */
	public JTextField getInput_Author() {
		return m_oInput_Author;
	}
	
	/** 추가 버튼을 반환한다 */
	public JButton getBtn_Add() {
		return m_oBtn_Add;
	}
	
	/** 제거 버튼을 반환한다 */
	public JButton getBtn_Remove() {
		return m_oBtn_Remove;
	}
	
	/** 검색 버튼을 반환한다 */
	public JButton getBtn_Search() {
		return m_oBtn_Search;
	}
	
	/** 입력 UI 를 설정한다 */
	private void setupInputUI() {
		JPanel oPanel = new JPanel(new GridLayout(5, 1, 0, 2));
		CApp.getInst().getWnd().add(oPanel, BorderLayout.SOUTH);
		
		JPanel oPanel_Title = new JPanel(new GridLayout(1, 2));
		oPanel.add(oPanel_Title);
		
		oPanel_Title.add(new JLabel("제목 : "));
		
		m_oInput_Title = new JTextField();
		oPanel_Title.add(m_oInput_Title);
		
		JPanel oPanel_Author = new JPanel(new GridLayout(1, 2));
		oPanel.add(oPanel_Author);
		
		oPanel_Author.add(new JLabel("저자 : "));
		
		m_oInput_Author = new JTextField();
		oPanel_Author.add(m_oInput_Author);
		
		m_oBtn_Add = new JButton("도서 추가");
		oPanel.add(m_oBtn_Add);
		
		m_oBtn_Remove = new JButton("도서 제거");
		oPanel.add(m_oBtn_Remove);
		
		m_oBtn_Search = new JButton("도서 검색");
		oPanel.add(m_oBtn_Search);
	}
}
