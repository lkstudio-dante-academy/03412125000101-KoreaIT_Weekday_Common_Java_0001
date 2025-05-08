package Training.Training_03;

/*
 * Java 연습 문제 3
 * - 에코 서버 제작하기
 * - 사용자의 메세지에 응답하는 에코 서버 제작하기
 *
 * Ex)
 * 메세지 입력 : Hello, World!
 * 서버 수신 메세지 : Hello, World!
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Training 3
 */
public class CT01Training_03 {
	/** 초기화 */
	public static void start(String[] args) {
		Thread oThread_Server = new Thread(CT01Training_03::main_Server);
		Thread oThread_Client = new Thread(CT01Training_03::main_Client);
		
		oThread_Server.start();
		oThread_Client.start();
		
		try {
			oThread_Server.join();
			oThread_Client.join();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 서버 쓰레드 진입 메서드 */
	private static void main_Server() {
		try {
			ServerSocket oServer = new ServerSocket(19080);
			
			Socket oClient = oServer.accept();
			InputStream oRStream = oClient.getInputStream();
			OutputStream oWStream = oClient.getOutputStream();
			
			byte[] oBytes = new byte[Short.MAX_VALUE];
			int nNumBytes = oRStream.read(oBytes, 0, oBytes.length);
			
			oWStream.write(oBytes, 0, nNumBytes);
			
			oClient.close();
			oServer.close();
		} catch(Exception oExcetpion) {
			oExcetpion.printStackTrace();
		}
	}
	
	/** 클라이언트 쓰레드 진입 메서드 */
	private static void main_Client() {
		try {
			Socket oSocket = new Socket();
			oSocket.connect(new InetSocketAddress("127.0.0.1", 19080));
			
			Scanner oScanner = new Scanner(System.in);
			
			System.out.print("메세지 입력 : ");
			String oMsg = oScanner.nextLine();
			
			OutputStream oWStream = oSocket.getOutputStream();
			InputStream oRStream = oSocket.getInputStream();
			
			oWStream.write(oMsg.getBytes(), 0, oMsg.getBytes().length);
			
			byte[] oBytes = new byte[Short.MAX_VALUE];
			int nNumBytes = oRStream.read(oBytes, 0, oBytes.length);
			
			String oMsg_Server = new String(oBytes, 0, nNumBytes);
			System.out.printf("서버 수신 메세지 : %s\n", oMsg_Server);
			
			oSocket.close();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
