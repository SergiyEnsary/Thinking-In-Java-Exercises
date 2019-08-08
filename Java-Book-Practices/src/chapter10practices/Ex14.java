package chapter10practices;

import java.util.*;
/* Create an empty LlinkedList<Integer>. Using a ListIterator, add Integers
 * to the list by always inserting them in the middle of the list.
 */

public class Ex14 {
	static void addMiddle(LinkedList<Integer> list, Integer[] array) {

		for(Integer i : array) {
			ListIterator<Integer> iterator = list.listIterator((list.size())/2);
			iterator.add(i);
			System.out.println(list);
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
		Ex14.addMiddle(list, x);
	}	
}