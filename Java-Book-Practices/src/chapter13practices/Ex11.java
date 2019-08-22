package chapter13practices;

//Add Gerbil to the typeinfo.pets library and modify all the examples//in this chapter to adapt to this new class.


public class Ex11 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet : Pets.createArray(20)) {
			System.out.println(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}	
		System.out.println();
		System.out.println(counter);
	}
}

/*Output:

EgyptianMau 
Gerbil 
Cymric 
EgyptianMau 
Cymric 
EgyptianMau 
Pug 
Rat 
Mutt 
Cymric 
Manx 
Manx 
Manx 
Cymric 
EgyptianMau 
Pug 
Hamster 
Cymric 
Gerbil 
Pug 

{Mutt=1, Gerbil=2, Cymric=5, Hamster=1, EgyptianMau=4, Rodent=4, Dog=4, Pug=3, Rat=1, Pet=20, Cat=12, Manx=8}

 */