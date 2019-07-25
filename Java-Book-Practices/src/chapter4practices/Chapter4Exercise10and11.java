package chapter4practices;
/*	Chapter 4
 * Exercise 10:    (2) Create a class with a finalize( ) method that prints a message. In main( ), create an
 *      object of your class. Explain the behavior of your program.
 */
public class Chapter4Exercise10and11 {
	public static void main(String[] args) {
		class Finalize{
			public Finalize() {
				this.finalize(); 	//Exercise 11	
			}
			protected void finalize() {
				System.out.println("Final");
			}
		}
		Finalize finalize = new Finalize();		//A new Finalize object is created, 
		finalize.finalize(); 					//which in its own constructor calls the finalize() method on itself
		
		/*
	     * Exercise 11:    (4) Modify the previous exercise so that your finalize( ) will always be called.
	     * 
	     * --> Just add the method finalize() into the constructor
	     */
	}
}
