package chapter1practices;
/* Chapter 1
 * Exercise 9:  (2) Write a program that demonstrates that autoboxing works for all the primitive types and
 *      their wrappers.
 */
public class Chapter1Exercise09 {
	public static void main(String [] args) {
		int i = 1;
		Integer I;
		I = i;
		System.out.println(I);

		boolean b = true;
		Boolean B;
		B = b;
		System.out.println(B);

		char ch = 'c';
		Character Ch;
		Ch = ch;
		System.out.println(Ch);

		byte by = 3;
		Byte By;
		By = by;
		System.out.println(By);

		short sh = 6;
		Short Sh;
		Sh = sh;
		System.out.println(Sh);

		long l = 9;
		Long L;
		L = l;
		System.out.println(L);

		float f = (float) 1.1;
		Float F;
		F = f;
		System.out.println(F);

		double d = 3.4;
		Double D;
		D = d;
		System.out.println(D);
	}
}
