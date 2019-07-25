package chapter4practices;

import chapter2practices.Dog;

/* Chapter 4
 * Exercise 5:  (2) Create a class called Dog with an overloaded bark( ) method. This method should be
 *      overloaded based on various primitive data types, and print different types of barking, howling, etc.,
 *      depending on which overloaded version is called. Write a main( ) that calls all the different versions.
 */
public class Chapter4Exercise05 {
	public static void main(String [] args) {
		 Dog dog = new Dog("Sparky", "Meow");
	        dog.bark();
	        dog.bark("Woof");
	}
}
