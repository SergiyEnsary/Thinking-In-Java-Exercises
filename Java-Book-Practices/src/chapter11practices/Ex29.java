package chapter11practices;

/* Modify all the exception types in StormyInning.java so that they extend
 * RuntimeException, and show that no exception specifications or try blocks
 * are necessary. Remove the '//!' comments and show how the methods can be 
 * compiled without specifications.
 */

class BaseballException extends RuntimeException {}
class Foul extends RuntimeException {}
class Strike extends RuntimeException {}

abstract class Inning29 {
	public Inning29() {}
	public void event() {}
	public abstract void atBat();
	public void walk() {} 
}

class StormException extends RuntimeException {}
class RainedOut extends RuntimeException {}
class PopFoul extends RuntimeException {}

interface Storm29 {
	public void event();
	public void rainHard();
}

public class Ex29 extends Inning29 implements Storm29 {
	public Ex29() {}
	public Ex29(String s) {}
	public void walk() {}
	public void event() {}
	public void rainHard() {}
	public void atBat() {}
	public static void main(String[] args) {
		Ex29 si = new Ex29();
		si.atBat();
		// What happens if you upcast?
		Inning29 i = new Ex29();
		i.atBat();		
	}
}
