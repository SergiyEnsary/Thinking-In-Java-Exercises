package chapter9practices;

/* Modify Exercise 1 so that Outer has a private String field (initialized
 * by the constructor), and Inner has a toString() that displays this field.
 * Create an object of type Inner and display it.
 */

public class Chapter9Exercise03 {		//Outer class
	private String s;
	
	class Inner03 { 
		Inner03() { System.out.println("Inner()"); }
		public String toString() { return s; }
	}
	
	Chapter9Exercise03(String s) { 
		System.out.println("Outer()");
		this.s = s;
	}
	
	Inner03 makeInner03() {return new Inner03();}
	
	public static void main(String[] args) {
		Chapter9Exercise03 outer = new Chapter9Exercise03("Outer class");
		Inner03 inner = outer.makeInner03();
		System.out.println(inner.toString());
	}
}
