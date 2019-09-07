package chapter14practices;

/* Create two interfaces and a class that implements both. Create two
* generic methods, one whose argument parameter is bounded by the first
* interface and one whose argument parameter is bounded by the second
* interface. Create an instance of the class that implements both 
* interfaces, and show that it can be used with both generic methods.
*/

interface A25 {}

interface B25 {} 

class C25 implements A25, B25 {
	public String toString() { return "C"; }
}

public class Ex25 {
	<T extends A25> void a(T t) { System.out.println("a(" + t + ")"); }
	<T extends B25> void b(T t) { System.out.println("b(" + t + ")"); }
	public static void main(String[] args) {
		C25 c = new C25();
		Ex25 ex = new Ex25();
		ex.a(c);
		ex.b(c);
	}
}

/*Output:

a(C)
b(C)

 */