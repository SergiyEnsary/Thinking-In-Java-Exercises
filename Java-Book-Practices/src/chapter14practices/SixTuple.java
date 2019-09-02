package chapter14practices;

class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
	public final F sixth;
	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		sixth = f;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " +
				third + ", " + fourth + ", " + fifth + ", " + sixth +")";
	}
	public static <A,B,C,D,E,F> SixTuple<A,B,C,D,E,F> tuple(A a, B b, C c, D d, E e, F f) {
		return new SixTuple<A,B,C,D,E,F>(a, b, c, d, e, f);
	}
} 