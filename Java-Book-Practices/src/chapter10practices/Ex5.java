package chapter10practices;

/* Modify ListFeatures.java so that it uses Integers (remember 
 * autoboxing!) instead of Pets, and explain any difference in
 * results.
 */
import java.util.*;

public class Ex5 {
															// method to make a List<Integer> with random values < n:
	public static List<Integer> liststOfRandInteger(int length, int n) {
		Random rand = new Random();
		List<Integer> list = new ArrayList<Integer>(); 
		for(int i = 0; i < length; i++)
			list.add(rand.nextInt(n)); 		
		return list;	
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> list = liststOfRandInteger(7, 10);
		System.out.print("1: " + list);
		Integer h = new Integer(rand.nextInt(10));
		list.add(h);
		System.out.print("2: " + list);
		System.out.print("3: " + list.contains(h));
															// removes the first instance equivalent to Integer h:
		list.remove(h);
		System.out.print("3.5: " + list);
		Integer p = list.get(2);
		System.out.print("4: " + p + " " +  list.indexOf(p));
		Integer cy = new Integer(rand.nextInt(10));
		System.out.print("5: " + cy +" " + list.indexOf(cy));
		System.out.print("6: " + list.remove(cy));
		System.out.print("7: " + list.remove(p));
		System.out.print("8: " + list);
		list.add(3, new Integer(rand.nextInt(10)));
		System.out.print("9: " + list);
		List<Integer> sub = list.subList(1, 4);
		System.out.print("sublistst: " + sub);
		System.out.print("10: " + list.containsAll(sub));
															// will also sort sub elements within list:
		Collections.sort(sub);
		System.out.print("sorted sublistst: " + sub);
		System.out.print("11: " + list.containsAll(sub));
		System.out.print("11.25: " + list);
															// will also shuffle sub elements within list:
		Collections.shuffle(sub, rand);
		System.out.print("11.5: " + list);
		System.out.print("shuffled sublistst: " + sub);
		System.out.print("12: " + list.containsAll(sub));
		List<Integer> copy = new ArrayList<Integer>(list);
		System.out.print("12.5: " + list);
		sub = Arrays.asList(list.get(1), list.get(4));
		System.out.print("sub: " + sub);	
		copy.retainAll(sub);
		System.out.print("13: " + copy);
		copy = new ArrayList<Integer>(list);
		copy.remove(2);
		System.out.print("14: " + copy);
		copy.removeAll(sub); 
		System.out.print("15: " + copy);
		if(copy.size() > 1) 								// avoid out of bounds
			copy.set(1, 8); 								// autoboxing int --> Integer
		System.out.print("16: " + copy);
		if(copy.size() > 2)
			copy.addAll(2, sub);
		System.out.print("17: " + copy);
		System.out.print("18: " + list.isEmpty());
		list.clear();
		System.out.print("19: " + list);
		System.out.print("20: " + list.isEmpty());
		list.addAll(liststOfRandInteger(4, 10));
		System.out.print("21: " + list);
		Object[] o = list.toArray();
		System.out.print("22: " + o[3]);
		Integer[] ia = list.toArray(new Integer[0]);
		System.out.print("23: " + ia[3]);
	}
}