package chapter14practices;

//Test New.java by creating your own classes and ensuring that
//New will work properly with them.
import java.util.*;

class A { public String toString() { return "A"; } }

class B { public String toString() { return "B"; } }

class C extends B { 
	public String toString() { return "C"; }
}  

public class Ex11 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		List<C> lc = New.list();
		lc.add(new C());
		Map<A,List<? extends B>> mab = New.map();
		mab.put(a,lc);
		LinkedList<B> llb = New.lList();
		llb.add(new B());
		Set<A> sa = New.set();
		sa.add(new A());
		Queue<B> qb = New.queue();
		qb.add(new B());
		System.out.println(lc);
		System.out.println(mab);
		System.out.println(llb);
		System.out.println(sa);
		System.out.println(qb);
	}
}

/*Output:

[C]
{A=[C]}
[B]
[A]
[B]

*/