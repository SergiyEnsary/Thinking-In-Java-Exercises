package chapter9practices;

/* Create an interface with at least one method, and implement that
 * interface by defining an inner class within a method, which returns a
 * reference to your interface.
 */

interface Ex9Interface {
	void say(String string); 
}

public class Chapter9Exercise09 {	
	
	Ex9Interface method() {
		class Inner implements Ex9Interface {
			public void say(String string) {
				System.out.println(string); 
			}
		}
		return new Inner();
	}
	
	public static void main(String[] args) {
		Chapter9Exercise09 exercise = new Chapter9Exercise09();
		exercise.method().say("Testing");
	} 
}
