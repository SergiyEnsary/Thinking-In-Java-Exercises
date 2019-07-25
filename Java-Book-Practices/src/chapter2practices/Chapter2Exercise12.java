package chapter2practices;
/*Chapter 2
 * Exercise 12:    (3) Start with a number that is all binary ones. Left shift it, then use the unsigned
 *      right-shift operator to right shift through all of its binary positions, each time displaying the
 *      result using Integer.toBinaryString( ).
 */
public class Chapter2Exercise12 {
	public static void main(String[] args) {
		int h2 = -1;
        System.out.println(Integer.toBinaryString(h2));
        h2 <<= 10;
        System.out.println(Integer.toBinaryString(h2));
        for (int g = 0; g < 32; g++){
            h2 >>>= 1;
            System.out.println(Integer.toBinaryString(h2));
        }
	}
}