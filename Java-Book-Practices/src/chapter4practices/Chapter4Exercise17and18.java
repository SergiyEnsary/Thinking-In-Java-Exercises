package chapter4practices;
/*	Chapter 4
 * Exercise 17:    (2) Create a class with a constructor that takes a String argument. During construction,
 *      print the argument. Create an array of object references to this class, but do not actually create
 *      objects to assign into the array. When you run the program, notice whether the initialization messages
 *      from the constructor calls are printed.
 */
public class Chapter4Exercise17and18 {
	public static void main(String[] args) {
		class Message {
			public Message(String string) {
				System.out.println(string);
			}
		}
		Message one = null;
		Message two = null;
		Message[] messages = {one,two};
		/*
         * Exercise 18:    (1) Complete the previous exercise by creating objects to attach to the array of references.
         */
		messages[0] = new Message("one");
        messages[1] = new Message("two");
	}
}
