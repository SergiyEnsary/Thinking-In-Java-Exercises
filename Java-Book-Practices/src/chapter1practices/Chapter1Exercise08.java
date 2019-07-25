package chapter1practices;
/*	Chapter 1
 *  Exercise 8:  (3) Write a program that demonstrates that, no matter how many objects you create of a
 *      particular class, there is only one instance of a particular static field in that class.
 */
public class Chapter1Exercise08 {
	private static int i = 20;

	public static void main(String[] args) {
		class Incrementable{
			void increment() { Chapter1Exercise08.i++; }
		}
		Incrementable sf1 = new Incrementable();
		sf1.increment();
		System.out.println(Chapter1Exercise08.i);
		Incrementable sf2 = new Incrementable();
		sf2.increment();
		Incrementable sf3 = new Incrementable();
		sf3.increment();
		System.out.println(Chapter1Exercise08.i);
	}
}
