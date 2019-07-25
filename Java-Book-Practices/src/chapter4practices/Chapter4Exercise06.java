package chapter4practices;

import chapter2practices.Dog;

/*	Chapter 4
 * Exercise 6:  (1) Modify the previous exercise so that two of the overloaded methods have two arguments
 *      (of two different types), but in reversed order relative to each other. Verify that this works.
 */
public class Chapter4Exercise06 {
	public static void main(String [] args) {
		Dog aDog = new Dog("Rex", "Ruff");
		aDog.fetch(3, "sticks");
        aDog.fetch("sticks", 4);
	}
}
