package chapter14practices;

/* Create a generic method that takes as an argument a Holder<List<?>>. 
 * Determine what methods you can and can't call for the Holder and for
 * the List. Repeat for an argument of List<Holder<?>>.
 */
import java.util.*;

public class Ex29 {
	public static void f1(Holder<List<?>> holder) {
		System.out.println("f1() - Holder methods:");
		System.out.println("**************");
		System.out.println("holder: " + holder);
		System.out.println("holder.get(): " + holder.get());
		System.out.println("holder.set(Arrays.asList(2,4,8,16))...");

		holder.set(Arrays.asList(2,4,8,16));

		System.out.println("\nholder.get(): " + holder.get());
		System.out.println("int[] arr = {2,4,8,16}...");

		int[] arr = {2,4,8,16};

		System.out.println("List integerList = Arrays.asList(arr)...");

		List integerList = Arrays.asList(arr);

		System.out.println("holder.equals(integerList): ");
		System.out.println(holder.equals(integerList));
		System.out.println("List<Integer> exactIntegerList = new ArrayList<Integer>()");
		System.out.println("exactIntegerList.add(2)");
		System.out.println("exactIntegerList.add(4)");
		System.out.println("exactIntegerList.add(8)");
		System.out.println("exactIntegerList.add(16)");

		List<Integer> exactIntegerList = new ArrayList<Integer>();

		exactIntegerList.add(2);
		exactIntegerList.add(4);
		exactIntegerList.add(8);
		exactIntegerList.add(16);

		System.out.println("exactIntegerList: " + exactIntegerList);
		System.out.println("holder.equals(integerList): " + holder.equals(integerList));
		System.out.println();
		System.out.println("f1() - List methods:");
		System.out.println("*************");
		System.out.println("holder.get(): " + holder.get());
		System.out.println("holder.get().getClass(): " + holder.get().getClass());

		System.out.println("List<?> unboundedList = holder.get()");

		List<?> unboundedList = holder.get();

		System.out.println("unboundedList: " + unboundedList);
		System.out.println("List rawList = holder.get()");

		List rawList = holder.get();

		System.out.println("unboundedList.equals(rawList): " + unboundedList.equals(rawList));
		System.out.println("unboundedList.contains(16): " + unboundedList.contains(16));
		System.out.println("Collection<Integer> coll = new HashSet<Integer>();");
		System.out.println("Add 2, 4, 8, 16 to coll...");

		Collection<Integer> coll = new HashSet<Integer>();

		coll.add(2);
		coll.add(4);
		coll.add(8);
		coll.add(16);

		System.out.println("unboundedList.containsAll(coll): " + unboundedList.containsAll(coll));
		System.out.println("unboundedList.equals(coll): " + unboundedList.equals(coll));
		System.out.println("unboundedList: " + unboundedList);
		System.out.println("coll: " + coll);
		System.out.println("coll.getClass(): " + coll.getClass());
		System.out.println("unboundedList.get(0): " + unboundedList.get(0));
		System.out.println("unboundedList.hashCode(): " + unboundedList.hashCode());
		System.out.println("unboundedList.indexOf(8): " + unboundedList.indexOf(8));
		System.out.println("ListIterator listIterator = unboundedList.listIterator()");

		ListIterator listIterator = unboundedList.listIterator();

		System.out.println("listIterator.next(): " + listIterator.next());
		System.out.println("unboundedList.size(): " + unboundedList.size());
		System.out.println("unboundedList.subList(1,2): " + unboundedList.subList(1,2));
		System.out.println("Object[] objectArray = unboundedList.toArray()");

		Object[] objectArray = unboundedList.toArray();

		System.out.println("objectArray: " + objectArray);
		System.out.println("objectArray includes: ");

		for(Object o : objectArray) {
			System.out.println(o + " ");
		}

		System.out.println("Number[] numberArray = unboundedList.toArray(new Number[4])");

		Number[] numberArray = unboundedList.toArray(new Number[4]);

		System.out.println("numberArray: " + numberArray);
		System.out.println("numberArray includes: ");

		for(Number n : numberArray) {
			System.out.println(n + " ");
		}

		System.out.println();
	}
	public static void f2(List<Holder<?>> list) {
		System.out.println("f2() - List methods:");
		System.out.println("*************");
		System.out.println("Add Holder<Integer>, Holder<String> and Holder<Double> to list...");

		list.add(new Holder<Integer>(128));
		list.add(new Holder<String>("Hello"));
		list.add(new Holder<Double>(2.0));

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			System.out.println(h.get() + ", ");
		}
		System.out.println("\nlist.add(3, new Holder<Float>(16.0F))...");
		System.out.println("list(size): " + list.size());

