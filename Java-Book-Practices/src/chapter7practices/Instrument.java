package chapter7practices;

public class Instrument {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;

	public Instrument() {
		System.out.println("Create Instrument");
		System.out.println("Creating " + this);
	}

	void play(Note n) {
		System.out.println("Instrument.play() " + n);
	}
	String what() { return "Instrument"; }
	void adjust() {
		System.out.println("Adjusting Instrument");
	}
	/*
	 * Exercise 12:    (3) Modify Exercise 9 so that it demonstrates the order of initialization of the base classes
	 *      and derived classes. Now add member objects to both the base and derived classes, and show the order in
	 *      which their initialization occurs during construction.
	 */
	public void dispose() {
		System.out.println("Dispose of Instrument");
		--refcount;
		System.out.println("Disposing " + this);
	}

	public String toString() {
		return "Instrument " + id;
	}
}
