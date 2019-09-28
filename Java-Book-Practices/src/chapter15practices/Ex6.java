package chapter15practices;

/* Write a method that takes two int arguments, indicating the two sizes of
* a 2-D array. The method should create and fill a 2-D array of BerylliumSphere
* according to the size arguments.
*/
import java.util.*;

public class Ex6 {
	public static BerylliumSphere[][] sphereAM(int size1, int size2) {
		BerylliumSphere[][] result = new BerylliumSphere[size1][size2];
		for(int i = 0; i < size1; i++) {
			result[i] = new BerylliumSphere[size2];
			for(int j = 0; j < size2; j++)
				result[i][j] = new BerylliumSphere();	
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(sphereAM(2,2)));
		System.out.println(Arrays.deepToString(sphereAM(4,3)));		
	}
}

/*Output:

[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3]]
[[Sphere 4, Sphere 5, Sphere 6], [Sphere 7, Sphere 8, Sphere 9], [Sphere 10, Sphere 11, Sphere 12], [Sphere 13, Sphere 14, Sphere 15]]

*/