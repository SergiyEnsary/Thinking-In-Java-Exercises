package chapter2practices;
/*Chapter 2
 * Exercise 4:  (2) Write a program that calculates velocity using a constant distance and a constant time.
 */
public class Chapter2Exercise04 {
	public static void main(String[] args) {

		class Velocity {
			int distMiles = 8;
			int timeHours = 4;
		    Velocity() {
		        System.out.println(distMiles/timeHours + " miles per hour;");
		    }
		}
		Velocity velocity = new Velocity();
	}
}
