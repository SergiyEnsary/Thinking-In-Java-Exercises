package chapter9practices;

/* Add a method to the class SequenceSelector that produces the 
 * reference to the outer class Sequence.
 */

interface Selector04 {
	boolean end();
	Object current();
	void next();
}

public class Chapter9Exercise04 {
	
	private Object[] items;
	private int next = 0;
	public void print() { System.out.println("Sequence04.print() works"); }	//To make sure it works
	public Chapter9Exercise04(int size) { items = new Object[size]; }
	
	public void add(Object x) {
		if(next < items.length)
			items[next++] = x;
	}
	
	private class SequenceSelector04 implements Selector04 {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
		public Chapter9Exercise04 sequence04() { return Chapter9Exercise04.this; }
	}
	
	public Selector04 selector04() {
		return new SequenceSelector04();
	}
	
	public static void main(String[] args) {
		Chapter9Exercise04 sequence = new Chapter9Exercise04(10);
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector04 selector = sequence.selector04();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		((SequenceSelector04)selector).sequence04().print();
	}
}
