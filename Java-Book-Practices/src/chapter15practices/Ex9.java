package chapter15practices;

/* Create the classes necessary for the Peel<Banana> example and
* show that the compiler doesn't accept it. Fix the problem
* using an ArrayList.
*/
import java.util.*;

class Banana {
	private static long counter;
	private final long id = counter++;
	public String toString() { return "Banana " + id; }	
}

class Peel<T> {
	private T t;
	private static long counter;
	private final long id = counter++;
	public Peel(T t) { this.t = t; } 
	public String toString() { return "Peel " + id + " " + t.toString(); }
}

public class Ex9<T> {
	public static void main(String[] args) {
		List<Peel<Banana>> peels = new ArrayList<Peel<Banana>>();
		for(int i = 0; i < 10; i++)
			peels.add(new Peel<Banana>(new Banana())); 
		System.out.println(peels);
		System.out.println("peels.get(0).getClass(): " + peels.get(0).getClass());		
	}	
}

/*Output:

[Peel 0 Banana 0, Peel 1 Banana 1, Peel 2 Banana 2, Peel 3 Banana 3, Peel 4 Banana 4, Peel 5 Banana 5, Peel 6 Banana 6, Peel 7 Banana 7, Peel 8 Banana 8, Peel 9 Banana 9]
peels.get(0).getClass(): class chapter15practices.Peel

*/