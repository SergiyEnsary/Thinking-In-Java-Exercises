package chapter11practices;

/* Create a class called FailingConstructor with a constructor that might fail
 * partway through the construction process and throw an exception. In main(), 
 * write code that properly guards against this failure.
 */

public class FailingConstructor{
	Integer[] ia = new Integer[2];
	String str;
	FailingConstructor(String string){
		ia[0] = 0;
		ia[1] = 1;
		ia[2] = 2;
		this.str = string; 
	}
	public static void main(String[] args) {
		try {
			FailingConstructor ex22 = new FailingConstructor("hi");
		} catch(Exception e) {
			System.out.println("Caught Exception in main(): " + e + "\n");
		} finally {}
	}	
}
/*Output:
 	
 	Caught Exception in main(): java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

 */