package chapter9practices;
/* Repeat the previous exercise but define the inner class within a
 * scope with scope within a method.
 */

interface Ex10Interface {
	void say(String string); 
}

public class Chapter9Exercise10 {	
	
	Ex10Interface test(boolean newClass) {
		if(newClass) {
			class Inner implements Ex10Interface {
				public void say(String string) {
					System.out.println(string); 
				}
			}
			return new Inner();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Chapter9Exercise10 exercise = new Chapter9Exercise10();
		exercise.test(true).say("Test");
	} 
}
