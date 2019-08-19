package chapter12practices;
/*
 * Exercise 14: (1) Rewrite SplitDemo using String.split( ).
 */
import java.util.*;

public class Ex14 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		System.out.println(Arrays.toString(input.split("!!"))); 
		// Only do the first three: 
		System.out.println(Arrays.toString(input.split("!!", 3)));
	}
}
/*
 * Output:
[This, unusual use, of exclamation, points]
[This, unusual use, of exclamation!!points]
 */
