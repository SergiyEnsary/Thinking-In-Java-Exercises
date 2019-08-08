package chapter10practices;
/* Write a method that uses an Iterator to step through a Collection and
* print the toString() of each object in the container. Fill all the different
* types of Collections with objects and apply your method to each container.
*/
import java.util.*;

public class Ex11 {
	public static void printAny(Collection collection) {
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
	}
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		LinkedList<Character> linkedList = new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));	
		HashSet<Float> hashSet = new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
		TreeSet<Double> treeSet = new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(Arrays.asList("one", "two", "three"));
		
		printAny(arrayList);
		printAny(linkedList);
		printAny(hashSet);
		printAny(treeSet);
		printAny(linkedHashSet);
	}
}