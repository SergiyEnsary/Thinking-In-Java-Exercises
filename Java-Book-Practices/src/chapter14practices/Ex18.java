package chapter14practices;

import java.util.*;
import chapter13practices.*;

class BigFish {
	private static long counter = 0;
	private final long id = ++counter;
	private BigFish() {}
	public String toString() {
		return "BigFish" + id;
	}
	public static Generator<BigFish> generator() {
		return new Generator<BigFish>() {
			public BigFish next() {
				return new BigFish();
			}	
		};
	}
}

class LittleFish {
	private static long counter = 0;
	private final long id = ++counter;
	private LittleFish() {}
	public String toString() {
		return "LittleFish" + id;
	}
	public static Generator<LittleFish> generator =
		new Generator<LittleFish>() {
			public LittleFish next() {
				return new LittleFish();
			}
		};
}

public class Ex18 {
	public static void eat(BigFish bf, LittleFish lf) {
		System.out.println(bf + " eats " + lf);
	}
	public static void main(String[] args) {
		Random rand = new Random();
		List<BigFish> hunters = new ArrayList<BigFish>();
		Generators.fill(hunters, BigFish.generator(), 3);
		Queue<LittleFish> school = new LinkedList<LittleFish>();
		Generators.fill(school, LittleFish.generator, 15);
		for(LittleFish f : school)
			eat(hunters.get(rand.nextInt(hunters.size())), f);
	}
}

/*Output:

BigFish3 eats LittleFish1
BigFish1 eats LittleFish2
BigFish1 eats LittleFish3
BigFish3 eats LittleFish4
BigFish2 eats LittleFish5
BigFish1 eats LittleFish6
BigFish1 eats LittleFish7
BigFish2 eats LittleFish8
BigFish3 eats LittleFish9
BigFish1 eats LittleFish10
BigFish1 eats LittleFish11
BigFish3 eats LittleFish12
BigFish3 eats LittleFish13
BigFish1 eats LittleFish14
BigFish1 eats LittleFish15

 */