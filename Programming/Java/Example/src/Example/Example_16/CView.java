package Example.Example_16;

import javax.swing.*;
import java.awt.*;

/**
 * 뷰
 */
public class CView {
	private JButton m_oBtn_Add = null;
	private JButton m_oBtn_Remove = null;
	private JButton m_oBtn_Search = null;
	
	private JTextField m_oInput_Title = null;
	private JTextField m_oInput_Author = null;
	
	private JList<Object> m_oList = null;
	private DefaultListModel<Object> m_oListModel = null;
	
	/** 초기화 */
	public void init(DefaultListModel<Object> a_oListModel) {
		this.m_oListModel = a_oListModel;
		
		this.setupUIs_List();
		this.setupUIs_Input();
	}
	
	/** 리스트를 반환한다 */
	public JList<Object> getList() {
		return m_oList;
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
	
	/** 제목 입력 필드를 반환한다 */
	public JTextField getInput_Title() {
		return m_oInput_Title;
	}
	
	/** 저자 입력 필드를 반환한다 */
	public JTextField getInput_Author() {
		return m_oInput_Author;
	}
	
	/** 리스트 UI 를 설정한다 */
	private void setupUIs_List() {
		m_oList = new JList<Object>(m_oListModel);
		JScrollPane oPanel_Scroll = new JScrollPane(m_oList);
		
		CApp.getInst().getWnd().add(oPanel_Scroll, BorderLayout.CENTER);
	}
	
	/** 입력 UI 를 설정한다 */
	private void setupUIs_Input() {
		JPanel oPanel = new JPanel(new GridLayout(5, 1, 0, 3));
		CApp.getInst().getWnd().add(oPanel, BorderLayout.SOUTH);
		
		JPanel oPanel_Title = new JPanel(new GridLayout(1, 2));
		oPanel_Title.add(new JLabel("제목 : "));
		
		m_oInput_Title = new JTextField();
		oPanel_Title.add(m_oInput_Title);
		
		JPanel oPanel_Author = new JPanel(new GridLayout(1, 2));
		oPanel_Author.add(new JLabel("저자 : "));
		
		m_oInput_Author = new JTextField();
		oPanel_Author.add(m_oInput_Author);
		
		m_oBtn_Add = new JButton("도서 추가");
		m_oBtn_Remove = new JButton("도서 제거");
		m_oBtn_Search = new JButton("도서 검색");
		
		oPanel.add(oPanel_Title);
		oPanel.add(oPanel_Author);
		
		oPanel.add(m_oBtn_Add);
		oPanel.add(m_oBtn_Remove);
		oPanel.add(m_oBtn_Search);
	}
}
