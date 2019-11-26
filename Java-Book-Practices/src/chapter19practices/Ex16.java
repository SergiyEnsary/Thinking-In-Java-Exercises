package chapter19practices;

//Modify Exercise 15 to use explicit Lock objects.


import java.util.concurrent.locks.*;

class SyncTesta {
	private Lock lock = new ReentrantLock();
	public void f1() {
		lock.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("f1()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}		
	}
	public void g1() {
		lock.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("g1()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}	
	}
	public void h1() {
		lock.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("h1()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}	
	}
}

class SyncTestb {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	private Lock lock3 = new ReentrantLock();

	public void f2() {
		lock1.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("f2()");
				Thread.yield();
			}
		} finally {
			lock1.unlock();
		}
	}
	public void g2() {
		lock2.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("g2()");
				Thread.yield();
			}
		} finally {
			lock2.unlock();
		}
	}
	public void h2() {
		lock3.lock();
		try {
			for(int i = 0; i < 5; i++) {
				System.out.println("h2()");
				Thread.yield();
			}
		} finally {
			lock3.unlock();
		}
	}
}

public class Ex16 {
	public static void main(String[] args) {
		final SyncTesta st1 = new SyncTesta();
		final SyncTestb st2 = new SyncTestb();
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
h1()
h1()
h1()
h1()
h1()
g1()
g1()
g1()
g1()
g1()
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