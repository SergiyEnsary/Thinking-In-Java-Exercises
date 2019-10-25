package chapter16practices;

//Modify the class in the previous exercise so that it will work with
//HashSets and as a key in HashMaps.

import java.util.*;
import chapter15practices.*;

public class Ex41 implements Comparable<Ex41> {
	private String first = "";
	private String second = "";
	public Ex41(String s1, String s2) {
		first = s1;
		second = s2;
	}
	public int compareTo(Ex41 ts) {
		return first.compareTo(ts.first);
	}
	public static class Comp2 implements Comparator<Ex41> {
		public int compare(Ex41 ts1, Ex41 ts2) {
			return ts1.second.compareTo(ts2.second);
		}
	}
	public String toString() {
		return first + " & " + second;
	}
	static void printArray(Ex41[] sa) {
		System.out.print("(");
		for(int i = 0; i < sa.length - 1; i++) 
			System.out.print(sa[i] + ", ");
		System.out.print(sa[sa.length - 1] + ")");		
	}
	public static void main(String[] args) {
		RandomGenerator.String rgs = new RandomGenerator.String(4);
		RandomGenerator.Integer rgi = new RandomGenerator.Integer(100);
		Set<Ex41> set = new HashSet<Ex41>();
		Map<Ex41,Integer> map = new HashMap<Ex41,Integer>();
		for(int i = 0; i < 4; i++) {
			String s1 = rgs.next();
			String s2 = rgs.next();
			set.add(new Ex41(s1, s2));
			map.put(new Ex41(s1, s2), rgi.next());
		}
		System.out.println("Set: " + set);
		System.out.println("Map: " + map);
		System.out.println("map.keySet(): " + map.keySet());
		System.out.println("Sorted by first String:");
		Set<Ex41> treeSet = new TreeSet<Ex41>(set);
		Map<Ex41,Integer> treeMap = new TreeMap<Ex41,Integer>(map);
		System.out.println("TreeSet: " + treeSet);
		System.out.println("TreeMap: " + treeMap);
		System.out.println("Sorted by second String:");
		Ex41.Comp2 comp = new Ex41.Comp2();
		Set<Ex41> treeSet2 =  new TreeSet<Ex41>(comp);
		Map<Ex41,Integer> treeMap2 =  new TreeMap<Ex41,Integer>(comp);
		treeSet2.addAll(treeSet);
		treeMap2.putAll(treeMap);
		System.out.println("TreeSet2: " + treeSet2);
		System.out.println("TreeMap2: " + treeMap2);		
	}
}

/*Output:

Set: [FOWZ & nTcQ, RoEs & uEcU, YNzb & rnyG, GseG & ZMmJ]
Map: {FOWZ & nTcQ=61, GseG & ZMmJ=6, YNzb & rnyG=22, RoEs & uEcU=96}
map.keySet(): [FOWZ & nTcQ, GseG & ZMmJ, YNzb & rnyG, RoEs & uEcU]
Sorted by first String:
TreeSet: [FOWZ & nTcQ, GseG & ZMmJ, RoEs & uEcU, YNzb & rnyG]
TreeMap: {FOWZ & nTcQ=61, GseG & ZMmJ=6, RoEs & uEcU=96, YNzb & rnyG=22}
Sorted by second String:
TreeSet2: [GseG & ZMmJ, FOWZ & nTcQ, YNzb & rnyG, RoEs & uEcU]
TreeMap2: {GseG & ZMmJ=6, FOWZ & nTcQ=61, YNzb & rnyG=22, RoEs & uEcU=96}

 */