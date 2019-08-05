package chapter8practices;

import chapter7practices.Note;

interface Instrument10 {
	int VALUE = 5;
	void adjust(); 
}

interface Playable {
	void play(Note n);
}

class Wind10 implements Instrument10, Playable {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}
	public String toString() { return "Wind"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}


class Percussion10 implements Instrument10, Playable {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}
	public String toString() { return "Percussion"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Stringed10 implements Instrument10, Playable {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}
	public String toString() { return "Stringed"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Brass10 extends Wind10 {
	public String toString() { return "Brass"; }
}

class Woodwind10 extends Wind10 {
	public String toString() { return "Woodwing"; }
}

public class Chapter8Exercise10 {
	static void tune(Playable p) {
		p.play(Note.MIDDLE_C);
	}
	static void tuneAll(Playable[] e) {
		for(Playable p : e)
			tune(p);
	}
	public static void main(String[] args) {
		Playable[] orchestra = {
			new Wind10(),
			new Percussion10(),
			new Stringed10(),
			new Brass10(),
			new Woodwind10()
		};
		tuneAll(orchestra);
	}
}