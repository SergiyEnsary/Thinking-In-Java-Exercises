package chapter14practices;

//Repeat the previous exercise using explicit type specification.
import java.util.*;

class MyClassA {
	public String toString() { return "MyClassA"; }
}

class MyClassB {
	public String toString() { return "MyClassB"; }
}

class MyClassC {
	public String toString() { return "MyClassC"; }
}

class MyClassD {
	public String toString() { return "MyClassD"; }
}

public class Ex12 {

	public static void main(String[] args) {
		List<MyClassA> la = New.<MyClassA>list();
		List<MyClassB> llb = New.<MyClassB>lList();
		Set<MyClassC> sc = New.<MyClassC>set();
		Queue<MyClassD> qd = New.<MyClassD>queue();
		Map<MyClassA,MyClassB> mab = New.<MyClassA,MyClassB>map();
		la.add(new MyClassA());
		System.out.println("List<MyClassA>: " + la);
		llb.add(new MyClassB());
		System.out.println("LinkedList<MyClassB>: " + llb);
		sc.add(new MyClassC());
		System.out.println("Set<MyClassC>: " + sc);
		qd.add(new MyClassD());
		System.out.println("Queue<MyClassD>: " + qd);
		mab.put(new MyClassA(), new MyClassB());
		System.out.println("Map<MyClassA,MyClassB>: " + mab);
	}
}

/*Output:

List<MyClassA>: [MyClassA]
LinkedList<MyClassB>: [MyClassB]
Set<MyClassC>: [MyClassC]
Queue<MyClassD>: [MyClassD]
Map<MyClassA,MyClassB>: {MyClassA=MyClassB}

*/
