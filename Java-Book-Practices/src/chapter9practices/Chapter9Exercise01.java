package chapter9practices;

/* Write a class named Outer that contains an inner class named Inner. 
* Add a method to Outer that returns an object of type Inner. In main(),
* create and initialize a reference to an Inner.
*/

public class Chapter9Exercise01 {		//Outer class
	class Inner { 
		Inner() { System.out.println("Inner()"); }
	}
	Chapter9Exercise01() { System.out.println("Outer()"); }
	Inner makeInner() {
		return new Inner();
	}
	public static void main(String[] args) {
		Chapter9Exercise01 outer = new Chapter9Exercise01();
		Inner inner = outer.makeInner();
	}
}
