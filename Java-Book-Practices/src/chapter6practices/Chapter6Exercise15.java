package chapter6practices;
/*Chapter 6
 * Exercise 15:    (2) Create a class inside a package. Your class should contain a protected method. Outside of
 *       the package, try to call the protected method and explain the results. Now inherit from your class and
 *       call the protected method from inside a method of your derived class.
 */

import outsidePackage.AClass;

public class Chapter6Exercise15 {
	public static void main(String[]args) {
		 AClass aClass = new AClass();
		 AnotherClass anotherClass = new AnotherClass();
		// aClass.protectedMethod();
		 anotherClass.callProtectedMethod();
	}
}
