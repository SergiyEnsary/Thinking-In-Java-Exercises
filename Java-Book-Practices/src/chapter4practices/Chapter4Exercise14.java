package chapter4practices;
/*
 * Exercise 14:    (1) Create a class with a static String field that is initialized at the point of definition,
 *      and another one that is initialized by the static block. Add a static method that prints both fields
 *      and demonstrates that they are both initialized before they are used.
 */
public class Chapter4Exercise14 {
	static class Static{
		static String str = "any";
		static String str2;

		static {str2 = "42";}

		public static void print() {
			System.out.println(str);
			System.out.println(str2);
		}
	}
	public static void main(String [] args) {
		Static.print();
	}
}
