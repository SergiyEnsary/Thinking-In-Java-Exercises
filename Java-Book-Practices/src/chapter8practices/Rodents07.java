package chapter8practices;

public class Rodents07 {
	class Mouse implements Rodent07 {
		private String name = "Mouse";
		public void eat() { System.out.println("Mouse.eat()"); }
		public void run() { System.out.println("Mouse.run()"); }
		public void sleep() { System.out.println("Mouse.sleep()"); }
		public String toString() { return name; }
	}

	class Rat implements Rodent07 {
		private String name = "Rat";
		public void eat() { System.out.println("Rat.eat()"); }
		public void run() { System.out.println("Rat.run()"); }
		public void sleep() { System.out.println("Rat.sleep()"); }
		public String toString() { return name; }
	}

	class Squirrel implements Rodent07 {
		private String name = "Squirrel";
		public void eat() { System.out.println("Squirrel.eat()"); }
		public void run() { System.out.println("Squirrel.run()"); }
		public void sleep() { System.out.println("Squirrel.sleep()"); }
		public String toString() { return name; }
	}
}
