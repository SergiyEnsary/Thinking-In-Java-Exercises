package chapter13practices;
import java.util.*;
import chapter7practices.*;
//Implement clearSpitValve() as described in the summary.

class RandomInstrumentGenerator {
	Random rand = new Random();	
	public Instrument next() {
		switch(rand.nextInt(7)) {
			default:
			case 0: return new Wind();
			case 1: return new Guitar();
			case 2: return new Stringed();
			case 3: return new Keyboard();
			case 4: return new Brass();
			case 5: return new Woodwind();
			case 6: return new Piano();
			
		}
	}
}

class Instrument {
	void play(Note n) { System.out.println("Instrument.play()" + n); }
	public String toString() { return "Instrument"; }
	void prepareInstrument() { System.out.println("Preparing instrument"); }
}

class Wind extends Instrument {
	void play(Note n) { System.out.println("Wind.play()" + n); }
	public String toString() { return "Wind"; }
	void prepareInstrument() { System.out.println("preparing Wind"); }
	void clearSpitValve() { System.out.println("Clearing spit valve (Wind)"); };
}
	
class Stringed extends Instrument {
	void play(Note n) { System.out.println("Stringed.play()" + n); }
	public String toString() { return "Stringed"; }
	void prepareInstrument() { System.out.println("Preparing Stringed"); }
}

class Keyboard extends Instrument {
	void play(Note n) { System.out.println("Keyboard.play()" + n); }
	public String toString() { return "Keyboard"; }
	void prepareInstrument() { System.out.println("Preparing Keyboard"); }
}

class Brass extends Wind {
	void play(Note n) { System.out.println("Brass.play()" + n); }
	public String toString() { return "Brass"; }
	void prepareInstrument() { System.out.println("Preparing Brass"); }
	void clearSpitValve() { System.out.println("Clearing spit valve (Brass)"); };
}

class Woodwind extends Wind {
	void play(Note n) { System.out.println("Woodwind.play()" + n); }
	public String toString() { return "Woodwind"; }
	void prepareInstrument() { System.out.println("preparing Woodwind"); }
	void clearSpitValve() { System.out.println("Clearing spit valve (Woodwind)"); };
}

class Piano extends Keyboard {
	void play(Note n) { System.out.println("Piano.play()" + n); }
	public String toString() { return "Piano"; }
	void prepareInstrument() { System.out.println("Preparing Piano"); }
}

class Guitar extends Stringed {
	void play(Note n) { System.out.println("Guitar.play()" + n); }
	public String toString() { return "Guitar"; }
	void prepareInstrument() { System.out.println("Preparing Guitar"); }
}

public class Ex26 {
  public static void tune(Instrument i) {
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Instrument[] instruments) {
	  for(Instrument i : instruments) {
		  tune(i);
	  }
  }
  private static RandomInstrumentGenerator generator = new RandomInstrumentGenerator();
  public static void main(String[] args) {
	  Instrument[] orchestra = new Instrument[15];
	  for(int i = 0; i < orchestra.length; i++) {
		  orchestra[i] = generator.next();
	  }
	  for(Instrument i : orchestra) {
		  // clearing spit valves of all orchestra instruments
		  if(i instanceof Wind)
			  ((Wind)i).clearSpitValve();
		  // preparing all orchestra instruments
		  i.prepareInstrument();
	  }
	  System.out.println();
	  tuneAll(orchestra);
  }
}

/*Output:

Preparing Guitar
Preparing Piano
Preparing Stringed
Clearing spit valve (Brass)
Preparing Brass
Preparing Guitar
Clearing spit valve (Wind)
preparing Wind
Clearing spit valve (Wind)
preparing Wind
Clearing spit valve (Woodwind)
preparing Woodwind
Clearing spit valve (Wind)
preparing Wind
Clearing spit valve (Woodwind)
preparing Woodwind
Clearing spit valve (Wind)
preparing Wind
Clearing spit valve (Wind)
preparing Wind
Clearing spit valve (Brass)
Preparing Brass
Preparing Stringed
Preparing Keyboard

Guitar.play()MIDDLE_C
Piano.play()MIDDLE_C
Stringed.play()MIDDLE_C
Brass.play()MIDDLE_C
Guitar.play()MIDDLE_C
Wind.play()MIDDLE_C
Wind.play()MIDDLE_C
Woodwind.play()MIDDLE_C
Wind.play()MIDDLE_C
Woodwind.play()MIDDLE_C
Wind.play()MIDDLE_C
Wind.play()MIDDLE_C
Brass.play()MIDDLE_C
Stringed.play()MIDDLE_C
Keyboard.play()MIDDLE_C

*/