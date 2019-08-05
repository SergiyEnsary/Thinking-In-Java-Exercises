package chapter8practices;
/* Create an interface, and inherit two new interfaces from that
 * interface. Multiply inherit a third interface from the second
 * two. 
 */
interface First {
	void first();
}

interface Second extends First {
	void second();
}

interface Third extends First {
	void third();
}

interface Last extends Second, Third {
	void last();
}

class Count implements Last {
	public void first() {}
	public void second() {}
	public void third() {}
	public void last() {}
}

public class Chapter8Exercise13 {
	public static void main(String[] args) {
		Count count = new Count();
		((Second)count).second();
		((Third)count).third();
		((First)count).first();	
	}
}
