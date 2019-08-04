package chapter8practices;
//Modify Exercise 9 in the Polymorphism chapter so that Rodent is an
//interface.
public class Chapter8Exercise07 {
	private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();
	public static void main(String[] args) {
		// Error: cannot instantiate (abstract) interface:
		// Rodent x = new Rodent();
		// But OK to create array of implementing objects:
		Rodent07[] rodents = new Rodent07[10];
		for(Rodent07 r : rodents) {
			r = (Rodent07) gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();			
		}		
	}

}
