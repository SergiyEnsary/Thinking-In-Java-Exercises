package chapter16practices;

/* Create a FastTraversalLinkedList that internally uses a LinkedList for
* rapid insertions and removals, and an ArrayList for rapid traversals and 
* get operations. Test it by modifying ListPerformance.java.
*/

import java.util.*;

class FastTraversalLinkedList<E> {
	private LinkedList<E> lList = new LinkedList<E>();
	private ArrayList<E> aList = new ArrayList<E>();
	private ArrayList<E> toArrayList(LinkedList<E> lList) {
		aList.clear();
		aList.addAll(lList);
		lList.clear();
		return aList;
	}
	private LinkedList<E> toLinkedList(ArrayList<E> aList) {
		lList.clear();
		lList.addAll(aList);
		aList.clear();
		return lList;
	}
	public int size() {
		return aList.size() < lList.size() ? lList.size() : aList.size();
	}
	public void clear() {
		if(aList.size() < lList.size())
			lList.clear();
		else
			toLinkedList(aList).clear();	
	}
	public void add(E e) {
		if(aList.size() < lList.size())
			lList.add(e);
		else
			toLinkedList(aList).add(e);	
	}
	public void add(int i, E e) {
		if(aList.size() < lList.size())
			lList.add(i, e);
		else
			toLinkedList(aList).add(i, e);	
	}
	public boolean addAll(Collection<? extends E> c) {
		if(aList.size() < lList.size()) 
			return lList.addAll(c);			 
		else
			return toLinkedList(aList).addAll(c);
	}
	public void addFirst(E e) {
		if(aList.size() < lList.size())
			lList.addFirst(e);
		else
			toLinkedList(aList).addFirst(e);	
	}
	public void addLast(E e) {
		if(aList.size() < lList.size())
			lList.addLast(e);
		else
			toLinkedList(aList).addLast(e);	
	}
	public E set(int i, E e) {
		if(lList.size() < aList.size()) 
			return aList.set(i,e);
		else
			return toArrayList(lList).set(i,e);
	}
	public E remove(int i) {
		if(aList.size() < lList.size())
			return lList.remove(i);
		else
			return toLinkedList(aList).remove(i);	
	}
	public E removeFirst() {
		if(aList.size() < lList.size())
			return lList.removeFirst();
		else
			return toLinkedList(aList).removeFirst();	
	}
	public E removeLast() {
		if(aList.size() < lList.size())
			return lList.removeLast();
		else
			return toLinkedList(aList).removeLast();	
	}
	public E get(int i) {
		if(lList.size() < aList.size()) 
			return aList.get(i);
		else
			return toArrayList(lList).get(i);
	}
	public Iterator<E> iterator() {
		if(lList.size() < aList.size()) 
			return aList.iterator();
		else
			return toArrayList(lList).iterator();
	}
	public ListIterator<E> listIterator() {
		if(aList.size() < lList.size()) 
			return lList.listIterator();
		else
			return toLinkedList(aList).listIterator();
	}
	public ListIterator<E> listIterator(int i) {
		if(aList.size() < lList.size()) 
			return lList.listIterator(i);
		else
			return toLinkedList(aList).listIterator(i);
	}
	public String toString() {
		return aList.size() > lList.size() ? aList.toString() : 
			lList.size() == 0 ? aList.toString() : lList.toString();		
	}	
}

public class Ex33 {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<FastTraversalLinkedList<Integer>>> tests =
		new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
	static List<Test<FastTraversalLinkedList<Integer>>> qTests =
		new ArrayList<Test<FastTraversalLinkedList<Integer>>>();
	static {
		tests.add(new Test<FastTraversalLinkedList<Integer>>("add") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < listSize; j++)
						list.add(j);
				}
				return loops * listSize;
			}
		});		
		tests.add(new Test<FastTraversalLinkedList<Integer>>("get") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}	
		});		
		tests.add(new Test<FastTraversalLinkedList<Integer>>("set") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), 47);
				return loops;
			}
		});		
		tests.add(new Test<FastTraversalLinkedList<Integer>>("iteradd") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size()/2;
				ListIterator<Integer> it = list.listIterator(half);
				for(int i = 0; i < LOOPS; i++)
					it.add(47);
				return LOOPS;
			}	
		});		
		tests.add(new Test<FastTraversalLinkedList<Integer>>("insert") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				for(int i = 0; i < loops; i++)
					list.add(5, 47);
				return loops;
			}
		});		
		tests.add(new Test<FastTraversalLinkedList<Integer>>("remove") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size() > 5)
						list.remove(5);
				} 
				return loops * size;		
			}
		});		
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("addFirst") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addFirst(47);
				}
				return loops * size;
			}
		});		
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("addLast") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					for(int j = 0; j < size; j++)
						list.addLast(47);
				}
				return loops * size;
			}
		});		
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmFirst") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size() > 0)
						list.removeFirst();
				}
				return loops * size;
			}
		});		
		qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmLast") {
			int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size() > 0)
						list.removeLast();
				}
				return loops * size;
			}
		});			
	}
	static class ListTester extends Tester<FastTraversalLinkedList<Integer>> {
		public ListTester(FastTraversalLinkedList<Integer> container, 
		List<Test<FastTraversalLinkedList<Integer>>> tests) {
			super(container, tests);
		}
		public static void run(FastTraversalLinkedList<Integer> list, 
		List<Test<FastTraversalLinkedList<Integer>>> tests) {
			new ListTester(list, tests).timedTest();
		}		
	}	
	public static void main(String[] args) {
		Tester.defaultParams = TestParam.array(
			10, 5000, 100, 5000, 1000, 1000, 10000, 200);
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
		Tester.fieldWidth = 12;
		Tester<FastTraversalLinkedList<Integer>> qTest = new Tester<FastTraversalLinkedList<Integer>>(new FastTraversalLinkedList<Integer>(), qTests);
		qTest.setHeadline("Queue tests");
		qTest.timedTest();		
	}
} 

/* Output:

-------------- FastTraversalLinkedList --------------
size     add     get     set iteradd  insert  remove
  10      90      11      12      75     433     319
 100      29      10      11      65      81      50
1000      27      10      12      12      54      68
10000      22      10      16      12      51      19
-------------------- Queue tests --------------------
size    addFirst     addLast     rmFirst      rmLast
  10          60          39          55          61
 100          20          18          23          15
1000          10           6          15          12
10000           8           8          10          10

*/