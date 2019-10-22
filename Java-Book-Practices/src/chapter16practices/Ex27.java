package chapter16practices;

/* Modify the hashCode() in CountedString.java by removing the combination
 * with id, and demonstrate that CountedString still works as a key. What
 * is the problem with this approach?
 */

import java.util.*;

public class Ex27 {
	private static List<String> created = new ArrayList<String>();
	private String s;
	private int id = 0;
	public Ex27(String str) { 
		s = str;
		created.add(s);
		for(String s2: created)
			if(s2.equals(s)) id++;
	}
	public String toString() {
		return "String: " + s + " id: " + id +
				" hashCode(): " + hashCode();
	}	
	public int hashCode() {
		int result = 17;
		result = 37 * result + s.hashCode();
		return result;
	}
	public boolean equals(Object o) {
		return o instanceof Ex27 &&
				s.equals(((Ex27)o).s) &&
				id == ((Ex27)o).id;
	}
	public static void main(String[] args) {
		Map<Ex27,Integer> map = new HashMap<Ex27,Integer>();
		Ex27[] cs = new Ex27[5];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new Ex27("hi");
			map.put(cs[i], i);
		}
		System.out.println(map);
		for(Ex27 cstring : cs) {
			System.out.println("Looking up " + cstring);
			System.out.println(map.get(cstring));
		}	
	}
}

/*Output:

{String: hi id: 1 hashCode(): 3958=0, String: hi id: 2 hashCode(): 3958=1, String: hi id: 3 hashCode(): 3958=2, String: hi id: 4 hashCode(): 3958=3, String: hi id: 5 hashCode(): 3958=4}
Looking up String: hi id: 1 hashCode(): 3958
0
Looking up String: hi id: 2 hashCode(): 3958
1
Looking up String: hi id: 3 hashCode(): 3958
2
Looking up String: hi id: 4 hashCode(): 3958
3
Looking up String: hi id: 5 hashCode(): 3958
4

 */