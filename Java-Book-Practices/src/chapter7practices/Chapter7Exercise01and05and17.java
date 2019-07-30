package chapter7practices;
/*	Chapter 7
 * 
 * Exercise 1:   (2) Create a Cycle class, with subclasses UniCycle, Bicycle and Tricycle. Demonstrate that an
 *      instance of each type can be upcast to Cycle via a ride( ) method.
 * 
 * Exercise 5:  (1) Starting from Exercise 1, add a wheels( ) method in Cycle, which returns the number of
 *      wheels. Modify ride( ) to call wheels( ) and verify that polymorphism works.
 *      
 * Exercise 17:    (2) Using the Cycle hierarchy from Exercise 1, add a balance( ) method to Unicycle and
 *      Bicycle, but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle.
 *      Try to call balance( ) on each element of the array and observe the results. Downcast and call
 *      balance( ) and observe what happens.
 */
public class Chapter7Exercise01and05and17 {
	public static void main(String[] args) {
		Cycle cycle = new Cycle();
		UniCycle uniCycle = new UniCycle();
		Tricycle tricycle = new Tricycle();
		Bicycle bicycle = new Bicycle();

		cycle.ride(uniCycle);
		cycle.ride(tricycle);
		cycle.ride(bicycle);
		
		//Exercise 17
		Cycle[] cycles = {new UniCycle(),new Bicycle(),new Tricycle()};
		for (Cycle cycle1 : cycles) {
			cycle1.balance();
		}
	}
}
