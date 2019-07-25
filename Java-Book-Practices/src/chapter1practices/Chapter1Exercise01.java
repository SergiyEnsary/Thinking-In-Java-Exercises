package chapter1practices;

/* Chapter 1
 * Exercise 1:   (2) Create a class containing an int and a char that are not initialized, and print their
 *      values to verify that Java performs default initialization.
 */
public class Chapter1Exercise01 {
    public static void main(String[] args) {
	class Init{
		int a;
		char ch;
	}
	Init data = new Init();
    System.out.println(data.a);
    System.out.println(data.ch);
    }
}