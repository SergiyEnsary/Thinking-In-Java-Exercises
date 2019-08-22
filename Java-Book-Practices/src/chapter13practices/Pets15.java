package chapter13practices;

import java.util.*;

 public class Pets15 {
	public static final PetCreator15 creator = new LiteralPetCreator15();
	public static Pet15 randomPet() {
		return PetFactory.createRandom();
	}
	public static Pet15[] createArray(int size) {
		return creator.createArray(size);
	}
	public static ArrayList<Pet15> arrayList(int size) {
		return creator.arrayList(size);
	}
 }