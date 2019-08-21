package chapter13practices;

//Incorporate a new kind of interface into ToyTest.java and 
//verify that it is detected and displayed properly.

interface HasBatteries2 {}
interface Waterproof2 {}
interface Shoots2 {}
interface MakesSounds2 {}

class Toy2 {
	Toy2() {}
	Toy2(int i) {}
}

class FancyToy2 extends Toy2
implements HasBatteries2, Waterproof2, Shoots2, MakesSounds2 {
	FancyToy2() { super(1); }
}

public class Ex2 {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() +" is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name : " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("chapter13practices.FancyToy");
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);	
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		} 
		catch(InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} 
		catch(IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}

/* Output:

Class name: chapter13practices.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : chapter13practices.FancyToy
Class name: chapter13practices.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : chapter13practices.HasBatteries
Class name: chapter13practices.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : chapter13practices.Waterproof
Class name: chapter13practices.Shoots is interface? [true]
Simple name: Shoots
Canonical name : chapter13practices.Shoots
Cannot instantiate

 */