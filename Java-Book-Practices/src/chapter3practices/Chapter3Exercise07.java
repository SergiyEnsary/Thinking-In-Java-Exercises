package chapter3practices;
/*Chapter 3
 * Exercise 7:  (1) Modify Exercise 1 so that the program exits by using the break keyword at value 99. Try
 *      using return instead.
 */
public class Chapter3Exercise07 {
	public static void main(String [] args) {

		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			if (i == 99) {
				break;
			}
		}


		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			if (i == 99) {
				return;					//"return" ends the loop but it gives out a value; break just stops the loop
			}
		}

	}
}