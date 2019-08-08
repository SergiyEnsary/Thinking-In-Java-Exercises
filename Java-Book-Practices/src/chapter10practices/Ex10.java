package chapter10practices;
import java.util.*;
/* Change Exercise 9 in the Polymorphism chapter to use an ArrayList to
* hold the Rodents and an Iterator to move through the sequence of 
* Rodents.
*/

class RandomRodentGenerator {
	private Random rand = new Random();
	public Rodent next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Mouse();
			case 1: return new Rat();
			case 2: return new Squirrel();			
		}
	}
}

class Rodent {
	private String name = "Rodent";
	protected void eat() { System.out.println("Rodent.eat()"); }
	protected void run() { System.out.println("Rodent.run()"); }
	protected void sleep() { System.out.println("Rodent.sleep()"); }
	public String toString() { return name; }
}

class Mouse extends Rodent {
	private String name = "Mouse";
	protected void eat() { System.out.println("Mouse.eat()"); }
	protected void run() { System.out.println("Mouse.run()"); }
	protected void sleep() { System.out.println("Mouse.sleep()"); }
	public String toString() { return name; }
}

class Rat extends Rodent {
	private String name = "Rat";
	protected void eat() { System.out.println("Rat.eat()"); }
	protected void run() { System.out.println("Rat.run()"); }
	protected void sleep() { System.out.println("Rat.sleep()"); }
	public String toString() { return name; }
}

class Squirrel extends Rodent {
	private String name = "Squirrel";
	protected void eat() { System.out.println("Squirrel.eat()"); }
	protected void run() { System.out.println("Squirrel.run()"); }
	protected void sleep() { System.out.println("Squirrel.sleep()"); }
	public String toString() { return name; }
}

public class Ex10 {
	private static RandomRodentGenerator gen = 
		new RandomRodentGenerator();
	public static void main(String[] args) {
		List<Rodent> rodentList = new ArrayList<Rodent>();
		for(int i = 0; i < 10; i++)
			rodentList.add(gen.next());
		Iterator<Rodent> iterator = rodentList.iterator();
		while(iterator.hasNext()) {
			Rodent rodent = iterator.next();
			System.out.println(rodent + ": ");
			rodent.eat();
			rodent.run();
			rodent.sleep();
		}
	}
}
