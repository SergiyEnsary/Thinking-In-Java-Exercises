package chapter11practices;

/* Modify innerclasses/Sequence.java so that it throws an appropriate
* exception if you try to put in too many elements.
*/

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Ex12 {
	private Object[] items;
	private int next = 0;
	public Ex12(int size) { items = new Object[size]; }
	public void add(Object x) throws ArrayIndexOutOfBoundsException {

		if(next == items.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(next < items.length) {
			items[next++] = x;	
		}
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Ex12 sequence = new Ex12(10);
		for(int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println();
		sequence.add(Integer.toString(10));
	}
}
