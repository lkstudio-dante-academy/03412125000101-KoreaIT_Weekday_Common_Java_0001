package Example.Example_16;

import javax.swing.*;
import java.awt.*;

/**
 * 앱
 */
public class CApp {
	private JFrame m_oWnd = null;
	private CController m_oController = null;
	
	private static CApp m_oInst = null;
	
	/** 생성자 */
	public CApp(int a_nWidth, int a_nHeight) {
		m_oWnd = new JFrame("Example 16");
		m_oWnd.setSize(a_nWidth, a_nHeight);
		m_oWnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_oWnd.setLayout(new BorderLayout());
		
		CApp.m_oInst = this;
	}
	
	/** 윈도우를 반환한다 */
	public JFrame getWnd() {
		return m_oWnd;
	}
	
	/** 컨트롤러를 반환한다 */
	public CController getController() {
		return m_oController;
	}
	
	/** 인스턴스를 반환한다 */
	public static CApp getInst() {
		return CApp.m_oInst;
	}
	
	/** 앱을 구동 시킨다 */
	public void run() {
		CView oView = new CView();
		CModel oModel = new CModel();
		
		m_oController = new CController(oView, oModel);
		m_oWnd.setVisible(true);
	}
}
