package chapter11practices;

//Modify Exercise 3 to convert the exception to a Runtime Exception.

public class Ex27 {
	private static int[] ia = new int[2];	
	public static void main(String[] args) {
		try {
			ia[2] = 3;	
		} catch(ArrayIndexOutOfBoundsException e) { // convert to RuntimeException:
			throw new RuntimeException(e);
		} 
	}	
}