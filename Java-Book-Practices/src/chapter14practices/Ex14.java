package chapter14practices;

import chapter13practices.*;

/* Modify BasicGeneratorDemo.java to use the explicit form of creation for the
* Generator (that is, use the explict constructor instead of the generic 
* create() method). 
*/

public class Ex14  {	
	public static void main(String[] args) {
		Generator<CountedObject> gen = 
			new BasicGenerator<CountedObject>(CountedObject.class);
		for(int i = 0; i < 5; i++)
			System.out.println(gen.next());
	}
}

/*Output:

CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4

*/