package threads.local;

public class ThreadLocalFooHolder {
	private static final ThreadLocal<String> fooHolder = new ThreadLocal<String>();

	public static String getFoo() {
		return fooHolder.get();
	}

	public static void setFoo(String foo) {
		fooHolder.set(foo);
	}

}
