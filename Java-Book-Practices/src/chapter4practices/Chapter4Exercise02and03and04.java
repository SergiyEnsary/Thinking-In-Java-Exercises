package chapter4practices;
/*	Chapter 4
 * Exercise 2:  (2) Create a class with a String field that is initialized at the point of definition, and
 *      another one that is initialized by the constructor. What is the difference between the two approaches?
 *      
 *      If you pass in an argument to a constructor it reassigns the value of string
 */
public class Chapter4Exercise02and03and04 {
	public static void main(String[] args) {
		class InitString{
			String string = "starting";
			public InitString() {
				System.out.println(this.string);
			}
			public InitString(String string) {
				this.string = string;
				System.out.println(this.string);
			}
		}
		InitString initString1 = new InitString();
        InitString initString2 = new InitString("constructed");
        /*
         * Exercise 3:  (1) Create a class with a default constructor (one that takes no arguments) that prints a
         *      message. Create an object of this class.
         */
        InitString initString3 = new InitString();

        /*
         * Exercise 4:  (1) Add an overloaded constructor to the previous exercise that takes a String argument and
         *      prints it along with your message.
         */
        InitString initString4 = new InitString("constructed");
	}
}
