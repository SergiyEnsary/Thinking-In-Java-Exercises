package chapter9practices;

/* 
 * Create an interface containing a nested class. Implement this interface and 
 * create an instance of the nested class.
 */

interface Interface {
	class Nested {
		Nested() { System.out.println("Nested"); }
		
		public void hi() { System.out.println("hi"); }		
	}
}

public class Chapter9Exercise20 implements Interface {
	public static void main(String[] args) {
		Interface.Nested interfaceNested = new Interface.Nested();
		interfaceNested.hi();				
	}
}