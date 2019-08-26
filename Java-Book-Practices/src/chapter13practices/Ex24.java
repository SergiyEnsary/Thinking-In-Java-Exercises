package chapter13practices;
import java.util.*;

//Add Null Objects to RegisteredFactories.java.

class Part24 {
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();	
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new NullPart.Factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}	

class Filter24 extends Part24 {}

class NullPart extends Part implements Null {
	private NullPart() { super(); }
	public static final Part NULL = new NullPart();
	public NullPart create() { return new NullPart(); }
	public static class Factory implements chapter13practices.Factory<NullPart> {
		public NullPart create() {
			return (NullPart)NULL;
		}
	}
	public String toString() {
		return "NULL";
	}
}

class FuelFilter24 extends Filter24 {
	public static class Factory implements chapter13practices.Factory<FuelFilter> {
		public FuelFilter create() { return new FuelFilter(); }
	}
}

class AirFilter24 extends Filter24 {
	public static class Factory implements chapter13practices.Factory<AirFilter> {
		public AirFilter create() { return new AirFilter(); }
	}
}	

class CabinAirFilter24 extends Filter24 {
	public static class Factory implements chapter13practices.Factory<CabinAirFilter> {
		public CabinAirFilter create() {
			return new CabinAirFilter();
    }
  }
}

class OilFilter24 extends Filter24 {
	public static class Factory implements chapter13practices.Factory<OilFilter> {
		public OilFilter create() { return new OilFilter(); }
	}
}	

class Belt24 extends Part24 {}

class FanBelt24 extends Belt24 {
	public static class Factory implements chapter13practices.Factory<FanBelt> {
		public FanBelt create() { return new FanBelt(); }
	}
}

class GeneratorBelt24 extends Belt {
	public static class Factory implements chapter13practices.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}	

class PowerSteeringBelt24 extends Belt {
	public static class Factory implements chapter13practices.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}	

public class Ex24 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
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

*/