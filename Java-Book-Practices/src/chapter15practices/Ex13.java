package chapter15practices;

//Fill a String using CountingGenerator.Character.

public class Ex13 {
	public static String fillString(int len) {
		CountingGenerator.Character cg = new CountingGenerator.Character();
		char[] ca = new char[len];
		for(int i = 0; i < len; i++)
			ca[i] = cg.next();
		return new String(ca);		
	}
	public static void main(String[] args) {
		System.out.println(fillString(7));
		System.out.println(fillString(10));
	}
}

/*Output:

abcdefg
abcdefghij

*/