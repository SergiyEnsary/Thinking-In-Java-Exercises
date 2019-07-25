package chapter3practices;
/*Chapter 3
 * Exercise 8:  (2) Create a switch statement that prints a message for each case, and put the switch inside a
 *      for loop that tries each case. Put a break after each case and test it, then remove the breaks and see
 *      what happens.
 */
public class Chapter3Exercise08 {
	public static void main(String[] args) {
		for (int index = 0; index < 3; index++){
            switch (index) {
                case 0:
                    System.out.println("this is index " + index);
                    break;											//removing "break;" makes the program go through all cases
                case 1:
                    System.out.println("this is index " + index);
                    break;
                case 2:
                    System.out.println("this is index " + index);
            }
        }
	}
}
