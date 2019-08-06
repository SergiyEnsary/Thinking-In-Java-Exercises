package chapter9practices;
/* Create an interface U with three methods. Create a class A with a method that
 * produces a reference to a U by building an anonymous inner class. Create a second
 * class B that contains an array of U. B should have one method that accepts and 
 * stores a reference to U in the array, a second method that sets a reference in
 * the array (specified by the method argument) to null, and a third method that
 * moves through the array and calls the methods in U. In main, create a group of A 
 * objects and a single B. Fill the B with U references produced by the A objects. 
 * Use the B to call back into all the A objects. Remove some of the U references
 * from the B.
 */

interface U {
	void method1();
	void method2();
	String toString();
}

class A {
	U makeU() {
		return new U() {
			public void method1() { System.out.println("method1()"); }
			public void method2() { System.out.println("method2()"); }
			public String toString() { return "I'm a U"; }
		};
	}
}

class B {
	private U[] us;
	B(int i) {us = new U[i];}
	
	void addU(U u, int i) {us[i] = u;}
	void eraseU(int i) {us[i] = null;}
	
	void testUs() {
		for(U u : us) {
			u.method1();
			u.method2();
			u.toString();
		}		
	}
	void showUs() {
		for(U u : us) { 
			if(u != null) System.out.println(u.toString());
			else System.out.println("I'm null");
		}
	}
}

public class Chapter9Exercise23 {
	public static void main(String[] args) {
		A a0 = new A();
		A a1 = new A();
		A a2 = new A();
		B b = new B(3);
		b.addU(a0.makeU(), 0);
		b.addU(a1.makeU(), 1);
		b.addU(a2.makeU(), 2);
		b.showUs();
		b.testUs();
		b.eraseU(0);
		b.eraseU(1);
		b.showUs();
	}
}