package chapter10practices;

/* Create a class, then make an initialized array of objects of your class
 * Fill a List from your array. Create a subset of your List by using 
 * subList(), then remove this subset from your List.
 */

import java.util.*;

class Practice {
	public static int counter = 0;
	private int id = counter++;
	public String toString() { return String.valueOf(id); }	
}

public class Ex7 {
	public static void main(String[] args) {		
		Practice[] t = new Practice[10];
		for(int i = 0; i < t.length; i++)
			t[i] = new Practice();
		List<Practice> list = new ArrayList<Practice>();
		for(Practice x : t) list.add(x);
		System.out.println("list of Practice: " + list);
		List<Practice> sub = list.subList(2, 6);
		System.out.println("subList: " + sub);
		List<Practice> copy = new ArrayList<Practice>(list);
		copy.removeAll(sub);
		System.out.println("copy: " + copy);
		list = copy;
		System.out.println("list of Practice: " + list);
	}
}
