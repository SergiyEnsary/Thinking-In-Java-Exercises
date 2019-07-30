package chapter6practices;
/*	Chapter6
 * Exercise 18:    (2) Create a class with a static final field and a final field and demonstrate the
 *      difference between the two.
 */
public class Chapter6Exercise18 {
	static final int ONE = 1;
    final int TWO = 2;
	public static void main(String[] args) {
		Chapter6Exercise18 exercisesSix = new Chapter6Exercise18();
		System.out.println(Chapter6Exercise18.ONE);
		System.out.println(exercisesSix.TWO);
	}
}
