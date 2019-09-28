package chapter15practices;

//Modify ArrayOfGeneric.java to use containers instead of arrays.
//Show that you can eliminate the compile-time warnings.
import java.util.*;

public class Ex10 {
	public static void main(String[] args) {
		List<List<String>> lls = new ArrayList<List<String>>();
		List<List> l = new ArrayList<List>();	
		lls.add(new ArrayList<String>());
		List<Object> lo = new ArrayList<Object>();
		List<List<BerylliumSphere>> llb = 
				new ArrayList<List<BerylliumSphere>>();
		for(int i = 0; i < 10; i++) {
			llb.add(new ArrayList<BerylliumSphere>());
			for(int j = 0; j < 2; j++)
				llb.get(i).add(new BerylliumSphere());
		}
		System.out.println(llb);	
	}
}

/*Output:

[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3], [Sphere 4, Sphere 5], [Sphere 6, Sphere 7], [Sphere 8, Sphere 9], [Sphere 10, Sphere 11], [Sphere 12, Sphere 13], [Sphere 14, Sphere 15], [Sphere 16, Sphere 17], [Sphere 18, Sphere 19]]

 */