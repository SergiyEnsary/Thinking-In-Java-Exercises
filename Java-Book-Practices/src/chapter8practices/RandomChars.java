package chapter8practices;

import java.util.Random;

public class RandomChars {
	private static Random random = new Random();
	public char next() {
		return (char)random.nextInt(128);
	}
	public static void main(String[] args) {			
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 10; i++)
			System.out.print(rc.next() + " ");
	}
}
