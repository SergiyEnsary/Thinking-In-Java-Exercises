package chapter15practices;

/* Create a class with an int field that's initialized from a constructor
 * argument. Create two arrays of these objects, using identical
 * intitialization values for each array, and show that Arrays.equals() says
 * that they are unequal. Add an equals() method to your class to fix the
 * problem.
 */
import java.util.*;

class A19 {
	protected int x;
	A19(int x) { this.x = x; }
	public boolean equals(Object b) {
		return (b.getClass().getSimpleName() == "A19" && this.x == ((A19)b).x) ? true : false;
	}
}

public class Ex19 {
	public static void main(String[] args) {
		A19[] a1 = { new A19(1), new A19(2), new A19(3) };
		A19[] a2 = { new A19(1), new A19(2), new A19(3) };
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.equals(a1, a2));
	}
}

/*Output:

[chapter15practices.A19@2f0e140b, chapter15practices.A19@7440e464, chapter15practices.A19@49476842]
[chapter15practices.A19@78308db1, chapter15practices.A19@27c170f0, chapter15practices.A19@5451c3a8]
false

 */