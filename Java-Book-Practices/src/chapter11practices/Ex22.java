package chapter11practices;

/* Create a class called FailingConstructor with a constructor that might fail
 * partway through the construction process and throw an exception. In main(), 
 * write code that properly guards against this failure.
 */

public class Ex22 {
	Integer[] ia = new Integer[2];
	String s;
	Ex22(String s) throws Exception {
		ia[0] = 0;
		ia[1] = 1;
		ia[2] = 2;
		this.s = s; 
	}
	public static void main(String[] args) {
		try {
			Ex22 ex22 = new Ex22("hi");
		} catch(Exception e) {
			System.err.println("Caught Exception in main()");
			e.printStackTrace(System.err);
		} finally {}
	}	
}
