package chapter10practices;
import java.util.*;
/*Modify innerclasses/Sequence.java so that Sequence works with an Iterator
 *instead of a Selector.
 */

public class Ex9 {
	private ArrayList<Object> items = new ArrayList<Object>();
	public void add(Object x) {
		items.add(x);
	}
	public Iterator iterator() {
		return items.iterator();
	}
	public static void main(String[] args) {
		Ex9 sequence = new Ex9();
		for(int index = 0; index < 10; index++)
			sequence.add(Integer.toString(index));
		Iterator it = sequence.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
