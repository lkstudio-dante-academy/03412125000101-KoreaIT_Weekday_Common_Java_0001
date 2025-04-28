package Example.Example_16;

import javax.swing.*;

/**
 * 어플리케이션
 */
public class CApp {
	private JFrame m_oFrame_Wnd = null;
	
	/** 생성자 */
	public CApp(int a_nWidth, int a_nHeight) {
		m_oFrame_Wnd = new JFrame("Example_16");
		m_oFrame_Wnd.setSize(a_nWidth, a_nHeight);
		m_oFrame_Wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** 앱을 실행한다 */
	public void run() {
		m_oFrame_Wnd.setVisible(true);
	}
}
