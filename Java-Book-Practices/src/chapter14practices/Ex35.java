package chapter14practices;

//Modify CheckedList.java so that it uses the Coffee classes defined
//in this chapter.

import java.util.*;
import chapter13practices.*;

public class Ex35 {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyMocha) {
		probablyMocha.add(new Breve());
	}
	public static void main(String[] args) {
		List<Mocha> mocha1 = new ArrayList<Mocha>();
		oldStyleMethod(mocha1); // Quietly accepts a Breve
		List<Mocha> mocha2 = Collections.checkedList(new ArrayList<Mocha>(), Mocha.class);
		try {
			oldStyleMethod(mocha2); // Throws an exception
		} catch(Exception e) {
			System.out.println(e);
		}
		// Derived type works fine:
		List<Coffee> coffee = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
		coffee.add(new Mocha());
		coffee.add(new Breve());		
	}
}	

/*Output:

java.lang.ClassCastException: Attempt to insert class chapter13practices.Breve element 
into collection with element type class chapter13practices.Mocha

*/