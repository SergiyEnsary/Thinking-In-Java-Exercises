package chapter15practices;

//Modify ContainerComparison.java by creating a Generator for 
//BerylliumSphere, and change main() to use that Generator
//with Generated.array().
import java.util.*;

import chapter13practices.Generator;

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
	public BerylliumSphere next() {
		return new BerylliumSphere();
	}		
}

public class Ex15 {
	public static void main(String[] args) {
		BerylliumSphere[] spheres = new BerylliumSphere[5];
		BerylliumSphereGenerator bsg = new BerylliumSphereGenerator();
		Generated.array(spheres, bsg);
		System.out.println(Arrays.toString(spheres));
		System.out.println(spheres[4]);
		List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
		for(int i = 0; i < 5; i++)
			sphereList.add(bsg.next());
		System.out.println(sphereList);
		System.out.println(sphereList.get(4));
	}
}

/*Output:

[Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4]
Sphere 4
[Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
Sphere 9

 */