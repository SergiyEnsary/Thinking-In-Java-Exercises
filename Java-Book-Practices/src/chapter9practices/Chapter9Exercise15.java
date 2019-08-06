package chapter9practices;

/* Create a class with a non-default constructor and no default constructor.
 * Create a second class that has a method that returns a reference to an
 * object of the first class. Create the object that you return by making an
 * anonymous inner class that inherits from the first class. 
 */

class First {
	private String string;

	First(String string) { this.string = string; } 

	public String showS() { return string; }
}

public class Chapter9Exercise15 {
	
	public First makeOne(String string) {
		return new First(string) { };
	}

	public static void main(String[] args) {
		Chapter9Exercise15 test = new Chapter9Exercise15();
		System.out.println(test.makeOne("Test").showS());
	}
}
