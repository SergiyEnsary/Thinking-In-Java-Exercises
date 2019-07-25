package chapter4practices;
/*	Chapter 4
 * Exercise 16:    (1) Create an array of String objects and assign a String to each element. Print the array
 *      by using a for loop.
 */
public class Chapter4Exercise16 {
	public static void main(String[] args) {
		String[] strings = {"string1","string2","string3","string4"};
        for (String str : strings) {
            System.out.println(str);
        }
	}
}
