package chapter10practices;

/*Modify Exercise 1 so it uses an Iterator to move through the List while 
 *calling hop().
 */
import java.util.*;

class Gerbil08 {
	private int gerbilNumber;
	public Gerbil08(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " hops");
	}
}

public class Ex8 {
	public static void main(String[] args) {
		ArrayList<Gerbil08> gerbils = new ArrayList<Gerbil08>();
		for(int index = 0; index < 10; index++)
			gerbils.add(new Gerbil08(index));
		Iterator<Gerbil08> iterator = gerbils.iterator();
		while(iterator.hasNext()) 
			iterator.next().hop();
	}
}
