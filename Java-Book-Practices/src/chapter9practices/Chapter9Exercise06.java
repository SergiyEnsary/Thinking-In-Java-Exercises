package chapter9practices;

import outsidePackage.Ex6;
import outsidePackage.Chapter8Ex6;

/* Create an interface with at least one method, in its own package. Create
 * a class in a separate package. Add a protected inner class that 
 * implements the interface. In a third package, inherit from your class and
 * inside a method, return an object of the protected inner class, upcasting
 * to the interface during the return.
 */

public class Chapter9Exercise06 extends Ex6 {
	Chapter8Ex6 getBaseInner() { 
		return this.new Ex6BaseInner();
	}
	public static void main(String[] args) {
		Chapter9Exercise06 ex = new Chapter9Exercise06();
		System.out.println(ex.getBaseInner().say());
	}	
}
