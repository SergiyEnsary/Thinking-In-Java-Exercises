package chapter13practices;

//Use TypeCounter with the RegisteredFactories.java class in this chapter.

import java.util.*;

public class Ex13 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Part.class);
		List<Part> partList = new ArrayList<Part>();
		for(int i = 0; i < 20; i++)		
			partList.add(Part.createRandom());
		for(Part part : partList) {
			System.out.println(part.getClass().getSimpleName() + " ");
			counter.count(part);
		}
		System.out.println();
		System.out.println(counter);
	}
}

/*Output:

GeneratorBelt 
CabinAirFilter 
GeneratorBelt 
AirFilter 
PowerSteeringBelt 
CabinAirFilter 
FuelFilter 
PowerSteeringBelt 
PowerSteeringBelt 
FuelFilter 
CabinAirFilter 
PowerSteeringBelt 
FanBelt 
AirFilter 
OilFilter 
OilFilter 
AirFilter 
PowerSteeringBelt 
FuelFilter 
CabinAirFilter 

{FanBelt=1, GeneratorBelt=2, CabinAirFilter=4, OilFilter=2, Belt=8, Part=20, AirFilter=3, PowerSteeringBelt=5, FuelFilter=3, Filter=12}

 */