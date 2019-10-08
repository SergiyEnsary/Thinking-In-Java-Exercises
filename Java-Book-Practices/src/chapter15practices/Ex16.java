package chapter15practices;

/* Starting with CountingGenerator.java, create a SkipGenerator class
* that produces new values by incrementing according to a constructor 
* argument. Modify TestArrayGeneration.java to show that your new 
* class works correctly. 
*/

import java.util.*;

public class Ex16 {
	public static void main(String[] args) {
		int size = 6;
		int skip = 7;
		boolean[] a1 = ConvertTo.primitive(Generated16.array(new Boolean[size], new SkipGenerator16.Boolean(skip), skip));
		System.out.println("a1 = " + Arrays.toString(a1));
		byte[] a2 = ConvertTo.primitive(Generated16.array(new Byte[size], new SkipGenerator16.Byte(skip), skip));
		System.out.println("a2 = " + Arrays.toString(a2));
		char[] a3 = ConvertTo.primitive(Generated16.array(new Character[size], new SkipGenerator16.Character(skip), skip));
		System.out.println("a3 = " + Arrays.toString(a3));
		short[] a4 = ConvertTo.primitive(Generated16.array(new Short[size], new SkipGenerator16.Short(skip), skip));
		System.out.println("a4 = " + Arrays.toString(a4));
		int[] a5 = ConvertTo.primitive(Generated16.array(new Integer[size], new SkipGenerator16.Integer(skip), skip));
		System.out.println("a5 = " + Arrays.toString(a5));
		long[] a6 = ConvertTo.primitive(Generated16.array(new Long[size], new SkipGenerator16.Long(skip), skip));
		System.out.println("a6 = " + Arrays.toString(a6));
		float[] a7 = ConvertTo.primitive(Generated16.array(new Float[size], new SkipGenerator16.Float(skip), skip));
		System.out.println("a7 = " + Arrays.toString(a7));
		double[] a8 = ConvertTo.primitive(Generated16.array(new Double[size], new SkipGenerator16.Double(skip), skip));
		System.out.println("a8 = " + Arrays.toString(a8));
	}
}

/*Output:

a1 = [false, false, false, false, false, false]
a2 = [7, 14, 21, 28, 35, 42]
a3 = [h, p, x, F, N, V]
a4 = [7, 14, 21, 28, 35, 42]
a5 = [7, 14, 21, 28, 35, 42]
a6 = [7, 14, 21, 28, 35, 42]
a7 = [0.0, 7.0, 14.0, 21.0, 28.0, 35.0]
a8 = [0.0, 7.0, 14.0, 21.0, 28.0, 35.0]

*/