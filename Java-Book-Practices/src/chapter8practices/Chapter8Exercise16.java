package chapter8practices;

import java.nio.CharBuffer;
import java.util.Scanner;
/* Create a class that produces a sequence of chars. Adapt this class so
 * that it can be an input to a Scanner object.
 */
public class Chapter8Exercise16 extends RandomChars implements Readable {
	private int count;
	public Chapter8Exercise16(int count) {
		this.count = count;
	}			
	public int read(CharBuffer cb) {
		if(count-- == 0) return -1;
		String result = Character.toString(next()) + " ";
		cb.append(result);
		return result.length();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(new Chapter8Exercise16(10));
		while(s.hasNext())
			System.out.println(s.next() + " ");
	}
}