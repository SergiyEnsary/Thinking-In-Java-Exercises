package chapter9practices;

/* 
 * Create a class containing a nested class. In main(), create an instance of
 * the nested class.
 */

public class Chapter9Exercise18 {

	public static class Ex18Nest1 {
		Ex18Nest1() { System.out.println("Nested 1"); }
	}

	private static class Ex18Nest2 {
		Ex18Nest2() { System.out.println("Nested 2"); }
	}

	public static void main(String[] args) {
		Ex18Nest1 nested1 = new Ex18Nest1();
		Ex18Nest2 nested2 = new Ex18Nest2();
	}
}