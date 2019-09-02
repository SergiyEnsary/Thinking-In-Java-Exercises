package chapter14practices;

//Create and test a SixTuple generic.

class Robot3 {}
class Amphibian {}
class Vehicle {}
class FiveTuple3<A,B,C,D,E>{
	public final A first;
	public final B second;
	public final C third;
	public final D fourth;
	public final E fifth;
	public FiveTuple3(A a, B b, C c, D d, E e) {
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
	}
}
class SixTuple3<A,B,C,D,E,F> extends FiveTuple3<A,B,C,D,E> {
	public final F sixth;
	public SixTuple3(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		sixth = f;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ", " + fifth + ", " + sixth +")";
	}
} 

public class Ex3 {
	static SixTuple3<Robot3, Vehicle, Amphibian, String, Integer, Double> f() {
		return new SixTuple3<Robot3, Vehicle, Amphibian, String, Integer, Double>( 
				new Robot3(), new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	public static void main(String[] args) {
		SixTuple3<Robot3, Vehicle, Amphibian, String, Integer, Double> st = f();
		System.out.println(st);
		System.out.println(f());		
	}
} 

/* Output:

(chapter14practices.Robot3@27c170f0, chapter14practices.Vehicle@5451c3a8, chapter14practices.Amphibian@2626b418, hi, 47, 11.1)
(chapter14practices.Robot3@5ca881b5, chapter14practices.Vehicle@24d46ca6, chapter14practices.Amphibian@4517d9a3, hi, 47, 11.1)

 */