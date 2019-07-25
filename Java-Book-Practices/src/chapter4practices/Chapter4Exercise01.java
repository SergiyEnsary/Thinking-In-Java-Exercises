package chapter4practices;
/*	Chapter 4
 * Exercise 1:   (1) Create a class containing an uninitialized String reference. Demonstrate that this
 *      reference is initialized by Java to null.
 */
public class Chapter4Exercise01 {
	
	public static void main(String [] args) {
		class EmptyString{
			String string;
		}
		EmptyString newString = new EmptyString();
		System.out.println(newString.string);
	}
}
