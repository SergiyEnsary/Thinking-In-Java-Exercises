package chapter16practices;

//Modify Exercise 40 so that an alphabetic sort is used.

import java.util.*;
import chapter15practices.*;

public class Ex42 implements Comparable<Ex42> {
	private String first = "";
	private String second = "";
	public Ex42(String s1, String s2) {
		first = s1;
		second = s2;
	}
	public int compareTo(Ex42 ts) {
		return first.compareToIgnoreCase(ts.first);
	}
	public static class Comp2 implements Comparator<Ex42> {
		public int compare(Ex42 ts1, Ex42 ts2) {
			return ts1.second.compareToIgnoreCase(ts2.second);
		}
	}
	public String toString() {
		return first + " & " + second;
	}
	static void printArray(Ex42[] sa) {
		System.out.print("(");
		for(int i = 0; i < sa.length - 1; i++) 
			System.out.print(sa[i] + ", ");
		System.out.println(sa[sa.length - 1] + ")");		
	}
	public static void main(String[] args) {
		RandomGenerator.String rgs = new RandomGenerator.String(4);
		Ex42[] array = new Ex42[5];
		List<Ex42> list = new ArrayList<Ex42>();
		for(int i = 0; i < array.length; i++) {
			String s1 = rgs.next();
			String s2 = rgs.next();
			array[i] = new Ex42(s1, s2);
			list.add(new Ex42(s1, s2));
		}
		System.out.print("Array: ");
		printArray(array);
		System.out.println("List: " + list);
		Arrays.sort(array);
		Collections.sort(list, null);
		System.out.println();
		System.out.println("Sorted by first word:");
		System.out.print("Array: ");
		printArray(array);
		System.out.println("List: " + list);
		Ex42.Comp2 comp = new Ex42.Comp2();
		Arrays.sort(array, comp);
		Collections.sort(list, comp);
		System.out.println();
		System.out.println("Sorted by second word:");
		System.out.print("Array: ");
		printArray(array);
		System.out.println("List: " + list);	
	}
}

/*Output:

Array: (YNzb & rnyG, cFOW & ZnTc, QrGs & eGZM, mJMR & oEsu, EcUO & neOE)
List: [YNzb & rnyG, cFOW & ZnTc, QrGs & eGZM, mJMR & oEsu, EcUO & neOE]

Sorted by first word:
Array: (cFOW & ZnTc, EcUO & neOE, mJMR & oEsu, QrGs & eGZM, YNzb & rnyG)
List: [cFOW & ZnTc, EcUO & neOE, mJMR & oEsu, QrGs & eGZM, YNzb & rnyG]

Sorted by second word:
Array: (QrGs & eGZM, EcUO & neOE, mJMR & oEsu, YNzb & rnyG, cFOW & ZnTc)
List: [QrGs & eGZM, EcUO & neOE, mJMR & oEsu, YNzb & rnyG, cFOW & ZnTc]

*/