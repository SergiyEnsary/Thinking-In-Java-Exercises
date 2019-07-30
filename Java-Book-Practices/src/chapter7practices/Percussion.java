package chapter7practices;

public class Percussion extends Instrument {

	public Percussion() {
		System.out.println("Create Percussion");
	}

	void play(Note n) {
		System.out.println("Percussion.play() " + n);
	}
	String what() { return super.toString(); }
	void adjust() {
		System.out.println("Adjusting Percussion");
	}

	public void dispose() {
		System.out.println("Dispose of Percussion");
		super.dispose();
	}
}