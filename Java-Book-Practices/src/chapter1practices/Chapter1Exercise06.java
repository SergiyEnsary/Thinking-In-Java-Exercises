package chapter1practices;
/* Chapter 1
 * Exercise 6:  (2) Write a program that includes and calls the storage( ) method defined as a code fragment in
 *      this chapter.
 */

public class Chapter1Exercise06 {
	public static void main(String [] args) {

		System.out.println(Chapter1Exercise06.storage("four"));
	}

	private static int storage(String string) {
		return (string.length() * 2);
	}
}