package chapter13practices;

//Write a program to determine whether an array of char is a primitive type
//or a true Object.

public class Ex10 {	
	public static void main(String[] args) {
		char[] c = new char[10];
		
		System.out.println("Superclass of char[] c: " + 
			c.getClass().getSuperclass());
		System.out.println("char[] c instanceof Object: " + 
			(c instanceof Object));
	}
}

/*Output:

Superclass of char[] c: class java.lang.Object
char[] c instanceof Object: true

*/