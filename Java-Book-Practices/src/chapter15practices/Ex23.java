package chapter15practices;

//Create an array of Integer fill it with random int values (using
//autoboxing), and sort it into reverse order using a Comparator.
import java.util.*;

public class Ex23 {
	private static Random r = new Random();
	public static void main(String[] args) {
		Integer[] ia = Generated.array(new Integer[20],new RandomGenerator.Integer(10));
		System.out.println(Arrays.toString(ia));
		System.out.println("sort");
		Arrays.sort(ia, Collections.reverseOrder());
		System.out.println(Arrays.toString(ia));
	}
}

/*Output:

[8, 5, 3, 1, 1, 9, 8, 0, 2, 7, 8, 8, 1, 9, 9, 8, 8, 1, 0, 8]
sort
[9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 7, 5, 3, 2, 1, 1, 1, 1, 0, 0]

*/