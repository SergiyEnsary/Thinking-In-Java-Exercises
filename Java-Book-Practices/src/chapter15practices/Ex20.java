package chapter15practices;

//Demonstrate deepEquals() for multidimensional arrays.
import java.util.*;

class A20 {}

public class Ex20 {
	public static void main(String[] args) {
		int[][][] a1 = new int[4][3][2];
		int[][][] a2 = new int[4][3][2];
		System.out.println(Arrays.deepToString(a1));
		System.out.println(Arrays.deepEquals(a1, a2));
		A20[][][] aa1 = new A20[4][3][2];
		A20[][][] aa2 = new A20[4][3][2];
		System.out.println(Arrays.deepToString(aa1));
		System.out.println(Arrays.deepEquals(aa1, aa2));
		System.out.println(Arrays.deepEquals(a1, aa1));	
	}
}

/*Output:

[[[0, 0], [0, 0], [0, 0]], [[0, 0], [0, 0], [0, 0]], [[0, 0], [0, 0], [0, 0]], [[0, 0], [0, 0], [0, 0]]]
true
[[[null, null], [null, null], [null, null]], [[null, null], [null, null], [null, null]], [[null, null], [null, null], [null, null]], [[null, null], [null, null], [null, null]]]
true
false

 */