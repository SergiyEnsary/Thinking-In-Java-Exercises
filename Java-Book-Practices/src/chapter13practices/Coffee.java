package chapter13practices;

import java.util.*;

class Coffee {
	private static long counter = 0;
	private final long id = counter++;
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
	static List<Factory<? extends Coffee>> coffeeFactories =new ArrayList<Factory<? extends Coffee>>();
	static {
		coffeeFactories.add(new Latte.Factory());
		coffeeFactories.add(new Mocha.Factory());
		coffeeFactories.add(new Cappuccino.Factory());
		coffeeFactories.add(new Americano.Factory());
		coffeeFactories.add(new Breve.Factory());
	}
	private static Random rand = new Random();
	public static Coffee createRandom() {
		int n = rand.nextInt(coffeeFactories.size());
		return coffeeFactories.get(n).create();
	}
}