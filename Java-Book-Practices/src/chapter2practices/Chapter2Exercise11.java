package chapter2practices;
/* Chapter 2
 * Exercise 11:    (3) Start with a number that has a binary one in the most significant position (hint: Use a
 *      hexadecimal constant). Using the signed right-shift operator, right shift it all the way through all of
 *      its binary positions, each time displaying the result using Integer.toBinaryString( ).
 */
public class Chapter2Exercise11 {
	public static void main(String[] args) {
		int h = 0x10000000;
        System.out.println(Integer.toBinaryString(h));
        for (int k = 0; k < 28; k++) {
            h >>>= 1;
            System.out.println(Integer.toBinaryString(h));
        }
	}
}