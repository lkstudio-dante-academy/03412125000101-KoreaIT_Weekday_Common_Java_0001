package Training.Training_04;

import java.net.ServerSocket;

/**
 * 서버
 */
public class CServer {
	private ServerSocket m_oServer = null;
	
	/** 서버를 실행한다 */
	public void run() {
		try {
			m_oServer = new ServerSocket(19080);
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
