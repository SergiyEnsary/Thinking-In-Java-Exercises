package chapter19practices;

//Modify SimplePriorities.java so that a custom ThreadFactory
//sets the priorities of the threads.

import java.util.concurrent.*;
import java.util.*;
import static java.lang.Thread.*;

class SimplePriorities9ThreadFactory implements ThreadFactory {
	Random rand = new Random();
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		int i = rand.nextInt(3);
		switch(i) {
			case 0 : t.setPriority(MIN_PRIORITY); break;
			case 1 : t.setPriority(NORM_PRIORITY); break;
			case 2 : t.setPriority(MAX_PRIORITY); break;
			default:	
		}
		return t;	
	}
}

public class Ex9 implements Runnable {
	private int countDown = 5;
	private volatile double d;
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}
	public void run() {
		while(true) {
			for(int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double)i;
				if(i % 1000 == 0)
					Thread.yield();
			} 
		System.out.println(this);
		if(--countDown == 0) return;
		}		
	}
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool(new SimplePriorities9ThreadFactory());
		for(int i = 0; i < 5; i++)
			exec.execute(new Ex9());
		exec.execute(new Ex9());
		exec.shutdown();
			
	}
}

/*Output:

Thread[Thread-3,5,main]: 5
Thread[Thread-0,1,main]: 5
Thread[Thread-1,5,main]: 5
Thread[Thread-2,5,main]: 5
Thread[Thread-4,10,main]: 5
Thread[Thread-5,10,main]: 5
Thread[Thread-3,5,main]: 4
Thread[Thread-4,10,main]: 4
Thread[Thread-0,1,main]: 4
Thread[Thread-1,5,main]: 4
Thread[Thread-2,5,main]: 4
Thread[Thread-5,10,main]: 4
Thread[Thread-4,10,main]: 3
Thread[Thread-3,5,main]: 3
Thread[Thread-0,1,main]: 3
Thread[Thread-5,10,main]: 3
Thread[Thread-1,5,main]: 3
Thread[Thread-2,5,main]: 3
Thread[Thread-4,10,main]: 2
Thread[Thread-5,10,main]: 2
Thread[Thread-3,5,main]: 2
Thread[Thread-0,1,main]: 2
Thread[Thread-1,5,main]: 2
Thread[Thread-2,5,main]: 2
Thread[Thread-4,10,main]: 1
Thread[Thread-5,10,main]: 1
Thread[Thread-3,5,main]: 1
Thread[Thread-0,1,main]: 1
Thread[Thread-1,5,main]: 1
Thread[Thread-2,5,main]: 1
*/