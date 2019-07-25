package chapter2practices;
/* 
 * Chapter 2
 * Exercise 5:  (2) Create a class called Dog containing two Strings: name and says. In main( ), create two dog
 *      objects with names spot (who says, Ruff!) and scruffy (who says, Wurf!). Then display their
 *      names and what they say.
 */
public class Chapter2Exercise05and06 {
	public static void main(String[] args) {
		Dog spot = new Dog("spot", "Ruff!");
        Dog scruffy = new Dog("scruffy", "Wurf!");

        spot.speak();
        scruffy.speak();
        
        /*
         * Exercise 6:  (3) Following Exercise 5, create a new Dog reference and assign it to spots object. Test for
         *      comparison\ using == and equals( ) for all references.
         */
        Dog spike;

		spike = spot;
		System.out.println(spike == spot);
		System.out.println(spike.equals(spot));
	}
}
