package chapter4practices;
/*	Chapter 4
 * Exercise 8:   (1) Create a class with two methods. Within the first method, call the second method twice:
 *      the first time without using this, and the second time using 'this' just to see it working; you should
 *      not use this form in practice.
 */
public class Chapter4Exercise08 {
	public static void main(String [] args) {
		class CallMethod{
			public void method1() {
				method2();
				this.method2();
			}
			public void method2() {
				System.out.println("Called");
			}
		}
		CallMethod call = new CallMethod();
		call.method1();
	}
}
