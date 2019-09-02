package chapter14practices;

public class TwoTuple<A,B> {
	public final A first;
	public final B second;
	public TwoTuple(A a, B b) { first = a; second = b; }
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
		return new TwoTuple<A,B>(a, b);
	}
}