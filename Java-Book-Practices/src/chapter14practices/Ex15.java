package chapter14practices;

/* ... if you were to try to capture the result of f2() into a 
 * paramterized TwoTuple, the compiler would issue a warning.
 * Verify the previous statement.
 */

public class Ex15 {
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
		return FiveTuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		TwoTuple<String,Integer> ttsi2 = f2();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}

/*Output:

(hi, 47)
(hi, 47)
(chapter14practices.Amphibian@49476842, hi, 47)
(chapter14practices.Vehicle@5451c3a8, chapter14practices.Amphibian@2626b418, hi, 47)
chapter14practices.FiveTuple@76ed5528

*/