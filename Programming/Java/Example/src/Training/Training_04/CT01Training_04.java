package Training.Training_04;

/*
 * Java 연습 문제 4
 * - 채팅 서버 제작하기
 * - 다른 사용자와 메세지를 주고 받을 수 있는 채팅 서버 제작하기
 */

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Training 4
 */
public class CT01Training_04 {
	/** 초기화 */
	public static void start(String[] args) {
		try(ExecutorService oPool_Thread = Executors.newCachedThreadPool()) {
			oPool_Thread.execute(CT01Training_04::main_Client);
			
			// 서버 앱 일 경우
			if(args.length >= 1 && args[0].equals("Server")) {
				CServer oServer = new CServer();
				oPool_Thread.execute(oServer::run);
			}
			
			oPool_Thread.shutdown();
			oPool_Thread.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 클라이언트 메인 메서드 */
	private static void main_Client() {
		try(Socket oSocket = new Socket()) {
			oSocket.connect(new InetSocketAddress("127.0.0.1", 19080));
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
