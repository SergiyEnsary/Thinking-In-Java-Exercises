package chapter16practices;
/* Create a generic, singly linked list class called SList, which, to keep
* things simple, does not implement the List interface. Each Link object in
* the list should contain a reference to the next element in the list, but
* not the previous one (LinkedList, in contrast, is a doubly linked list, 
* which means it maintains links in both directions). Create your own 
* SListIterator which, again for simplicity, does not implement ListIterator.
* The only method in SList other than toString() should be iterator(), which
* produces an SListIterator. The only way to insert and remove elements from 
* an SList is through SListIterator. Write code to demonstrate SList. 
*/
public class Ex8 {
	public static void main(String[] args) {
		SList<String> sl = new SList<String>();
		System.out.println(sl);
		SListIterator<String> slIter = sl.iterator();
		System.out.println("inserting \"hi\"");
		slIter.insert("hi");
		System.out.println(sl);
		System.out.println("inserting \"there\"");
		slIter.insert("there");
		System.out.println(sl);
		System.out.println("inserting \"sweetie\"");
		slIter.insert("sweetie");
		System.out.println(sl);
		System.out.println("inserting \"pie\"");
		slIter.insert("pie");
		System.out.println(sl);
		SListIterator<String> slIter2 = sl.iterator();
		System.out.println("removing \"hi\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("inserting \"hello\"");
		slIter2.insert("hello");
		System.out.println(sl);
		System.out.println("removing \"there\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"sweetie\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"pie\"");
		slIter2.remove();
		System.out.println(sl);
		System.out.println("removing \"hello\"");
		SListIterator slIter3 = sl.iterator();
		slIter3.remove();
		System.out.println(sl);		
	}
}

/*Output:

SList: []
inserting "hi"
SList: [hi]
inserting "there"
SList: [hi, there]
inserting "sweetie"
SList: [hi, there, sweetie]
inserting "pie"
SList: [hi, there, sweetie, pie]
removing "hi"
SList: [there, sweetie, pie]
inserting "hello"
SList: [hello, there, sweetie, pie]
removing "there"
SList: [hello, sweetie, pie]
removing "sweetie"
SList: [hello, pie]
removing "pie"
SList: [hello]
removing "hello"
SList: []

 */