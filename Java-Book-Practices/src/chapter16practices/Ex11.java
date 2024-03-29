package chapter16practices;

/* Create a class that contains an Integer that is initialized 
 * to a value between 0 and 100 using java.util.Random. Implement
 * Comparable using this Integer field. Fill a PriorityQueue with 
 * objects of your class, and extract the values using poll() to 
 * show that it produces the expected order.
 */
import java.util.*;

class IntegerTest implements Comparable<IntegerTest> {
	Random r = new Random();
	Integer i = r.nextInt(100);
	public int compareTo(IntegerTest arg) {
		int d = this.i - arg.i;
		return d < 0 ? -1 : d == 0 ? 0 : 1;
	}
	public String toString() {
		return Integer.toString(i);
	}
}

public class Ex11 {
	public static void main(String[] args) {
		PriorityQueue<IntegerTest> pt = new PriorityQueue<IntegerTest>();
		for(int i = 0; i < 20; i++) {
			pt.add(new IntegerTest());
		}
		int size = pt.size();
		for(int i = 0; i < size; i++) {
			System.out.print(pt.poll() + " ");
		}
	}
} 

/*Output:

6 9 11 13 23 31 35 37 43 46 60 70 75 77 80 82 84 95 97 99 

*/