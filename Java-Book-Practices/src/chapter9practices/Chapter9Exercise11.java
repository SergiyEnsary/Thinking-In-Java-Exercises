package chapter9practices;

/* Create a private inner class that implements a public interface.
 * Write a method that returns a reference to an instance of the private
 * inner class, upcast to the interface. Show that the inner class is 
 * completely hidden by trying to downcast to it.
 */

class Test {
	private class Inner implements Exercise11 {
		public void say(String string) {
			System.out.println(string); 
		}
	}
	Exercise11 newInner() {
		return new Inner();
	}
}
public class Chapter9Exercise11 {	
	public static void main(String[] args) {
		Test test = new Test();
		test.newInner().say("hi");
	} 
}
