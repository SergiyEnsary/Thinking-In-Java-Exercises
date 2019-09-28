package chapter15practices;

//Repeat the previous exercise for a 3-D array.
import java.util.*;

public class Ex7 {
	public static BerylliumSphere[][][] sphereAM(int size1, int size2, int size3) {
		BerylliumSphere[][][] result = new BerylliumSphere[size1][size2][size3];
		for(int i = 0; i < size1; i++) {
			result[i] = new BerylliumSphere[size2][size3];
			for(int j = 0; j < size2; j++) {
				result[i][j] = new BerylliumSphere[size3];
				for(int k = 0; k < size3; k++)
					result[i][j][k] = new BerylliumSphere();
			}	
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(sphereAM(2,2,2)));
		System.out.println(Arrays.deepToString(sphereAM(4,3,2)));		
	}
}
/*Output:

[[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3]], [[Sphere 4, Sphere 5], [Sphere 6, Sphere 7]]]
[[[Sphere 8, Sphere 9], [Sphere 10, Sphere 11], [Sphere 12, Sphere 13]], [[Sphere 14, Sphere 15], [Sphere 16, Sphere 17], [Sphere 18, Sphere 19]], [[Sphere 20, Sphere 21], [Sphere 22, Sphere 23], [Sphere 24, Sphere 25]], [[Sphere 26, Sphere 27], [Sphere 28, Sphere 29], [Sphere 30, Sphere 31]]]


*/