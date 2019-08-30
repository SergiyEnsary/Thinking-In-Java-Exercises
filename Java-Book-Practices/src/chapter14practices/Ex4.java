package chapter14practices;

//'Generify' innerclasses/Sequence.java.
import java.util.*;

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Ex4<E> {	
	private List<E> list = new ArrayList<E>();
	private int next = 0;
	public Ex4(List<E> list) { this.list = list; }
	public void add(E e) { list.add(e); }
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == list.size(); }
		public Object current() { return list.get(i); }
		public void next() { if(i < list.size()) i++; } 
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		Ex4<String> gs = new Ex4<String>(ls);
		for(int i = 0; i < 10; i++)
			gs.add(Integer.toString(i));
		Selector selector = gs.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}

/*Output:

0 1 2 3 4 5 6 7 8 9 

*/