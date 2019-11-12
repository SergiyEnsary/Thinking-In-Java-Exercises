package chapter18practices;

//Instead of implementing an interface, make next() a static 
//method.


import java.util.*;

enum CartoonCharacter { 
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private static Random rand = new Random();
	public static CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
}

public class Ex2 {
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i = 0; i < 10; i++) {
			System.out.print(cc.next()); 
			System.out.print((i < 9) ? ", " : "");			
		}
	}
}	

/*Output:

BOB, PUNCHY, SILLY, SLAPPY, NUTTY, SILLY, PUNCHY, SLAPPY, BOB, SLAPPY

 */