package Example.Example_17;

/**
 * Example 17 (쓰레드)
 */
public class CE01Example_17 {
	/** 초기화 */
	public static void start(String[] args) {
		Thread oThreadA = new Thread(() -> {
			for(int i = 0; i < 10000; ++i) {
				System.out.println("Thread A");
			}
		});
		
		Thread oThreadB = new Thread(() -> {
			for(int i = 0; i < 10000; ++i) {
				System.out.println("Thread B");
			}
		});
		
		oThreadA.start();
		oThreadB.start();
		
		try {
			oThreadA.join();
			oThreadB.join();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
