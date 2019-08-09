package chapter10practices;
import java.util.*;
//Repeat the previous exercise with a HashSet and a LinkedHashSet.

class Gerbil19 {
	private int gerbilNumber;
	public Gerbil19(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("gerbil " + gerbilNumber + " hops");
	}
}

public class Ex19 {
	public static void main(String[] args) {
		
		Map<String, Gerbil19> gerbils = new HashMap<String, Gerbil19>();
		gerbils.put("Fuzzy", new Gerbil19(0));
		gerbils.put("Spot", new Gerbil19(1));
		gerbils.put("Speedy", new Gerbil19(2));
		gerbils.put("Dopey", new Gerbil19(3));
		gerbils.put("Sleepy", new Gerbil19(4));
		gerbils.put("Happy", new Gerbil19(5));
		gerbils.put("Funny", new Gerbil19(6));
		gerbils.put("Silly", new Gerbil19(7));
		gerbils.put("Goofy", new Gerbil19(8));
		gerbils.put("Wowee", new Gerbil19(9));
		
		System.out.println(gerbils);
		System.out.println();
		
		Set<String> hashedKeys = new HashSet<String>(gerbils.keySet());
		
		System.out.println("HashSet: " + hashedKeys);
		System.out.println();
		
		Map<String, Gerbil19> hashedGerbils = new LinkedHashMap<String, Gerbil19>();
		
		for(String s : hashedKeys) {
			System.out.print("Adding " + s + ", ");			
			hashedGerbils.put(s, gerbils.get(s));
		}
		
		System.out.println();
		System.out.println();
		System.out.println("From HashSet: " + hashedGerbils);
		System.out.println();
		
		Set<String> linkedHashedKeys = new LinkedHashSet<String>(gerbils.keySet());
		
		System.out.println("LinkedHashSet: " + linkedHashedKeys);
		System.out.println();
		
		Map<String, Gerbil19> linkedHashedGerbils = new LinkedHashMap<String, Gerbil19>();
		
		for(String s : linkedHashedKeys) {
			System.out.print("Adding " + s + ", ");			
			linkedHashedGerbils.put(s, gerbils.get(s));
		}
		
		System.out.println();
		System.out.println();
		System.out.println("From LinkedHashSet: " + linkedHashedGerbils);
	}
}
