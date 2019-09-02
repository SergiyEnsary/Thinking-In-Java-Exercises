package chapter14practices;

//Modify the previous exercise so that one of f()'s arguments
//is non-parameterized.

public class Ex10 {
	public <T, U> void f(T x, U y, Integer z) {
		System.out.println(x.getClass().getName() +
		" " + y.getClass().getName() +
		" " + z.getClass().getName());
	}
	public static void main(String[] args) {
		Ex10 gm = new Ex10();
		gm.f("", 1, 1);
		gm.f(1.0F, 'c', 1);
	}
}

/*Output:

java.lang.String java.lang.Integer java.lang.Integer
java.lang.Float java.lang.Character java.lang.Integer

*/