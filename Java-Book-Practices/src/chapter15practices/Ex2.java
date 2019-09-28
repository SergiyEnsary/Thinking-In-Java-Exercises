package chapter15practices;

//Write a method that takes an int argument and returns an 
//array of that size filled BerylliumSpheres.
import java.util.*;

public class Ex2 {
	public static BerylliumSphere[] someSpheres(int n) {
		BerylliumSphere[] result = new BerylliumSphere[n];
		for(int i = 0; i < n; i++)
			result[i] = new BerylliumSphere();
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.asList(someSpheres(3)));
	}
}
/*Output:

[Sphere 0, Sphere 1, Sphere 2]

*/