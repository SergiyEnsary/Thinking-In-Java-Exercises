package chapter4practices;
/*	Chapter 4
 * 	Exercise 9: (1) Create a class with two (overloaded) constructors.
 *  Using "this", call the second constructor inside the first one.
 */
public class Chapter4Exercise09 {
	public static void main(String [] args) {
		class CallingConst{
			public CallingConst() {
				this(1, "2");
			}
			public CallingConst(int num, String str) {
				System.out.println(num +" "+ str);
			}
		}
		CallingConst call = new CallingConst();
	}
}
