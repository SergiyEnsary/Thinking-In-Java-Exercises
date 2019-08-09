package chapter10practices;

import java.util.*;
/* Fill a HashMap with key-value pairs. Print the results to show ordering
 * by hash code. Extract the pairs, sort by key, and place the result into a 
 * LinkedHashMap. Show that the insertion order is maintained. 
 */

class Gerbil18 {
	private int Gerbil18Number;
	public Gerbil18(int i) {
		Gerbil18Number = i;
	}
	public void hop() {
		System.out.println("Gerbil18 " + Gerbil18Number + " hops");
	}
}

public class Ex18 {
	public static void main(String[] args) {
		Map<String, Gerbil18> gerbils = new HashMap<String, Gerbil18>();
		
		gerbils.put("Fuzzy", new Gerbil18(0));
		gerbils.put("Spotty", new Gerbil18(1));
		gerbils.put("Speedy", new Gerbil18(2));
		gerbils.put("Dopey", new Gerbil18(3));
		gerbils.put("Sleepy", new Gerbil18(4));
		gerbils.put("Happy", new Gerbil18(5));
		gerbils.put("Funny", new Gerbil18(6));
		gerbils.put("Silly", new Gerbil18(7));
		gerbils.put("Goofy", new Gerbil18(8));
		gerbils.put("Wowee", new Gerbil18(9));
		
		System.out.println(gerbils);
		System.out.println();
		
		Set<String> sortedKeys = new TreeSet<String>(gerbils.keySet());
		System.out.println(sortedKeys);
		System.out.println();
		
		Map<String, Gerbil18> sortedGerbil18s = new LinkedHashMap<String, Gerbil18>();
		
		for(String string : sortedKeys) {
			System.out.print("Adding " + string + ", ");
			sortedGerbil18s.put(string, gerbils.get(string));			
		}
		
		System.out.println();
		System.out.println();
		System.out.println(sortedGerbil18s);
		System.out.println();
		
		Map<String, Gerbil18> sortedGerbils2 = new TreeMap<String, Gerbil18>(gerbils);
		
		System.out.println(sortedGerbils2);		
	}
}
