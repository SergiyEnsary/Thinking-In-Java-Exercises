package chapter1practices;
/* Chapter 1
 * Exercise 7:  (1) Turn the Incrementable code fragments into a working program.
 */
public class Chapter1Exercise07 {
	private static int i = 23;
	public static void main(String[] args) {
        increment();
        System.out.println(i);
	}
	public static void increment() {
		Chapter1Exercise07.i++;
	}
}
