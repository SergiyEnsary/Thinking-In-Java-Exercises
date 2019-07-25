package chapter4practices;
/* Chapter 4
 * Exercise 12:    (4) Create a class called Tank that can be filled and emptied, and has a termination
 *      condition that it must be releaseTank when the object is cleaned up. Write a finalize( ) that verifies
 *      this termination condition. In main( ), test the possible scenarios that can occur when your Tank is
 *      used.
 */
public class Chapter4Exercise12and13 {
	public static void main(String [] args) throws Throwable {
		class Tank{
			private boolean empty = false;
			
			public void empty() {
				this.empty = true;
			}
			public boolean isEmpty() {
				return this.empty;
			}
			public void releaseTank() throws Throwable {
				this.finalize();
			}
			protected void finalize() throws Throwable {
				if(empty) {
					System.out.println("Tank is empty!");
					super.finalize();
				}
			}
		}
		Tank aTank = new Tank();

        aTank.empty();
        aTank.releaseTank();
        /*
         * Exercise 13:    (1) Verify the statements in the previous paragraph.
         */
        System.out.println(aTank.isEmpty());
	}
}
