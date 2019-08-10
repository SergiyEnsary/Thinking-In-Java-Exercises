package chapter10practices;

import java.util.*;
/* Fill a PriorityQueue (using offer()) with Double values created using 
 * java.util.Random, then remove the elements using poll() and display them.
 */

class Simple extends Object {}

public class Ex29 {
	public static void main(String[] args) {		
		PriorityQueue<Simple> simple = new PriorityQueue<Simple>();
		// OK to add one Simple:
		simple.offer(new Simple());
		// but no more allowed; get runtime exception: 
		// Simple cannot be cast to Comparable:
		simple.offer(new Simple());
	}
}
