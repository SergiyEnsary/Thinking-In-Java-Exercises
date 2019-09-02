package chapter14practices;

import java.util.*;
import chapter13practices.*;

//Use RandomList with two more types in addition to the one shown in main().


public class Ex6<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);
	public void add(T item) { storage.add(item); }
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
	public static void main(String[] args) {
		Ex6<String> rs = new Ex6<String>();
		for(String s : ("The quick brown fox jumped over " +
			"the lazy brown dog").split(" "))
			rs.add(s);
		for(int i = 0; i < 11; i++)
			System.out.print(rs.select() + " ");
		System.out.println();
		Ex6<Integer> ri = new Ex6<Integer>();
		for(int i = 0; i < 11; i++)
			ri.add(i); // autboxing
		for(int i = 0; i < 11; i++)
			System.out.print(ri.select() + " "); 
		System.out.println();
		Ex6<Pet> rp = new Ex6<Pet>();
		for(Pet p : Pets.arrayList(10))
			rp.add(p);
		for(int i = 0; i < 11; i++)
			System.out.print(rp.select() + " "); 	
	}
}

/* Output:

brown over fox quick quick dog brown The brown lazy brown 
8 5 3 1 1 9 8 0 2 7 
Cymric Cymric Mutt Manx Manx Rat Cymric Rat Cymric Manx 

*/