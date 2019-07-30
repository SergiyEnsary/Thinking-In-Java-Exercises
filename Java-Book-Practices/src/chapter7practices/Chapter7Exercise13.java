package chapter7practices;
/*Chapter7
 * Exercise 13:    (3) Add a finalize( ) method to ReferenceCounting.java to verify the termination condition
 *      (see the Initialization & Cleanup chapter).
 */
public class Chapter7Exercise13 {
	public static void main(String[] args) throws Throwable {
		new ReferenceCounting();
	}
}
