package threads;

import org.springframework.util.StopWatch;


public class ThreadTester {

	public static void main(String[] args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("main task");
		ThreadTester tester = new ThreadTester();
		tester.serialProcessingSleep();
		//tester.sequentialSleep();
		stopWatch.stop();
		System.out.println("total time:" + stopWatch.getTotalTimeSeconds() + " s");

	}

	public void sequentialSleep() throws Exception {
		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			System.out.println("finished");
		}
	}

	public void serialProcessingSleep() throws Exception {
		Runnable r = new Runnable() {
			public void run() {
				try {
					System.out.println("starting");
					Thread.sleep(2000);
					System.out.println("finished");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread[] threads = new Thread[3];
		for (int i = 0; i < 3; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		System.out.println("everything is beeing started");
		for (int i = 0; i < 3; i++) {
			threads[i].join();
		}
		System.out.println("everything has been finished");
	}
}
