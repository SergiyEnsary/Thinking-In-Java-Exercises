package chapter7practices;

public class Wind extends Instrument {
	void play(Note n) {
		System.out.println("Wind.play() " + n);
	}
	String what() { return super.toString(); }
	void adjust() {
		System.out.println("Adjusting Wind");
	}
}