package chapter8practices;
/*
 * Exercise 3: (2) Create a base class with an abstract print( ) method that is overridden
 * in a derived class. The overridden version of the method prints the value of an int variable
 * defined in the derived class. At the point of definition of this variable, give it a nonzero value.
 * In the base-class constructor, call this method. In main( ), create an object of the derived
 * type, and then call its print( ) method. Explain the results.
 */
abstract class Dad03 {
	protected abstract void print();
	Dad03() { print(); }
}

class Son03 extends Dad03 {
	private int i = 1;
	@Override 
	protected void print() { System.out.println("Son.i = " + i); }
}

public class Chapter8Exercise03 {
	public static void main(String[] args) {
		/* Process of initialization:
		* 1. Storage for Son s allocated and initialized to binary zero
		* 2. Dad() called
		* 3. Son.print() called in Dad() (s.i = 0)
		* 4. Member initializers called in order (s.i = 1)
		* 5. Body of Son() called
		*/
		Son03 s = new Son03();
		s.print();
	}
}
