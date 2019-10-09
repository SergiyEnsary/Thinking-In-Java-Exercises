package chapter15practices;

//Show that the results of performing a binarySearch() on an
//unsorted array are unpredictable.
import java.util.*;

public class Ex22 {
	private static Random r = new Random();
	public static void main(String[] args) {
		int[] ia = ConvertTo.primitive(Generated.array(new Integer[20],new RandomGenerator.Integer(10)));
		System.out.println(Arrays.toString(ia));

		for(int i = 0; i < 10; i++) {
			int index = Arrays.binarySearch(ia, i);
			if(index < 0) {
				System.out.println(i + " not found");
			}
			else {
				System.out.println("Index: " + index + ", " + i);
			}
		}

		System.out.println("sort");
		Arrays.sort(ia);
		System.out.println(Arrays.toString(ia));

		for(int i = 0; i < 10; i++) {
			int index = Arrays.binarySearch(ia, i);
			if(index < 0) {
				System.out.println(i + " not found");
			}
			else {
				System.out.println("Index: " + index + ", " + i);
			}
		}		
	}
}

/*Output:

[8, 5, 3, 1, 1, 9, 8, 0, 2, 7, 8, 8, 1, 9, 9, 8, 8, 1, 0, 8]
0 not found
Index: 4, 1
2 not found
3 not found
4 not found
5 not found
6 not found
Index: 9, 7
Index: 11, 8
Index: 14, 9
sort
[0, 0, 1, 1, 1, 1, 2, 3, 5, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9]
Index: 1, 0
Index: 4, 1
Index: 6, 2
Index: 7, 3
4 not found
Index: 8, 5
6 not found
Index: 9, 7
Index: 14, 8
Index: 17, 9

 */