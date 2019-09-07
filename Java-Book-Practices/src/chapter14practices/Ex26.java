package chapter14practices;

// Demonstrate array covariance using Numbers and Integers.

public class Ex26 {
	public static void main(String[] args) {
		Number[] numbers = new Integer[3];
		numbers[0] = new Integer(0);
		numbers[1] = new Integer(1);
		numbers[2] = new Integer(2);
		try {
			numbers[1] = new Double(3.4);
		} catch(Exception e) {
			System.out.println(e);
		}
		for(Number n : numbers) {
			System.out.println(n);
		}
		for(Number n : numbers) {
			System.out.println(n.getClass().getSimpleName());	
		}
	}	
}

/*Output:

java.lang.ArrayStoreException: java.lang.Double
0
1
2
Integer
Integer
Integer

 */