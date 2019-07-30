package chapter7practices;
/* Chapter 7
 * Exercise 4:  (2) Add a new type of Shape to Shapes.java and verify in main( ) that polymorphism works for
 *      your new type as it does in the old types.
 */
public class Chapter7Exercise04 {
	public static void main(String[] args) {
        Shape octagon = new Octagon();
        System.out.println(octagon);
	}
}
