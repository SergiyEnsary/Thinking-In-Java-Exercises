package chapter15practices;

//Try to sort an array of the objects in Exercise 18. Implement 
//Comparable to fix the problem. Now create a Comparator to sort
//the objects into reverse order.
import java.util.*;

class CompBerylliumSphere 
implements Comparable<CompBerylliumSphere> {
	private static long count;
	protected final long id = count++;
	public int compareTo(CompBerylliumSphere c2) {
		return (this.id < c2.id ? -1 : (this.id == c2.id ? 0 : 1));
	}

	public String toString() {
		return "BerylliumSphere " + id;
	}
}

class CompBerylliumSphereComparator implements Comparator<CompBerylliumSphere> {
	public int compare(CompBerylliumSphere c1, CompBerylliumSphere c2) {
		return (c1.id > c2.id ? -1 : (c1.id == c2.id ? 0 : 1));
	}
}

public class Ex21 { 	
	public static void main(String[] args) {

		BerylliumSphere[] bsa = new BerylliumSphere[5];
		for(int i = 0; i < bsa.length; i++)
			bsa[i] = new BerylliumSphere();		
		CompBerylliumSphere[] cbsa = new CompBerylliumSphere[5];
		for(int i = 0; i < cbsa.length; i++)
			cbsa[i] = new CompBerylliumSphere();

		System.out.println("unsorted:");
		System.out.println(Arrays.toString(cbsa));

		Arrays.sort(cbsa);
		System.out.println("sorted:");
		System.out.println(Arrays.toString(cbsa));

		Arrays.sort(cbsa, new CompBerylliumSphereComparator());
		System.out.println("reverse sorted:");
		System.out.println(Arrays.toString(cbsa));	
	}
}

/*Output:

unsorted:
[BerylliumSphere 0, BerylliumSphere 1, BerylliumSphere 2, BerylliumSphere 3, BerylliumSphere 4]
sorted:
[BerylliumSphere 0, BerylliumSphere 1, BerylliumSphere 2, BerylliumSphere 3, BerylliumSphere 4]
reverse sorted:
[BerylliumSphere 4, BerylliumSphere 3, BerylliumSphere 2, BerylliumSphere 1, BerylliumSphere 0]

 */