package chapter10practices;

/* Create and populate a List<Integer>. Create a second List<Integer> of the
 * same size as the first, and use ListIterator to read elements of the first
 * List and insert them into the second in reverse order. (You may want to 
 * explore a number of different ways to solve this problem.)
 */
import java.util.*;

public class Ex12 {
	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
		ListIterator<Integer> it1 = list1.listIterator();
		ListIterator<Integer> it2 = list2.listIterator();
		System.out.println("li1: " + list1);
		System.out.println("li2: " + list2);

		while(it1.hasNext()) {
			it1.next();
		}

		while(it2.hasNext()) {	
			it2.next();		
			it2.set(it1.previous());
		}

		System.out.println("li1: " + list1);
		System.out.println("li2: " + list2);

	}
}
