package chapter2practices;

import java.util.Random;

public class Coin {
	    Random rn;

	    public Coin(){
	        rn = new Random();
	    }

	    public String flip() {
	    	if(rn.nextInt(2)==0) {
	    		return"heads";
	    	}
	    	return"tails";
	    }
}
