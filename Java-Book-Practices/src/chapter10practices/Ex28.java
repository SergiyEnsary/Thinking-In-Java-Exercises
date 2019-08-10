package chapter10practices;

import java.util.*;
/* Fill a PriorityQueue (using offer()) with Double values created using 
 * java.util.Random, then remove the elements using poll() and display them.
 */

public class Ex28 {
	public static void main(String[] args) {
		Random random = new Random();
		PriorityQueue<Double> doble = new PriorityQueue<Double>();
		for(int index = 0; index < 10; index++) {
			doble.offer(random.nextDouble() * index);
		}
		while(doble.peek()!= null) {
			System.out.print(doble.poll() + " ");
		}
	}
}