package chapter19practices;

//Create a radiation counter that can have any number of remote sensors.

import java.util.concurrent.*;
import java.util.*;

class RadCount {
	private int count = 0;
	private Random rand = new Random();
	public synchronized int increment() {
		return count++;
	}
	public synchronized int value() { return count; } 
}

class Sensor implements Runnable {
	private static RadCount count = new RadCount();
	private static List<Sensor> sensors = new ArrayList<Sensor>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	public static void cancel() { canceled = true; }
	public Sensor(int id) {
		this.id = id;
		sensors.add(this);
	}
	public void run() {
		while(!canceled) {
			synchronized(this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(25);
			} catch(InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
		System.out.println("Stopping " + this);
	}
	public synchronized int getValue() { return number; }
	public String toString() {
		return "Sensor " + id + ": " + getValue();
	} 
	public static int getTotalCount() {
		return count.value();
	}
	public static int sumSensors() {
		int sum = 0;
		for(Sensor sensor : sensors)
			sum += sensor.getValue();
		return sum;
	}
}

public class Ex17 {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++)
			exec.execute(new Sensor(i));
		TimeUnit.SECONDS.sleep(4);
		Sensor.cancel();
		exec.shutdown();
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			System.out.println("Some tasks were not terminated");
		System.out.println("Total: " + Sensor.getTotalCount());
		System.out.println("Sum of Sensors: " + Sensor.sumSensors());
	}
}

/*Output(Shortened):

Sensor 0: 1 Total: 0
Sensor 2: 1 Total: 1
Sensor 1: 1 Total: 2
Sensor 3: 1 Total: 3
Sensor 4: 1 Total: 4
Sensor 5: 1 Total: 5
Sensor 6: 1 Total: 6
Sensor 7: 1 Total: 7
Sensor 8: 1 Total: 8
Sensor 9: 1 Total: 9
Sensor 0: 2 Total: 10
Sensor 2: 2 Total: 11
Sensor 1: 2 Total: 12
Sensor 3: 2 Total: 13
Sensor 4: 2 Total: 14
Sensor 5: 2 Total: 15
Sensor 6: 2 Total: 16
Sensor 7: 2 Total: 17
...
Sensor 3: 158 Total: 1578
Sensor 5: 158 Total: 1576
Sensor 7: 158 Total: 1575
Sensor 1: 158 Total: 1574
Sensor 4: 158 Total: 1579
Sensor 0: 159 Total: 1580
Sensor 6: 159 Total: 1581
Sensor 9: 159 Total: 1582
Sensor 8: 159 Total: 1584
Sensor 2: 159 Total: 1583
Sensor 5: 159 Total: 1586
Sensor 7: 159 Total: 1587
Sensor 3: 159 Total: 1585
Sensor 1: 159 Total: 1588
Sensor 4: 159 Total: 1589
Stopping Sensor 6: 159
Stopping Sensor 8: 159
Stopping Sensor 2: 159
Stopping Sensor 5: 159
Stopping Sensor 9: 159
Stopping Sensor 0: 159
Stopping Sensor 4: 159
Stopping Sensor 1: 159
Stopping Sensor 7: 159
Stopping Sensor 3: 159
Total: 1590
Sum of Sensors: 1590

*/