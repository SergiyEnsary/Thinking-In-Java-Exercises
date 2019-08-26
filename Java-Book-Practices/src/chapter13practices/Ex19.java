package chapter13practices;

import java.lang.reflect.InvocationTargetException;

//In ToyTest.java, use reflection to create a Toy object using
//the non-default constructor.
interface HasBatteries19 {}
interface Waterproof19 {}
interface Shoots19 {}

class Toy19 {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy19(int i) {
		System.out.println("Constructor Toy(" + i +") used.");
	}
}

class FancyToy19 extends Toy19 implements HasBatteries19, Waterproof19, Shoots19 {
	FancyToy() { 
		super(1);
	}
}

public class Ex19 {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name : " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			Toy19.class.getDeclaredConstructor(int.class).newInstance(1);
		}catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		}catch(InstantiationException e) {
			throw new RuntimeException(e);
		}catch(InvocationTargetException e) {
			throw new RuntimeException(e);
		}catch(NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}

/*Output:

Constructor Toy(1) used.

*/