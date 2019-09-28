package chapter15practices;

/* Create a method that takes an array of BerylliumSphere as an argument.
 * Call the method, creating the argument dynamically. Demonstrate that 
 * ordinary aggregate array intitialization doesn't work in this case.
 * Discover the only situations where ordinary aggregate array initialization
 * works, and where dynamic aggregate array initialization is redundant.
 */
import java.util.*;

class A { public String toString() { return "A Object"; } }

class BerylliumSphere {
	private static long counter;
	private final long id = counter++;
	public String toString() { return "Sphere " + id; }
}
public class Ex1 {
	public static void test(BerylliumSphere[] a) { 
		System.out.println(Arrays.asList(a)); 		
	}
	public static <T> void test(T[] t) {
		System.out.println(Arrays.asList(t));
	}
	public static void test(int[] ia) { 
		System.out.println(Arrays.toString(ia));				
	}

	public static void main(String[] args) {
		System.out.println("For objects, e.g., BerylliumSpheres:");
		test(new BerylliumSphere[3]);
		test(new BerylliumSphere[]{ new BerylliumSphere(), new BerylliumSphere() });
		BerylliumSphere[] a = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
		test(a);
		BerylliumSphere[] bsa = new BerylliumSphere[2];		
		test(bsa);
		bsa = a; 
		test(bsa);
		System.out.println("-------------");	
		System.out.println("For primitives, e.g., int:");
		test(new int[]{ new Integer(0), new Integer(0) });
		test(new int[2]);
		int[] ia = { 1, 2, 3, };
		test(ia);
	}
}

/*Output:

For objects, e.g., BerylliumSpheres:
[null, null, null]
[Sphere 0, Sphere 1]
[Sphere 2, Sphere 3, Sphere 4]
[null, null]
[Sphere 2, Sphere 3, Sphere 4]
-------------
For primitives, e.g., int:
[0, 0]
[0, 0]
[1, 2, 3]

 */