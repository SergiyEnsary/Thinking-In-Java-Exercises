package chapter5practices;

import outsidePackage.PackagedClass;

/*	Chapter 5
 * Exercise 1:  (1) Create a class in a package. Create an instance of your class outside of that package.
 */
public class Chapter5Exercise01 {
	public static void main(String[] args) {
		PackagedClass outsideClass = new PackagedClass();
	}
}
