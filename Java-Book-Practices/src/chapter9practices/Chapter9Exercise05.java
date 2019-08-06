package chapter9practices;

/* Create a class with an inner class. In a separate class, make an
 * instance of the inner class.
 */

public class Chapter9Exercise05 { 
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner outerInner = outer.new Inner();			
	}
}
