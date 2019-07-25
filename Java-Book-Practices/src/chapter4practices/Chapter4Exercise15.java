package chapter4practices;
/*	Chapter 4
 * Exercise 15:    (1) Create a class with a String that is initialized using instance initialization.
 */
public class Chapter4Exercise15 {
	public static void main(String[] args) {
		class InitClass {
		    String string;
		    public InitClass() {
		        this.string = "string";
		    }
		}
		InitClass initClass = new InitClass();
        System.out.println(initClass.string);
	}
}
