package chapter15practices;

//Demonstrate that multidimensional arrays of non-primitives are
//automatically initialized to null.
import java.util.*;

public class Ex5 {
	public static void main(String[] args) {
		A[][][] a3 = new A[3][3][3];
		System.out.println(Arrays.deepToString(a3));		
	}
}

/*Output:

[[[null, null, null], [null, null, null], [null, null, null]], [[null, null, null], [null, null, null], [null, null, null]], [[null, null, null], [null, null, null], [null, null, null]]]

*/