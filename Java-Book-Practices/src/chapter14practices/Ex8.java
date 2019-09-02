package chapter14practices;

/* Following the form of the Coffee example, create a hierarchy of StoryCharacter(s) from 
 * your favorite movie, dividing them into GoodGuy(s) and BadGuy(s). Create a generator
 * for StoryCharacter(s), following the form of CoffeeGenerator.
 */
import java.util.*;
import chapter13practices.*;

public class Ex8 
	implements Generator<StoryCharacter>,  Iterable<StoryCharacter> {
	private Class[] types = { DarthVader.class, JabbaTheHut.class, LukeSkywalker.class, Yoda.class };
	private static Random rand = new Random();
	public Ex8() {}
	// For iteration:
	private int size = 0;
	public Ex8(int sz) { size = sz; }
	public StoryCharacter next() {
		try {
			return (StoryCharacter)types[rand.nextInt(types.length)].newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}	
	class StoryCharacterIterator implements Iterator<StoryCharacter> {
		int count = size;
		public boolean hasNext() { return count > 0; }
		public StoryCharacter next() {
			count--;
			return Ex8.this.next();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	public Iterator<StoryCharacter> iterator() {
		return new StoryCharacterIterator();
	}
	public static void main(String[] args) {
		Ex8 gen = new Ex8();
		for(int i = 0; i < 5; i++)
			System.out.println(gen.next());
		for(StoryCharacter s : new Ex8(5))
			System.out.println(s); 
	}
}

/*Output:

LukeSkywalker 0
DarthVader 1
DarthVader 2
DarthVader 3
DarthVader 4
Yoda 5
LukeSkywalker 6
DarthVader 7
DarthVader 8
DarthVader 9

 */