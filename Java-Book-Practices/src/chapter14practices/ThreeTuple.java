package chapter14practices;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	public final C third;
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " + third +")";
	}
	public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
		return new ThreeTuple<A,B,C>(a, b, c);
	}
}