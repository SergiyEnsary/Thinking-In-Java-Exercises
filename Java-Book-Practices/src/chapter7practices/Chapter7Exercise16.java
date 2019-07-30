package chapter7practices;
/*	Chapter 7
 * Exercise 16:    (3) Following the example in Transmogrify.java, create a Starship class containing an
 *      AlertStatus reference that can indicate three different states. Include methods to change the states.
 *
 *      @see Starship
 *      @see AlertStatus
 *      @see GreenAlert
 *      @see YellowAlert
 *      @see RedAlert
 */
public class Chapter7Exercise16 {
	public static void main(String[] args) {
		Starship starship = new Starship();
		starship.status();
		starship.changeStatus();
		starship.status();
		starship.changeStatus();
		starship.status();
		starship.changeStatus();
		starship.status();
	}
}
