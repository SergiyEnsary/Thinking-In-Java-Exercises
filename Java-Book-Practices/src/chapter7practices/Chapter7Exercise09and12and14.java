package chapter7practices;
/*	Chapter 7
 * Exercise 9:  (3) Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster, etc. In the base class,
 *      provide methods that are common to all Rodents, and override these in the derived classes to perform
 *      different behaviors depending on the specific type of Rodent. Create an array of Rodent, fill it with
 *      different specific types of Rodents, and call your base-class methods to see what happens.
 * 
 * Exercise 12:    (3) Modify Exercise 9 so that it demonstrates the order of initialization of the base classes
 *      and derived classes. Now add member objects to both the base and derived classes, and show the order in
 *      which their initialization occurs during construction.
 * Exercise 14:    (4) Modify Exercise 12 so that one of the member objects is a shared object with reference
 *      counting, and demonstrate that it works properly.
 */
public class Chapter7Exercise09and12and14 {
	public static void main(String[] args) {

		Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};

		for (Rodent rodent : rodents) {
			rodent.move();
			rodent.gnaw();
		}
		//Ex12
		for (Rodent rodent : rodents) {
			rodent.dispose();
		}
	}
}
