package chapter15practices;

//Show that the class from Exercise 19 can be searched.
import java.util.*;

class A24 implements Comparable<A24> {
	protected int x;
	A24(int x) { this.x = x; }
	public int compareTo(A24 b) {
		return (this.x < b.x ? -1 : (this.x == b.x ? 0 : 1));
	}
	public boolean equals(Object b) {
		return (b.getClass().getSimpleName() == "A24" && this.x == ((A24)b).x) ? true : false;
	}
}

public class Ex24 {
	public static void main(String[] args) {
		A24[] a = { new A24(1), new A24(2), new A24(3), new A24(4), new A24(5) };
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		int index = Arrays.binarySearch(a, new A24(3));
		System.out.println("Index: " + index + ", " + a[index]);
	}
}

/*Output:

[chapter15practices.A24@2f0e140b, chapter15practices.A24@7440e464, chapter15practices.A24@49476842, chapter15practices.A24@78308db1, chapter15practices.A24@27c170f0]
Index: 2, chapter15practices.A24@49476842

 */