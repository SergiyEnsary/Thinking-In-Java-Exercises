package chapter10practices;

/* Modify listFeatures.java so that it uses String instead of Pets, 
 * and explain any difference in results.
 */

import java.util.*;

public class Ex6 {
	public static void main(String[] args) {
		Random rand = new Random();
		List<String> list = new ArrayList<String>();
		System.out.print("0: " + list);
		Collections.addAll(list, "oh", "what", "a", "beautiful", "Wednesday", "morning");
		System.out.print("1: " + list);
		String h = new String("hi");
		list.add(h);
		System.out.print("2: " + list);
		System.out.print("3: " + list.contains(h));
																		// removes the first instance equivalent to String h:
		list.remove(h);
		System.out.print("3.5: " + list);
		String p = list.size() > 2 ? list.get(2) : null;
		System.out.print("4: " + p + " " +  list.indexOf(p));
		String cyan = new String("cyan");
		System.out.print("5: " + cyan +" " + list.indexOf(cyan));
		System.out.print("6: " + list.remove(cyan));
		System.out.print("7: " + list.remove(p));
		System.out.print("8: " + list);
		if(list.size() > 3)
			list.add(3, "wonderful");
		System.out.print("9: " + list);
		if(list.size() < 4) {
			List<String> s = 
					Arrays.asList("one", "two", "three", "four");
			list.addAll(0, s);
		}
		List<String> sub = list.subList(1, 4);
		System.out.print("sublist: " + sub);
		System.out.print("10: " + list.containsAll(sub));
																		//sort sub elements within list:
		Collections.sort(sub);
		System.out.print("sorted sublist: " + sub);
		System.out.print("11: " + list.containsAll(sub));
		System.out.print("11.25: " + list);
																		//shuffle sub elements within list:
		Collections.shuffle(sub, rand);
		System.out.print("11.5: " + list);
		System.out.print("shuffled sublist: " + sub);
		System.out.print("12: " + list.containsAll(sub));
		List<String> copy = new ArrayList<String>(list);
		System.out.print("12.5: " + list);
		if(list.size() < 5) {
			list.add("two");
			list.add("more");
		}
		sub = Arrays.asList(list.get(1), list.get(4));
		System.out.print("sub: " + sub);	
		copy.retainAll(sub);
		System.out.print("13: " + copy);
		copy = new ArrayList<String>(list);
		copy.remove(2);
		System.out.print("14: " + copy);
		copy.removeAll(sub); 
		System.out.print("15: " + copy);
		if(copy.size() > 1) 											//avoid out of bounds exception
			copy.set(1, "excellent"); 
		System.out.print("16: " + copy);
		if(copy.size() > 2)
			copy.addAll(2, sub);
		System.out.print("17: " + copy);
		System.out.print("18: " + list.isEmpty());
		list.clear();
		System.out.print("19: " + list);
		System.out.print("20: " + list.isEmpty());
		list.addAll(0, sub);
		list.addAll(2, sub);
		System.out.print("21: " + list);
		Object[] o = list.toArray();
		System.out.print("22: " + o[3]);
		String[] sa = list.toArray(new String[0]);
		System.out.print("23: " + sa[3]);
	}
}