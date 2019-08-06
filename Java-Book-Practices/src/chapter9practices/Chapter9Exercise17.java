package chapter9practices;

import java.util.Random;

/* Modify the solution to Exercise 19 from the Interfaces chapter to use
* anonymous inner classes. 
* (Exercise 19, Interfaces: Create a framework using Factory Methods
* that performs both coin tossing and dice tossing.
*/

interface Games {
	void play();
}

interface GamesFactory {
	Games getGames();
}

class CoinToss implements Games {
	Random rand = new Random();
	public void play() { 
		System.out.print("Toss Coin: ");
		switch(rand.nextInt(2)) {
			case 0 : System.out.println("Heads"); return;
			case 1 : System.out.println("Tails"); return;
			default: System.out.println("Still Falling"); return;
		} 
	}
	
	public static GamesFactory factory = new GamesFactory() {
			public Games getGames() { return new CoinToss(); }	
		};
}

class DiceThrow implements Games {
	Random rand = new Random();
	public void play() { 
		System.out.print("Throw Dice: " + (rand.nextInt(6) + 1));		
	}
	
	public static GamesFactory factory = new GamesFactory() {
			public Games getGames() { return new DiceThrow(); }
		};
}

public class Chapter9Exercise17 {
	public static void playGame(GamesFactory factory) {
		Games games = factory.getGames();
		games.play();
	}
	
	public static void main(String [] args) {
		playGame(CoinToss.factory);
		playGame(DiceThrow.factory);			
	}
}
