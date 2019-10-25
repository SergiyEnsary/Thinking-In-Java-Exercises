package chapter16practices;

/* Create a class containing two String objects and make it Comparable so
* that the comparison only cares about the first String. Fill an array
* and an ArrayList with objects of your class, using the RandomGenerator
* generator. Demonstrate that sorting works properly. Now make a 
* Comparator that only cares about the second String, and demonstrate
* that sorting works properly. Also perform a binary search using your
* Comparator.
*/

import java.util.*;
import chapter15practices.*;

public class Ex40 implements Comparable<Ex40> {
	private String first = "";
	private String second = "";
	public Ex40(String s1, String s2) {
		first = s1;
		second = s2;
	}
	public int compareTo(Ex40 ts) {
		return first.compareTo(ts.first);
	}
	public static class Comp2 implements Comparator<Ex40> {
		public int compare(Ex40 ts1, Ex40 ts2) {
			return ts1.second.compareTo(ts2.second);
		}
	}
	public String toString() {
		return first + " & " + second;
	}
	static void printArray(Ex40[] sa) {
		System.out.print("(");
		for(int i = 0; i < sa.length - 1; i++) 
			System.out.print(sa[i] + ", ");
		System.out.println(sa[sa.length - 1] + ")");		
	}
	public static void main(String[] args) {
		RandomGenerator.String rgs = new RandomGenerator.String(4);
		Ex40[] array = new Ex40[5];
		List<Ex40> list = new ArrayList<Ex40>();
		for(int i = 0; i < array.length; i++) {
			String s1 = rgs.next();
			String s2 = rgs.next();
			array[i] = new Ex40(s1, s2);
			list.add(new Ex40(s1, s2));
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
		Ex40.Comp2 comp = new Ex40.Comp2();
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
Array: (EcUO & neOE, QrGs & eGZM, YNzb & rnyG, cFOW & ZnTc, mJMR & oEsu)
List: [EcUO & neOE, QrGs & eGZM, YNzb & rnyG, cFOW & ZnTc, mJMR & oEsu]

Sorted by second word:
Array: (cFOW & ZnTc, QrGs & eGZM, EcUO & neOE, mJMR & oEsu, YNzb & rnyG)
List: [cFOW & ZnTc, QrGs & eGZM, EcUO & neOE, mJMR & oEsu, YNzb & rnyG]

*/