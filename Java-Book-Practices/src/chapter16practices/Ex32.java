package chapter16practices;

/* Repeat the previous exercise for a container of int, and compare the
* performance to an ArrayList<Integer>. In your performance comparison,
* include the process of incrementing each object in the container.
*/


import java.util.*;

class IntsHolder {
	private int size = 0;
	private int[] iArray = new int[size];
	public int size() { return size; }
	public void add(int x) { 
		size += 1;
		int[] temp = new int[size];
		for(int i = 0; i < iArray.length; i++) temp[i] = iArray[i];
		temp[size - 1] = x;
		iArray = temp;
	}
	public int get(int i) {
		if(-1 < i && i < size) return iArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}
	public void incrementAll() {
		for(int i = 0; i < size; i++) iArray[i]++;
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < iArray.length; i++) sb.append((iArray[i] + " "));
		return sb.toString();		
	}	
}

class IntsHolder2 { 
	private final int SIZE = 1000;
	private int index = 0;
	private int[] iArray = new int[SIZE];
	public int size() { return SIZE; }
	public void add(int x) {
		if(index < SIZE) iArray[index++] = x;
	}
	public int get(int i) {
		if(-1 < i && i < SIZE) return iArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}
	public void incrementAll() {
		for(int i = 0; i < SIZE; i++) iArray[i]++;
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < iArray.length; i++) sb.append((iArray[i] + " "));
		return sb.toString();		
	}	
}

public class Ex32 {
	static long addTimeTest(IntsHolder ih, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) ih.add(1);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long addTimeTest(ArrayList<Integer> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.add(1);
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long getTimeTest(IntsHolder ih, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) ih.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(ArrayList<Integer> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long addTimeTest(IntsHolder2 ih, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) ih.add(1);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(IntsHolder2 ih, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) ih.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long incrementTimeTest(IntsHolder ih) {
		long start = System.nanoTime();
		ih.incrementAll();
		long stop = System.nanoTime();
		return (stop - start)/ih.size();
	}
	static long incrementTimeTest(ArrayList<Integer> list) {
		long start = System.nanoTime();
		for(Integer i : list) i++;
		long stop = System.nanoTime();
		return (stop - start)/list.size();
	}
	static long incrementTimeTest(IntsHolder2 ih) {
		long start = System.nanoTime();
		ih.incrementAll();
		long stop = System.nanoTime();
		return (stop - start)/ih.size();
	}
	public static void main(String[] args) {		
		ArrayList<Integer> list = new ArrayList<Integer>();
		IntsHolder ih = new IntsHolder();
		System.out.println("Add times (nanoseconds):");
		System.out.println("Mean of 1000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list, 1000));
		System.out.println("IntsHolder add(): " + addTimeTest(ih, 1000));
		System.out.println("Mean of 10000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list, 10000));
		System.out.println("IntsHolder add(): " + addTimeTest(ih, 10000));
		System.out.println();
		System.out.println("Get times (nanoseconds):");
		System.out.println("Mean of 10000:");
		System.out.println("ArrayList get(): " + getTimeTest(list, 10000));
		System.out.println("IntsHolder get(): " + getTimeTest(ih, 10000));
		System.out.println();
		System.out.println("Using alternate fixed size (1000) StringsHolder2");
		System.out.println("eliminates resizing and copying:");
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		IntsHolder2 ih2 = new IntsHolder2();
		System.out.println("Add times (nanoseconds):");
		System.out.println("Mean of 1000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list2, 1000));
		System.out.println("IntsHolder2 add(): " + addTimeTest(ih2, 1000));
		System.out.println();
		System.out.println("Get times (nanoseconds):");
		System.out.println("Mean of 1000:");
		System.out.println("ArrayList get(): " + getTimeTest(list2, 1000));
		System.out.println("IntsHolder2 get(): " + getTimeTest(ih2, 1000));	
		System.out.println();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		for(int i = 0; i < 1000; i++) list3.add(1);
		IntsHolder ih3 = new IntsHolder();
		for(int i = 0; i < 1000; i++) ih3.add(1);
		IntsHolder2 ih4 = new IntsHolder2();
		for(int i = 0; i < 1000; i++) ih4.add(1);
		System.out.println("Increment times (1000 elements):");
		System.out.println("ArrayList: " + incrementTimeTest(list3));	
		System.out.println("IntsHolder: " + incrementTimeTest(ih3));
		System.out.println("intsHolder2: " + incrementTimeTest(ih4));			
	}
}

/*Output:

Add times (nanoseconds):
Mean of 1000:
ArrayList add(): 301
IntsHolder add(): 3371
Mean of 10000:
ArrayList add(): 71
IntsHolder add(): 6523

Get times (nanoseconds):
Mean of 10000:
ArrayList get(): 74
IntsHolder get(): 56

Using alternate fixed size (1000) StringsHolder2
eliminates resizing and copying:
Add times (nanoseconds):
Mean of 1000:
ArrayList add(): 58
IntsHolder2 add(): 68

Get times (nanoseconds):
Mean of 1000:
ArrayList get(): 15
IntsHolder2 get(): 62

Increment times (1000 elements):
ArrayList: 267
IntsHolder: 11
intsHolder2: 10

*/