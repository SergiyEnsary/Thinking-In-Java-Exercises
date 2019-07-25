package chapter2practices;
/*Chapter 2
 * Exercise 13:(1) Write a method that displays char values in binary form. Demonstrate it using several
 *  different characters.
 */
public class Chapter2Exercise13 {
	public static void main(String [] args) {
		char c = 'a';
		System.out.println(Integer.toBinaryString(c));
		c = 'b';
		System.out.println(Integer.toBinaryString(c));
		c = 'c';
		System.out.println(Integer.toBinaryString(c));
		c = 'd';
		System.out.println(Integer.toBinaryString(c));
		c +=1;
		System.out.println(Integer.toBinaryString(c));
		c = 'A';
		System.out.println(Integer.toBinaryString(c));
		for(int f = 0; f < 26; f++) {
			c +=1;
			System.out.println(Integer.toBinaryString(c));
		}
	}
}