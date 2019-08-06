package chapter9practices;

/* Create an interface that contains a nested class that has a static method that
 * calls the methods of your interface and displays the results. Implement your
 * interface and pass an instance of your implementation to the method. 
 */

interface Interface21 {
	String f();
	String g(); 
	class Nested {
		static void testIn(Interface21 i) { 
			System.out.println(i.f() + i.g());
		}		
	}		
}

public class Chapter9Exercise21 implements Interface21 {
	public String f() { return "nested "; }
	public String g() { return "static"; }
	public static void main(String[] args) {
		Chapter9Exercise21 test = new Chapter9Exercise21();
		Interface21.Nested.testIn(test);						
	}
}
