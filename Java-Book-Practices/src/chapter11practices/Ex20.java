package chapter11practices;

/* Modify StormyInning.java by adding an UmpireArgument exception type
 * and methods that throw this exception. Test the modified hierarchy. 
 */

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
class UmpireArgument extends BaseballException {}
class ThrownFromGame extends UmpireArgument {}

abstract class Inning {
	public Inning() throws BaseballException {}
	public void event() throws BaseballException {
	}
	public abstract void atBat() throws Strike, Foul, UmpireArgument;
	public void questionableCall() throws UmpireArgument {}
	public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}


interface Storm {
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class Ex20 extends Inning implements Storm {

	public Ex20()
			throws UmpireArgument, RainedOut, BaseballException {}
	public Ex20(String s)
			throws Foul, BaseballException {}
	public void rainHard() throws RainedOut {}
	public void event() {}
	public void atBat() throws PopFoul, ThrownFromGame { 
		throw new ThrownFromGame();	
	}	
	public void questionableCall() throws UmpireArgument {
		throw new UmpireArgument();
	}
	public static void main(String[] args) {
		try {
			Ex20 si = new Ex20();
			si.atBat();
			si.questionableCall();
		} catch(PopFoul e) {
			System.out.println("Pop foul");
		} catch(UmpireArgument e) {
			System.out.println("Umpire argument (StormyInning20)");	
		} catch(RainedOut e) {
			System.out.println("Rained out");
		} catch(BaseballException e) {
			System.out.println("Generic baseball exception");
		} 
		try {
			Inning i = new Ex20();
			i.atBat();
		} catch(Strike e) {
			System.out.println("Strike");
		} catch(Foul e) {
			System.out.println("Foul");
		} catch(ThrownFromGame e) {
			System.out.println("Thrown from game (Inning)");	
		} catch(RainedOut e) {
			System.out.println("Rained out");
		} catch(BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
}