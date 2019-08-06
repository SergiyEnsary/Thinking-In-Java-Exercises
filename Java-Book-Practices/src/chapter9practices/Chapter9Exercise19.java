package chapter9practices;

/* Create a class containing an inner class that itself contains an inner
 * class. Repeat this using nested classes. Note the names of the .class files
 * produced by the compiler.
 */

public class Chapter9Exercise19 {

	private class Inner {
		Inner() { System.out.println("Inner"); } 
		private class InnerInner {
			InnerInner() {System.out.println("InnerInner");}
		}
	}
	private static class Nested {
		Nested() { System.out.println("Nested"); }
		private static class NestedNested {
			NestedNested() { System.out.println("NestedNested"); }
		}
	}	
	public static void main(String[] args) {
		Nested nested = new Nested();
		Nested.NestedNested nestedN = new Nested.NestedNested();
		Chapter9Exercise19 e19 = new Chapter9Exercise19();
		Chapter9Exercise19.Inner inner = e19.new Inner();
		Chapter9Exercise19.Inner.InnerInner innerI = inner.new InnerInner();
	}
}
