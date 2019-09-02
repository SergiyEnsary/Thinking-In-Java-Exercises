package chapter14practices;

/* Overload the fill() method so that the arguments and return types are
 * the specific subtypes of Collection: List, Queue and Set. This way, you
 * don't lose the type of container. Can you overload to distinguish between
 * List and LinkedList?
 */

import chapter13practices.*;

import java.util.*;

public class Ex13 {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) coll.add(gen.next());
		return coll;
	}
	public static <T> List<T> fill(List<T> l, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) l.add(gen.next());
		return l;
	}
	public static <T> Queue<T> fill(Queue<T> q, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) q.add(gen.next());
		return q;
	}
	public static <T> Set<T> fill(Set<T> s, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) s.add(gen.next());
		return s;
	}
	public static <T> LinkedList<T> fill(LinkedList<T> ll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) ll.add(gen.next());
		return ll;
	}
	public static void main(String[] args) {
		Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
		for(Coffee c : coffee) 
			System.out.println(c);
		
		List<Coffee> coffeeList = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
		System.out.println("List type: " + coffeeList.getClass());
		System.out.println("coffeeList:" + coffeeList);		
		
		Queue<Coffee> coffeeQueue = fill(new ArrayDeque<Coffee>(), new CoffeeGenerator(), 5);
		System.out.println("Queue type: " + coffeeQueue.getClass());
		System.out.println("coffeeQueue: " + coffeeQueue); 
		
		Set<Coffee> coffeeSet = fill(new HashSet<Coffee>(), new CoffeeGenerator(), 5);
		System.out.println("Set type: " + coffeeSet.getClass());
		System.out.println("coffeeSet: " + coffeeSet);
		
		LinkedList<Coffee> coffeeLinkedList = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 5);
		System.out.println("LinkedList type: " + coffeeLinkedList.getClass());
		System.out.println("coffeeLinkedList: " + coffeeLinkedList);
	}
}

/*Output:

Americano 0
Latte 1
Americano 2
Mocha 3
List type: class java.util.ArrayList
coffeeList:[Mocha 4, Breve 5, Americano 6, Latte 7, Cappuccino 8]
Queue type: class java.util.ArrayDeque
coffeeQueue: [Cappuccino 9, Americano 10, Americano 11, Mocha 12, Breve 13]
Set type: class java.util.HashSet
coffeeSet: [Mocha 17, Latte 18, Breve 14, Americano 15, Americano 16]
LinkedList type: class java.util.LinkedList
coffeeLinkedList: [Americano 19, Mocha 20, Latte 21, Mocha 22, Cappuccino 23]

*/