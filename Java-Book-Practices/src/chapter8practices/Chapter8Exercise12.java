package chapter8practices;
/* In Adventure.java, add an interface called CanClimb, following
 * the form of the other interfaces.
 */
interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

interface CanClimb {
	void climb();
}

class ActionCharacter {
	public void fight() {}
}

class Hero extends ActionCharacter 
implements CanFight, CanSwim, CanFly, CanClimb {
	public void swim() {}
	public void fly() {}
	public void climb() {}
}

public class Chapter8Exercise12 {
	public static void fight(CanFight x) { x.fight(); }
	public static void swim(CanSwim x) { x.swim(); }
	public static void fly(CanFly x) { x.fly(); }
	public static void climb(CanClimb x) { x.climb(); }	
	public static void action(ActionCharacter x) { x.fight(); }
	public static void main(String[] args) {
		Hero h = new Hero();
		fight(h);
		swim(h);
		fly(h);
		climb(h);
		action(h);
	}
}