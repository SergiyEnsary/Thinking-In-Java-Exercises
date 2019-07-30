package chapter6practices;
/* Chapter 6
 * Exercise 14: (1) In Car.java add a service( ) method to Engine and call this method
 *				in main( ).
 */
public class Chapter6Exercise14 {
	public static void main(String[] args) {
		Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.changeOil();
	}
}
