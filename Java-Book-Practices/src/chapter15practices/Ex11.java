package chapter15practices;

//Show that autoboxing doesn't work with arrays.

public class Ex11 {
	public static void main(String[] args) {
		int[] ia = new int[2];
		ia[0] = new Integer(1);
		ia[0] = new Integer(2);
		System.out.println(ia.getClass().getName());
		Integer[] Ia = new Integer[2];
		Ia[0] = (int)1;
		Ia[1] = (int)2;
		System.out.println(Ia.getClass().getName());
		System.out.println(Ia[0] instanceof Integer);
		for(int i = 0; i < Ia.length; i++)
			System.out.println(Ia[i].getClass().getName());
		Ia[0] = (int)ia[0];
		System.out.println(Ia[0].getClass().getName());		
	}
}

/*Output:

[I
[Ljava.lang.Integer;
true
java.lang.Integer
java.lang.Integer
java.lang.Integer

 */