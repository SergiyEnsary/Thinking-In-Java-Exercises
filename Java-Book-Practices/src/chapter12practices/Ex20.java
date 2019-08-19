package chapter12practices;

import java.util.*;
/*
 * Create a class that contains int, long, float and double
 * and String fields. Create a constructor for this class
 * that takes a single String argument, and scans that
 * string into the various fields. Add a toString() method
 * and demonstrate that your class works correctly. 
 */
class DataHolder2 {
	private int i;
	private long l;
	private float f;
	private double d;
	private String s;
	DataHolder2(String data) {
		Scanner scanner = new Scanner(data);
		scanner.useLocale(Locale.US);
		i = scanner.nextInt();
		l = scanner.nextLong();
		f = scanner.nextFloat();
		d = scanner.nextDouble();
		s = scanner.next();
	}
	public String toString() {
		return i + " " + l + " " + f + " " + d + " " + s;
	}
}
public class Ex20 {
	public static void main(String[] args) {
		DataHolder2 dh =
				new DataHolder2("1 10000000000000 1.1 1e55 Word");
		System.out.println(dh.toString());
	}
}
/*
 *Output:

1 10000000000000 1.1 1.0E55 Word

 */