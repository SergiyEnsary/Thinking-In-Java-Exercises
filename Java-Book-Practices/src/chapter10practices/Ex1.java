package chapter10practices;

import java.util.ArrayList;

/* Create a new class called Gerbil with an int gerbilNumber that's 
* initialized in the constructor. Give it a method called hop() that displays
* which gerbil number that is, and that it's hopping. Create an ArrayList and 
* add Gerbil objects to the List. Now use the get() method to move through
* the List and call hop() for each Gerbil.
*/

class Gerbil {
	private int gerbilNumber;
	public Gerbil(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " hops");
	}
}

public class Ex1 {
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		for(int i = 0; i < 10; i++)
			gerbils.add(new Gerbil(i));
		for(int i = 0; i < 10; i++) 
			gerbils.get(i).hop();

		for(Gerbil g : gerbils)
			g.hop();
	}
}
