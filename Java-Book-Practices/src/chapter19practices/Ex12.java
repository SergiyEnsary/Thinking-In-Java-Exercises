package chapter19practices;

//Repair AtomicityTest.java using the synchronized keyword. 
//Can you demonstrate that it is now correct?


import java.util.concurrent.*;

public class Ex12 implements Runnable {
	private int i = 0;
	public synchronized int getValue() { return i; }
	private synchronized void evenIncrement() { i++; i++; } 
	public void run() {
		while(true) {
			evenIncrement();
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Ex12 at = new Ex12();
		exec.execute(at);
		while(true) {
			int val = at.getValue();
			if(val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}