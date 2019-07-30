package chapter7practices;
/*	Chapter 7
 * Exercise 6:  (1) Change Music3.java so that what( ) becomes the root Object method toString( ). Try printing
 *      the Instrument objects using System.out.println( ) (without any casting).
 *
 * Exercise 7:  (2) Add a new type of Instrument to Music3.java and verify that polymorphism works for your new
 *      type.
 *      
 * Exercise 8:  (2) Modify Music3.java so that it randomly creates Instrument objects the way Shapes.java does
 */
public class Chapter7Exercise06and07and08 {
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind(),
				new Reed()
		};
		Music3.tuneAll(orchestra);
		for (Instrument instrument : orchestra) {
			System.out.println(instrument.what());
		}
		
		//Ex08
		Instrument[] instruments = new Instrument[9];
        for(int i = 0; i < instruments.length; i++) {
            instruments[i] = Instruments.instrumentGenerator.next();
            System.out.println(instruments[i]);
        }
	}
}
