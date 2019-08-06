package chapter9practices;

/* Modify interfaces/HorrorShow.java to implement DangerousMonster and
* Vampire using anonymous classes.
*/

interface Monster {
	void menace();
}	

interface DangerousMonster extends Monster {
	void destroy();
}	

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {}
	public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void menace() {}
	public void destroy() {}
	public void kill() {}
	public void drinkBlood() {} 
}

public class Chapter9Exercise14 {
	static void monster(Monster monster) { monster.menace(); }
	static void dangMonster(DangerousMonster dangMonster) {
		dangMonster.menace();
		dangMonster.destroy();
	}
	
	static void kill(Lethal lethal) { lethal.kill(); }
	
	public DangerousMonster monsterMaker() {
		
		return new DangerousMonster() {
			public void menace() { System.out.println("DangerousMonster Menace"); }
			public void destroy() { System.out.println("DangerousMonster Destroy"); }
		};
	}
	
	public Vampire vampireMaker() {
		
		return new Vampire() {
			public void menace() { System.out.println("Vampire Menace"); }
			public void destroy() { System.out.println("Vampire Destroy"); }
			public void kill() { System.out.println("Vampire Kill"); }
			public void drinkBlood() { System.out.println("Vampire Drinks Blood"); }
		};
	}
	
	public static void main(String[] args) {
		Chapter9Exercise14 show = new Chapter9Exercise14();
		show.monster(show.monsterMaker());
		show.dangMonster(show.monsterMaker());
		show.monster(show.vampireMaker());
		show.dangMonster(show.vampireMaker());
		show.kill(show.vampireMaker());
	}
}
