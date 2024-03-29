package chapter13practices;

/* A constructor is a kind of factory method. Modify RegisteredFactories.java
 * so that instead of using explicit factories, the class object is stored in
 * the List, and newInstance() is used to create each object.
 */

import java.util.*;

class Part14 {
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Class<? extends Part>> partClasses = new ArrayList<Class<? extends Part>>();
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
		partClasses.add(FuelFilter.class);
		partClasses.add(AirFilter.class);
		partClasses.add(CabinAirFilter.class);
		partClasses.add(OilFilter.class);
		partClasses.add(FanBelt.class);
		partClasses.add(PowerSteeringBelt.class);
		partClasses.add(GeneratorBelt.class);
	}
	private static Random rand = new Random();
	public static Part createRandom() {
		int n = rand.nextInt(partClasses.size());
		try {
			return partClasses.get(n).newInstance();
		} catch(InstantiationException e) {
			throw new RuntimeException(e);
		} catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	} 
}

public class Ex14 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(Part14.createRandom());
	}
}

/*Output:

CabinAirFilter
FanBelt
AirFilter
FanBelt
FanBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
CabinAirFilter
GeneratorBelt

*/