		list.add(3, new Holder<Float>(16.0F));

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			System.out.println(h.get() + ", ");
		}

		System.out.println("\nlist.clear()");

		list.clear();

		System.out.println("list: " + list);
		System.out.println("Collection<Holder<?>> coll = new ArrayList<Holder<?>>()");

		Collection<Holder<?>> coll = new ArrayList<Holder<?>>();

		System.out.println("Adding Holder<String>, Holder<Float>, Holder<Double> to coll");

		coll.add(new Holder<String>("Hi"));
		coll.add(new Holder<Integer>(512));
		coll.add(new Holder<Double>(4.0));

		System.out.println("list.addAll(coll)...");

		list.addAll(coll);

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			System.out.println(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		}

		System.out.println("\nObject clonedList = ((ArrayList)list).clone()");

		Object clonedList = ((ArrayList)list).clone();

		System.out.println("clonedList: " + clonedList);
		System.out.println("((ArrayList)list).clone().getClass(): " + ((ArrayList)list).clone().getClass());

		System.out.println("Holder<Float> floatHolder = new Holder<Float>(8.0F);");

		Holder<Float> floatHolder = new Holder<Float>(8.0F);

		System.out.println("list.set(0, floatHolder)...");

		list.set(0, floatHolder);

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			System.out.println(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
		}

		System.out.println("\nlist.contains(list.set(0, floatHolder): " + list.contains(list.set(0, floatHolder)));
		System.out.println("list.contains(8.0F): " + list.contains(8.0F));
		System.out.println("list.contains(floatHolder): " + list.contains(floatHolder));
		System.out.println("list.add(null)...");

		list.add(null);

		System.out.println("list.isEmpty(): " + list.isEmpty());
		System.out.println("list.contains(null): " + list.contains(null));
		System.out.println("list.indexOf(floatHolder): " + list.indexOf(floatHolder));
		System.out.println("list.get(0).get(): " + list.get(0).get());
		System.out.println("list.indexOf(null): " + list.indexOf(null));
		System.out.println("list.lastIndexOf(null): " + list.lastIndexOf(null));
		System.out.println("list.remove(0)...");

		list.remove(0);

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			if(h == null) {
				System.out.println("Null, ");
			}
			else {
				System.out.println(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
			}
		}

		list.remove(2);

		System.out.println("list: " + list);
		System.out.println("What holders contain: ");

		for(Holder h : list) {
			if(h == null) {
				System.out.println("Null, ");
			}
			else {
				System.out.println(h.get().getClass().getSimpleName() + ": " + h.get() + ", ");
			}
		}
		System.out.println("list.add(null)...");

		list.add(null);

		System.out.println("\nObject[] objectArray = list.toArray()");

		Object[] objectArray = list.toArray();

		System.out.println("What objectArray contains: ");

		for(int i = 0; i < objectArray.length; i++) {
			System.out.println(objectArray[i] + ", ");
		}

		System.out.println("\nHolder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[4])");

		Holder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[3]);

		System.out.println("What holderArray contains: ");

		for(int i = 0; i < holderArray.length; i++) {
			System.out.println(holderArray[i] + ", ");
		}

		System.out.println();
		System.out.println();
		System.out.println("f2() - Holder methods:");
		System.out.println("***************");
		System.out.println("list: " + list);
		System.out.println("What's in list: ");

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == null) {
				System.out.println("null");
			}
			else {
				System.out.println(list.get(i).getClass().getSimpleName() + ", ");
			}
		}
		System.out.println("list.remove(2)...");

		list.remove(2);

		System.out.println("What holders contain: ");

		for(Holder h : list) {
			System.out.println(h.get() + ", ");
		}

		System.out.println("\nHolder<?> holder1 = list.get(0)...");
		System.out.println("Holder<?> holder2 = list.get(1)...");

		Holder<?> holder1 = list.get(0);
		Holder<?> holder2 = list.get(1);

		System.out.println(list.get(0).getClass() + " - " + list.get(0).get().getClass().getSimpleName() + ";\n"
				+ list.get(1).getClass() + " - " + list.get(1).get().getClass().getSimpleName() + ";");
	}
	public static void main(String[] args) {
		f1(new Holder<List<?>>());
		System.out.println();
		List<Holder<?>> list = new ArrayList<Holder<?>>();
		f2(list);
	}

}

