package chapter11practices;

//Modify Exercise 3 so that the catch clause logs the result.
import java.util.logging.*;
import java.io.*;

public class Ex7 {
	private static int[] ia = new int[2];	
	private static Logger logger = Logger.getLogger("Ex7 Exceptions");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString()); 	
	}
	
	public static void main(String[] args) {
		try {
			ia[2] = 3;	
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Caught ArrayIndexOutOfBoundsException");
			e.printStackTrace();
			logException(e);
		} 
	}	
}