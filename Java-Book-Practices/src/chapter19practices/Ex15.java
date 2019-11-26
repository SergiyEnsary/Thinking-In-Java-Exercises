package chapter19practices;

/** Create a class with three methods containing critical sections
 * that all synchronize on the same object. Create multiple tasks to
 * demonstrate that only one of these methods can run at a time. Now
 * modify the methods so that each one synchronizes on a different 
 * object and show that all three methods can be runing at once. 
 **/

class SyncTest1 {
	public void f1() {
		synchronized(this) {
			for(int i = 0; i < 5; i++) {
				System.out.println("f1()");
				Thread.yield();
			}
		}
	}
	public void g1() {
		synchronized(this) {
			for(int i = 0; i < 5; i++) {
				System.out.println("g1()");
				Thread.yield();
			}
		}
	}
	public void h1() {
		synchronized(this) {
			for(int i = 0; i < 5; i++) {
				System.out.println("h1()");
				Thread.yield();
			}
		}
	}
}

class SyncTest2 {
	private Object syncObject1 = new Object();
	private Object syncObject2 = new Object();
	private Object syncObject3 = new Object();
	public void f2() {
		synchronized(syncObject1) {
			for(int i = 0; i < 5; i++) {
				System.out.println("f2()");
				Thread.yield();
			}
		}
	}
	public void g2() {
		synchronized(syncObject2) {
			for(int i = 0; i < 5; i++) {
				System.out.println("g2()");
				Thread.yield();
			}
		}
	}
	public void h2() {
		synchronized(syncObject3) {
			for(int i = 0; i < 5; i++) {
				System.out.println("h2()");
				Thread.yield();
			}
		}
	}
}

public class Ex15 {
	public static void main(String[] args) {
		final SyncTest1 st1 = new SyncTest1();
		final SyncTest2 st2 = new SyncTest2();
		new Thread() {
			public void run() {
				st1.f1();
			}
		}.start();
		new Thread() {
			public void run() {
				st1.g1();
			}
		}.start();
		new Thread() {
			public void run() {
				st1.h1();
			}
		}.start();		
		new Thread() {
			public void run() {
				st2.f2();
			}
		}.start();
		new Thread() {
			public void run() {
				st2.g2();
			}
		}.start();
		new Thread() {
			public void run() {
				st2.h2();
			}
		}.start();			
	}
}

/*Output:

f1()
f1()
f1()
f1()
f1()
g1()
g1()
g1()
g1()
g1()
h1()
h1()
h1()
h1()
h1()
f2()
f2()
f2()
f2()
f2()
g2()
g2()
g2()
g2()
g2()
h2()
h2()
h2()
h2()
h2()

*/