/*Output:

f1() - Holder methods:
 **************
holder: chapter14practices.Holder@2f0e140b
holder.get(): null
holder.set(Arrays.asList(2,4,8,16))...

holder.get(): [2, 4, 8, 16]
int[] arr = {2,4,8,16}...
List integerList = Arrays.asList(arr)...
holder.equals(integerList): 
false
List<Integer> exactIntegerList = new ArrayList<Integer>()
exactIntegerList.add(2)
exactIntegerList.add(4)
exactIntegerList.add(8)
exactIntegerList.add(16)
exactIntegerList: [2, 4, 8, 16]
holder.equals(integerList): false

f1() - List methods:
 *************
holder.get(): [2, 4, 8, 16]
holder.get().getClass(): class java.util.Arrays$ArrayList
List<?> unboundedList = holder.get()
unboundedList: [2, 4, 8, 16]
List rawList = holder.get()
unboundedList.equals(rawList): true
unboundedList.contains(16): true
Collection<Integer> coll = new HashSet<Integer>();
Add 2, 4, 8, 16 to coll...
unboundedList.containsAll(coll): true
unboundedList.equals(coll): false
unboundedList: [2, 4, 8, 16]
coll: [16, 2, 4, 8]
coll.getClass(): class java.util.HashSet
unboundedList.get(0): 2
unboundedList.hashCode(): 987211
unboundedList.indexOf(8): 2
ListIterator listIterator = unboundedList.listIterator()
listIterator.next(): 2
unboundedList.size(): 4
unboundedList.subList(1,2): [4]
Object[] objectArray = unboundedList.toArray()
objectArray: [Ljava.lang.Object;@2626b418
objectArray includes: 
2 
4 
8 
16 
Number[] numberArray = unboundedList.toArray(new Number[4])
numberArray: [Ljava.lang.Number;@5a07e868
numberArray includes: 
2 
4 
8 
16 


f2() - List methods:
 *************
Add Holder<Integer>, Holder<String> and Holder<Double> to list...
list: [chapter14practices.Holder@76ed5528, chapter14practices.Holder@2c7b84de, chapter14practices.Holder@3fee733d]
What holders contain: 
128, 
Hello, 
2.0, 

list.add(3, new Holder<Float>(16.0F))...
list(size): 3
list: [chapter14practices.Holder@76ed5528, chapter14practices.Holder@2c7b84de, chapter14practices.Holder@3fee733d, chapter14practices.Holder@2f92e0f4]
What holders contain: 
128, 
Hello, 
2.0, 
16.0, 

list.clear()
list: []
Collection<Holder<?>> coll = new ArrayList<Holder<?>>()
Adding Holder<String>, Holder<Float>, Holder<Double> to coll
list.addAll(coll)...
list: [chapter14practices.Holder@28a418fc, chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575]
What holders contain: 
String: Hi, 
Integer: 512, 
Double: 4.0, 

Object clonedList = ((ArrayList)list).clone()
clonedList: [chapter14practices.Holder@28a418fc, chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575]
((ArrayList)list).clone().getClass(): class java.util.ArrayList
Holder<Float> floatHolder = new Holder<Float>(8.0F);
list.set(0, floatHolder)...
list: [chapter14practices.Holder@279f2327, chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575]
What holders contain: 
Float: 8.0, 
Integer: 512, 
Double: 4.0, 

list.contains(list.set(0, floatHolder): false
list.contains(8.0F): false
list.contains(floatHolder): false
list.add(null)...
list.isEmpty(): false
list.contains(null): true
list.indexOf(floatHolder): -1
list.get(0).get(): 8.0
list.indexOf(null): 3
list.lastIndexOf(null): 3
list.remove(0)...
list: [chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575, null]
What holders contain: 
Integer: 512, 
Double: 4.0, 
Null, 
list: [chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575]
What holders contain: 
Integer: 512, 
Double: 4.0, 
list.add(null)...

Object[] objectArray = list.toArray()
What objectArray contains: 
chapter14practices.Holder@5305068a, 
chapter14practices.Holder@1f32e575, 
null, 

Holder[] holderArray = ((ArrayList<Holder<?>>)list).toArray(new Holder[4])
What holderArray contains: 
chapter14practices.Holder@5305068a, 
chapter14practices.Holder@1f32e575, 
null, 


f2() - Holder methods:
 ***************
list: [chapter14practices.Holder@5305068a, chapter14practices.Holder@1f32e575, null]
What's in list: 
Holder, 
Holder, 
null
list.remove(2)...
What holders contain: 
512, 
4.0, 

Holder<?> holder1 = list.get(0)...
Holder<?> holder2 = list.get(1)...
class chapter14practices.Holder - Integer;
class chapter14practices.Holder - Double;
 
 */
