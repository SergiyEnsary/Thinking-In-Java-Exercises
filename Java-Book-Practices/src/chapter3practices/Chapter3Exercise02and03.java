package chapter3practices;

import java.util.Random;

/*Chapter 3
 * Exercise 2:  (2) Write a program that generates 25 random int values. For each value, use an if-else
 *      statement to classify it as greater than, less than, or equal to a second randomly generated value.
 */
public class Chapter3Exercise02and03 {
	public static void main(String[] args) {
		Random rn = new Random();
		int newInt = 0;
		int oldInt = 0;

		for (int i = 0; i < 25; i++) {
			int num = rn.nextInt();
			if (num > oldInt){
				oldInt = num;
				newInt = oldInt;
				System.out.println(num + " greater than oldInt");
			} else {
				oldInt = newInt;
				newInt = num;
				System.out.println(num + " less than oldInt");
			}
		}
		/* Chapter 3
		 * Exercise 3:  (1) Modify Exercise 2 so that your code is surrounded by an 'infinite' while loop. It will then
		 *      run until you interrupt it from the keyboard (typically by pressing Control-C).
		 */
		while (true) {
			int num = rn.nextInt();
			if (num > oldInt){
				oldInt = num;
				newInt = oldInt;
				System.out.println(num + " greater than oldInt");
			} else {
				oldInt = newInt;
				newInt = num;
				System.out.println(num + " less than oldInt");
			}
		}
	}
}