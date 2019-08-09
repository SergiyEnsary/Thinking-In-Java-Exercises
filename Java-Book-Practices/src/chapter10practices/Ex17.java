package chapter10practices;

import java.util.*;
/* Take the Gerbil class in Exercise 1 and put it into a Map instead, 
 * associating each Gerbil's name (e.g. "Fuzzy" or "Spot") as a String (the
 * key) for each Gerbil (the value) you put in the table. Get an Iterator for
 * the keySet() and use it to move through the Map, looking up the Gerbil for
 * each key and printing out the key and telling the Gerbil to hop().
 */

class Gerbil17 {
	private int gerbilNumber;
	public Gerbil17(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("gerbil " + gerbilNumber + " hops");
	}
}

public class Ex17 {
	public static void main(String[] args) {
		Map<String, Gerbil17> gerbils = new HashMap<String, Gerbil17>();
		gerbils.put("Fuzzy", new Gerbil17(0));
		gerbils.put("Spotty", new Gerbil17(1));
		gerbils.put("Speedy", new Gerbil17(2));
		gerbils.put("Dopey", new Gerbil17(3));
		gerbils.put("Sleepy", new Gerbil17(4));
		gerbils.put("Happy", new Gerbil17(5));
		Iterator<String> iterator = gerbils.keySet().iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			System.out.print(string + ": ");
			gerbils.get(string).hop();
		}	
	}
}
