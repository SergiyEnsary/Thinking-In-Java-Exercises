package chapter16practices;

//Using a LinkedList as your underlying implementation,
//define your own SortedSet.
import java.util.*;

class SortedSet10<E> extends LinkedList<E> {
	int compare(E e1, E e2) {
		int c = e1.hashCode() - e2.hashCode();
		return (c < 0) ? -1 : ((c == 0) ? 0 : 1);
	}
	public boolean add(E e) {
		if(!this.contains(e)) {
			Iterator<E> it = this.iterator();
			int index = 0;
			while(it.hasNext()) {
				if(compare(it.next(), e) < 1) 
					index++;
			}
			add(index, e);
			return true;
		}
		return false;
	}
}

class T {}

public class Ex10 {
	public static void main(String[] args) {
		SortedSet10<T> ss = new SortedSet10<T>();
		ss.add(new T());
		ss.add(new T());
		ss.add(new T());	
		ss.add(new T());
		System.out.println(ss);
		SortedSet10<Integer> ss2 = new SortedSet10<Integer>();
		ss2.add(6);
		ss2.add(8);
		ss2.add(2);
		ss2.add(4);
		ss2.add(2);
		ss2.add(8);
		System.out.println(ss2);
		SortedSet10<String> ss3 = new SortedSet10<String>();
		ss3.add("three");
		ss3.add("three");
		ss3.add("seven");
		ss3.add("hi");
		ss3.add("two");
		ss3.add("one");
		System.out.println(ss3);
	}
}

/*Output:

[chapter16practices.T@27c170f0, chapter16practices.T@49476842, chapter16practices.T@5451c3a8, chapter16practices.T@78308db1]
[2, 4, 6, 8]
[hi, one, two, seven, three]

 */