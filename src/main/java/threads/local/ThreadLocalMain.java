package threads.local;

public class ThreadLocalMain {
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			public void run() {
				// first threadLocal, attached on current thread and setting Foo
				ThreadLocalFooHolder.setFoo("thread1");
				System.out.println("inside r1 " +ThreadLocalFooHolder.getFoo());
				System.out.println("inside r1 " +ThreadLocalFooHolder.getFoo());
				System.out.println("finished");
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				
				System.out.println("inside r2 " +ThreadLocalFooHolder.getFoo());
				System.out.println("inside r2 " +ThreadLocalFooHolder.getFoo());
				System.out.println("finished");
			}
		};
		
		Thread t2= new Thread(r2);
		t2.start();
		
		Thread t1= new Thread(r1);
		t1.start();

	}
}
