package chapter15practices;

//A Collection filled with data using a generator object.
import java.util.*;

import chapter13practices.Generator;
public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int quantity) {
		for(int i = 0; i < quantity; i++)
			add(gen.next());
	}
	public static <T> CollectionData<T>
	list(Generator<T> gen, int quantity) {
		return new CollectionData<T>(gen, quantity);
	}
}