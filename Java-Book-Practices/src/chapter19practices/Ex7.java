package chapter19practices;

//Experiment with different sleep times in Daemons.java to see what happens

import java.util.concurrent.*;

class Daemon implements Runnable {
	private Thread[] t = new Thread[30];
	public void run() {
		for(int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started, ");
		}
		for(int i = 0; i < t.length; i++)
			System.out.println("t[" + i + "].isDaemon() = " + 
					t[i].isDaemon() + ", ");
		while(true)
			Thread.yield();
	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		while(true)
			Thread.yield();
	}
}

public class Ex7 {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");

	}
}

/*Output:
 DaemonSpawn 0 started, 
DaemonSpawn 1 started, 
DaemonSpawn 2 started, 
DaemonSpawn 3 started, 
DaemonSpawn 4 started, 
DaemonSpawn 5 started, 
DaemonSpawn 6 started, 
DaemonSpawn 7 started, 
DaemonSpawn 8 started, 
DaemonSpawn 9 started, 
DaemonSpawn 10 started, 
DaemonSpawn 11 started, 
DaemonSpawn 12 started, 
DaemonSpawn 13 started, 
DaemonSpawn 14 started, 
DaemonSpawn 15 started, 
DaemonSpawn 16 started, 
DaemonSpawn 17 started, 
DaemonSpawn 18 started, 
DaemonSpawn 19 started, 
DaemonSpawn 20 started, 
DaemonSpawn 21 started, 
DaemonSpawn 22 started, 
DaemonSpawn 23 started, 
DaemonSpawn 24 started, 
DaemonSpawn 25 started, 
DaemonSpawn 26 started, 
DaemonSpawn 27 started, 
DaemonSpawn 28 started, 
DaemonSpawn 29 started, 
t[0].isDaemon() = true, 
t[1].isDaemon() = true, 
t[2].isDaemon() = true, 
t[3].isDaemon() = true, 
t[4].isDaemon() = true, 
t[5].isDaemon() = true, 
t[6].isDaemon() = true, 
t[7].isDaemon() = true, 
t[8].isDaemon() = true, 
t[9].isDaemon() = true, 
t[10].isDaemon() = true, 
t[11].isDaemon() = true, 
t[12].isDaemon() = true, 
t[13].isDaemon() = true, 
t[14].isDaemon() = true, 
t[15].isDaemon() = true, 
t[16].isDaemon() = true, 
t[17].isDaemon() = true, 
t[18].isDaemon() = true, 
t[19].isDaemon() = true, 
t[20].isDaemon() = true, 
t[21].isDaemon() = true, 
t[22].isDaemon() = true, 
t[23].isDaemon() = true, 
t[24].isDaemon() = true, 
t[25].isDaemon() = true, 
t[26].isDaemon() = true, 
t[27].isDaemon() = true, 
t[28].isDaemon() = true, 
t[29].isDaemon() = true, 
d.isDaemon() = true, 
 */
