package chapter14practices;

//Modify GenericMethods so that f() accepts three arguments, all 
//of which are of a different parameterized type.

public class Ex9 {
	public <T, U, V> void f(T x, U y, V z) {
		System.out.println(x.getClass().getName() +
		" " + y.getClass().getName() +
		" " + z.getClass().getName());
	}
	public static void main(String[] args) {
		Ex9 gm = new Ex9();
		gm.f("", 1, 1.0);
		gm.f(1.0F, 'c', gm);
	}
}
/*Output:

java.lang.String java.lang.Integer java.lang.Double
java.lang.Float java.lang.Character chapter14practices.Ex9

 */