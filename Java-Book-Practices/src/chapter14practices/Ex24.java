package chapter14practices;

//Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.
import java.util.*;

interface Factory<T> {
	T create();
}

class Building24 {}

class House24 extends Building24 {}

class BuildingFactory implements Factory<Building24> {
	public Building24 create() {
		return new Building24();
	}
}

class HouseFactory implements Factory<House24> {
	public House24 create() {
		return new House24();
	}
}

public class Ex24<T> {
	Class<?> kind;
	public Ex24(Class<?> kind) {
		this.kind = kind;
	}
	Map<String,Factory> map;	
	public Ex24(Class<?> kind, Map<String,Factory> map) {
		this.kind = kind;
		this.map = map;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	public void addType(String typename, Factory factory) {
		map.put(typename, factory);
	}
	public Object createNew(String typename) 
			throws IllegalAccessException, InstantiationException {
		if(map.containsKey(typename))
			return map.get(typename).create();			
		System.out.println(typename + " class not available");
		return null;
	}
	public static void main(String[] args) {
		Ex24<Building24> ctt1 = new Ex24<Building24>(Building24.class);

		System.out.println(ctt1.f(new Building24()));
		System.out.println(ctt1.f(new House24()));

		Ex24<House24> ctt2 = new Ex24<House24>(House24.class);

		System.out.println(ctt2.f(new Building24()));
		System.out.println(ctt2.f(new House24()));

		Ex24<Building24> ct = new Ex24<Building24>(Building24.class, new HashMap<String,Factory>());

		ct.addType("House", new HouseFactory());
		ct.addType("Building", new BuildingFactory());

		System.out.println("ct.map = " + ct.map);

		try {
			Building24 b = (Building24)ct.createNew("Building");
			House24 h = (House24)ct.createNew("House");

			System.out.print("b.getClass().getName(): ");
			System.out.println(b.getClass().getName());
			System.out.print("h.getClass().getName(): ");
			System.out.println(h.getClass().getName());
			System.out.print("House h is instance House: ");
			System.out.println(h instanceof House24);
			System.out.print("House h is instance of Building: ");
			System.out.println(h instanceof Building24);
			System.out.print("Building b is instance of House: ");
			System.out.println(b instanceof House24);

			ct.createNew("String");  // String class not available
		} 
		catch(IllegalAccessException e) {
			System.out.println("IllegalAccessException in main");
		} 
		catch(InstantiationException e) {
			System.out.println("InstantiationException in main");
		}		
	}
}

/*Output:

true
true
false
true
ct.map = {Building=chapter14practices.BuildingFactory@27c170f0, House=chapter14practices.HouseFactory@5451c3a8}
b.getClass().getName(): chapter14practices.Building24
h.getClass().getName(): chapter14practices.House24
House h is instance House: true
House h is instance of Building: true
Building b is instance of House: false
String class not available

 */