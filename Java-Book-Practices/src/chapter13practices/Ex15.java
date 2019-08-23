package chapter13practices;

/* Implement a new PetCreator using Registered Factories, and modify the Pets
* Facade so that it uses this one instead of the other two. Ensure that the 
* rest of the examples that use Pets.java still work correctly.
*/
import java.util.*;

public class Ex15 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(PetFactory.createRandom());
	}
}