package chapter14practices;

import chapter13practices.*;

//Use Holder3 with the typeinfo.pets library to show that a Holder3 that is
//specified to hold a base type can also hold a derived type.

public class Ex1<T> {
	private T a;
	public Ex1(T a) { this.a = a; }
	public void set(T a) { this.a = a; }
	public T get() { return a; }
	public static void main(String[] args) {
		Ex1<Pet> h3 = new Ex1<Pet>(new Pet());
		Pet a = h3.get(); // No cast needed
		System.out.println(a);
		h3.set(new Cymric());
		System.out.println(h3.get());
	}
}
/* Output:

Pet
Cymric

 */