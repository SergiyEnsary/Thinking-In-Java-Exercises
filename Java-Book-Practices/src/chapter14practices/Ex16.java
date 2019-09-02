package chapter14practices;
//Add a SixTuple to Tuple.java and test it in TupleTest2.java.

public class Ex16 {
	static TwoTuple<String,Integer> f() {
		return TwoTuple.tuple("hi", 47);
	}
	static TwoTuple f2() { return TwoTuple.tuple("hi", 47); }
	static ThreeTuple<Amphibian,String,Integer> g() {
		return ThreeTuple.tuple(new Amphibian(), "hi", 47);
	}
	static FourTuple<Vehicle,Amphibian,String,Integer> h() {
		return FourTuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}
	static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
		return FiveTuple.tuple(new Vehicle(), new Amphibian(), "hi", 47,
		11.1);
	}
	// must use full name to distinguish from the SixTuple of Ex3:
	static SixTuple<Robot,Vehicle,Amphibian,String,Integer,Double> m() {
		return SixTuple.tuple(new Robot("Robot"), new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(m());
	}
}

/*Output:

(hi, 47)
(hi, 47)
(chapter14practices.Amphibian@49476842, hi, 47)
(chapter14practices.Vehicle@5451c3a8, chapter14practices.Amphibian@2626b418, hi, 47)
(chapter14practices.Vehicle@76ed5528, chapter14practices.Amphibian@2c7b84de, hi, 47, 11.1)
(Robot, chapter14practices.Vehicle@28a418fc, chapter14practices.Amphibian@5305068a, hi, 47, 11.1)

*/