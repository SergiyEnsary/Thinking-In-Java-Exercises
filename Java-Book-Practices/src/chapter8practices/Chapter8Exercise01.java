package chapter8practices;
/*
 * Exercise 1: (1) Modify Exercise 9 in the previous chapter so that Rodent is an abstract
 * class. Make the methods of Rodent abstract whenever possible.
 */
public class Chapter8Exercise01 {
	private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();
	public static void main(String[] args) {
		Rodent[] rodents = new Rodent[10];
		for(Rodent r : rodents) {
			r = gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();			
		}		
	}
}
