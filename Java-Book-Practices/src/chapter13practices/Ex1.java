package chapter13practices;

//In ToyTest.java, comment out Toy's default constructor and
//explain what happens.

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	// It's impossible to instantiate Toy, superclass of FancyToy when default constructor is commented out
	// Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
	FancyToy() { super(1); }
}

public class Ex1 {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() +
				" is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name : " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("chapter13practices.Ex1");
		} catch(ClassNotFoundException e) {
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
			// Can't create a super or Toy object without default constructor in Toy Class:
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

/*Output:

Class name: chapter13practices.Ex1 is interface? [false]
Simple name: Ex1
Canonical name : chapter13practices.Ex1
Class name: java.lang.Object is interface? [false]
Simple name: Object
Canonical name : java.lang.Object

 */