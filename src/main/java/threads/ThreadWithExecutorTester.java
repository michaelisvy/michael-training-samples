package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.util.StopWatch;


public class ThreadWithExecutorTester {
	private static ExecutorService executorService = Executors.newCachedThreadPool();

	public static void main(String[] args) throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("main task");
		ThreadWithExecutorTester tester = new ThreadWithExecutorTester();
		tester.serialProcessingSleep();
		//tester.sequentialSleep();
		System.out.println("everything is beeing started");
		executorService.shutdown();
		System.out.println("after shutdown");
		executorService.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("after shutdown");
		System.out.println("everything has been finished");
		
		stopWatch.stop();
		System.out.println("total time:" + stopWatch.getTotalTimeSeconds() + " s");

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
		for (int i = 0; i < 3; i++) {
			executorService.execute(r);
		}
	}
}
