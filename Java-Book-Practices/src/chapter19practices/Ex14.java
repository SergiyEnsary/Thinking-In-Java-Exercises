package chapter19practices;

/** Demonstrate that java.util.Timer scales to large numbers by 
 * creating a program that generates many Timer objects that perform
 * some simple task when the timeout completes.
 **/

import java.util.*;
import java.util.concurrent.*;
public class Ex14 implements Runnable {
	private static int timers = 0;
	private static int tasks = 0;
	public void run() {
		try {
			while(timers < 4000) {
				++timers;
				Timer t = new Timer();		
				t.schedule(new TimerTask() {
					public void run() {
						++tasks; 
						if(timers % 100 == 0)		
							System.out.println(timers + " timers did " 
									+ tasks + " tasks");
					}
				}, 0);
				try {
					TimeUnit.MILLISECONDS.sleep(30);
				} catch(InterruptedException e) {
					System.out.println("Sleep interrupted");
				}
				t.cancel();
			}
		} finally {
			System.out.println("Done. " + timers + " timers completed " 
					+ tasks + " tasks");
		} 
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Ex14());
		exec.shutdown();
	}
}

/*Output:

100 timers did 100 tasks
200 timers did 200 tasks
300 timers did 300 tasks
400 timers did 400 tasks
500 timers did 500 tasks
600 timers did 600 tasks
700 timers did 700 tasks
800 timers did 800 tasks
900 timers did 900 tasks
1000 timers did 1000 tasks
1100 timers did 1100 tasks
1200 timers did 1200 tasks
1300 timers did 1300 tasks
1400 timers did 1400 tasks
1500 timers did 1500 tasks
1600 timers did 1600 tasks
1700 timers did 1700 tasks
1800 timers did 1800 tasks
1900 timers did 1900 tasks
2000 timers did 2000 tasks
2100 timers did 2100 tasks
2200 timers did 2200 tasks
2300 timers did 2300 tasks
2400 timers did 2400 tasks
2500 timers did 2500 tasks
2600 timers did 2600 tasks
2700 timers did 2700 tasks
2800 timers did 2800 tasks
2900 timers did 2900 tasks
3000 timers did 3000 tasks
3100 timers did 3100 tasks
3200 timers did 3200 tasks
3300 timers did 3300 tasks
3400 timers did 3400 tasks
3500 timers did 3500 tasks
3600 timers did 3600 tasks
3700 timers did 3700 tasks
3800 timers did 3800 tasks
3900 timers did 3900 tasks
4000 timers did 4000 tasks
Done. 4000 timers completed 4000 tasks

 */