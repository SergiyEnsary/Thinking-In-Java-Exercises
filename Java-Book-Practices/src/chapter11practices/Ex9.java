package chapter11practices;


/* Create three new types of exceptions. Write a class with a method that
 * throws all three. In main(), call the method but only use a single catch
 * clause that will catch all three types of exceptions.
 */

class ExceptionA extends Exception {
	ExceptionA(String msg) { super(msg); } 	
}

class ExceptionB extends Exception {
	ExceptionB(String msg) { super(msg); } 	
}

class ExceptionC extends Exception {
	ExceptionC(String msg) { super(msg); } 		
}

public class Ex9 {
	public static void f(int x) throws ExceptionA, ExceptionB, ExceptionC {
		if(x < 0) {
			throw new ExceptionA("x < 0");
		}
		if(x == 0) {
			throw new ExceptionB("x == 0");
		}
		if(x > 0) {
			throw new ExceptionC("x > 0");
		}
	}
	public static void main(String[] args) {
		try {
			f(0);
			f(1);
			f(-1);
		} catch(Exception e) {
			System.out.println("Caught Exception");
			e.printStackTrace(System.out);
		} 
	}	
}
