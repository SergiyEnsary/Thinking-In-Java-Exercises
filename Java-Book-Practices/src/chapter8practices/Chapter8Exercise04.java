package chapter8practices;
/* Create an abstract class with no methods. Derive a class and add a method. 
 * Create a static method that takes a reference to the base class, downcasts
 * it to the derived class, and calls the method. In main(), demonstrate that it
 * works. Now put the abstract declaration for the method in the base class, thus
 * eliminating the need for the downcast.
 */ 
abstract class Dad04 {
}

class Son04 extends Dad04 {
	protected void print() { System.out.println("Son"); }
}

abstract class SecondDad04 {
	abstract protected void print();
}

class SecondSon04 extends SecondDad04 {
	protected void print() { System.out.println("SecondSon"); }
}

public class Chapter8Exercise04 {
	public static void testPrint(Dad04 d) {
		((Son04)d).print();
	}
	public static void secondTestPrint(SecondDad04 sd) {
		sd.print();
	}
	public static void main(String[] args) {
		Son04 s = new Son04();
		Chapter8Exercise04.testPrint(s);
		SecondSon04 ss = new SecondSon04();
		Chapter8Exercise04.secondTestPrint(ss);			
	}
}

