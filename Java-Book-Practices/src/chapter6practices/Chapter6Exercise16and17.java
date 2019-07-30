package chapter6practices;
/*Chapter 6
 * 
 * Exercise 16:    (2) Create a class called Amphibian. From this, inherit a class called Frog. Put appropriate
 *      methods in the base class. In main( ), create a Frog and upcast it to Amphibian, and demonstrate that
 *      all the methods still work.
 * Exercise 17:    (1) Modify Exercise 16 so that Frog overrides the method definitions from the base class
 *      (provides new definitions using the same method signatures). Note what happens in main( ).
 */
public class Chapter6Exercise16and17 {
	public static void main(String[] args) {
		Amphibian amphibian = new Amphibian();
        Frog frog = new Frog();
        frog.print(frog);
        amphibian.print(frog);
        
        //Part of Ex17
        amphibian.method();
        frog.method();
	}
}
