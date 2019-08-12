package chapter11practices;

/* Repeat the previous exercise, but inside the catch clause, wrap g()'s 
 * exception in a RuntimeException.
 */

class GException extends Exception {
	GException(String s) { super(s); }
}

public class Ex11 {
	static void f() {
		try {
			g();
		} catch(GException ge) {
			System.out.println("Caught GException in f try");
			ge.printStackTrace();
			throw new RuntimeException(ge);
		}
	}
	static void g() throws GException {
		throw new GException("from g()");
	}
	public static void main(String[] args) {
		f();
	}	
}

