package chapter2practices;
/* Chapter 2
 * Exercise 3:  (1) Create a class containing a float and use it to demonstrate aliasing during method calls.
 */
public class Chapter2Exercise03 {
	
	public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
	}

	private static void f(Letter x) {
		x.c = 'z';
		
	}
}
