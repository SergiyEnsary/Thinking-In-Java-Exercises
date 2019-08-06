package chapter9practices;

/* Repeat Exercise 9 using an anonymous inner class.
 * (Exercise 9: Create an interface with at least one method, and implement
 * that interface by defining an inner class within a method, which returns
 * a reference to your interface.) 
 */

interface Ex13Interface {
	String say(String s); 
}

public class Chapter9Exercise13 {	
	Ex13Interface test() {
		return new Ex13Interface() {
			public String say(String string) { return string; }
		};
	} 
	public static void main(String[] args) {
		Chapter9Exercise13 output = new Chapter9Exercise13();
		System.out.println(output.test().say("Hi"));
	}
}
