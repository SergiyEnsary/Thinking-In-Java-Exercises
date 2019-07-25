package chapter3practices;
/* Chapter 3
 * Exercise 4:  (3) Write a program that uses two nested for loops and the modulus operator (%) to detect and
 *      print prime numbers (integral numbers that are not evenly divisible by any other numbers except for
 *      themselves and 1).
 */
public class Chapter3Exercise04 {
	public static void main(String[] args) {

		for (int i = 1; i < 101; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if(i % j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}
}
