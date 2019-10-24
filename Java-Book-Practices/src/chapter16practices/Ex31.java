package chapter16practices;

/* Create a container that encapsulates an array of String, and only
* allows adding Strings and getting Strings, so that there are no 
* casting issues during use. If the internal array isn't big enough
* for the next add, your container should automatically resize it. 
* In main(), compare the performance of your container with an 
* ArrayList<String>.
*/


import java.util.*;

class StringsHolder {
	private int size = 0;
	private String[] sArray = new String[size];
	public void add(String s) { 
		size += 1;
		String[] temp = new String[size];
		for(int i = 0; i < sArray.length; i++) temp[i] = sArray[i];
		temp[size - 1] = s;
		sArray = temp;
	}
	// get() returns only Strings:
	public String get(int i) {
		if(-1 < i && i < size) return sArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sArray.length; i++) sb.append((sArray[i] + " "));
		return sb.toString();		
	}	
}

class StringsHolder2 { 
	private int size = 1000;
	private int index = 0;
	private String[] sArray = new String[size];
	public void add(String s) {
		if(index < size) sArray[index++] = s;
	}
	public String get(int i) {
		if(-1 < i && i < size) return sArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sArray.length; i++) sb.append((sArray[i] + " "));
		return sb.toString();		
	}	
}

public class Ex31 {
	static long addTimeTest(StringsHolder sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.add("hi");
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long addTimeTest(ArrayList<String> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.add("hi");
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long getTimeTest(StringsHolder sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(ArrayList<String> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long addTimeTest(StringsHolder2 sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.add("hi");
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(StringsHolder2 sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	public static void main(String[] args) {		
		ArrayList<String> list = new ArrayList<String>();
		StringsHolder sh = new StringsHolder();
		System.out.println("Add times (nanoseconds):");
		System.out.println("Mean of 1000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list, 1000));
		System.out.println("StringsHolder add(): " + addTimeTest(sh, 1000));
		System.out.println("Mean of 10000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list, 10000));
		System.out.println("StringsHolder add(): " + addTimeTest(sh, 10000));
		System.out.println();
		System.out.println("Get times (nanoseconds):");
		System.out.println("Mean of 10000:");
		System.out.println("ArrayList get(): " + getTimeTest(list, 10000));
		System.out.println("StringsHolder get(): " + getTimeTest(sh, 10000));
		System.out.println();
		System.out.println("Using alternate fixed size (1000) StringsHolder2");
		System.out.println("eliminates resizing and copying:");
		ArrayList<String> list2 = new ArrayList<String>();
		StringsHolder2 sh2 = new StringsHolder2();
		System.out.println("Add times (nanoseconds):");
		System.out.println("Mean of 1000:");	
		System.out.println("ArrayList add(): " + addTimeTest(list2, 1000));
		System.out.println("StringsHolder2 add(): " + addTimeTest(sh2, 1000));
		System.out.println();
		System.out.println("Get times (nanoseconds):");
		System.out.println("Mean of 1000:");
		System.out.println("ArrayList get(): " + getTimeTest(list2, 1000));
		System.out.println("StringsHolder2 get(): " + getTimeTest(sh2, 1000));					
	}
}

/*Output:

Add times (nanoseconds):
Mean of 1000:
ArrayList add(): 209
StringsHolder add(): 6385
Mean of 10000:
ArrayList add(): 54
StringsHolder add(): 18181

Get times (nanoseconds):
Mean of 10000:
ArrayList get(): 87
StringsHolder get(): 49

Using alternate fixed size (1000) StringsHolder2
eliminates resizing and copying:
Add times (nanoseconds):
Mean of 1000:
ArrayList add(): 62
StringsHolder2 add(): 69

Get times (nanoseconds):
Mean of 1000:
ArrayList get(): 21
StringsHolder2 get(): 93

*/