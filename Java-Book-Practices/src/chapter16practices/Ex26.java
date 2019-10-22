package chapter16practices;

/* Add a char field to CountedString that is also initialized in the 
 * constructor; and modify the hashCode() and equals() methods to 
 * include the value of this char.
 */

import java.util.*;

public class Ex26 {
	private static List<String> created = new ArrayList<String>();
	private String s;
	private int id = 0;
	private char c;
	public Ex26(String str, char ch) {
		s = str;
		c = ch;
		created.add(s);
		for(String s2 : created)
			if(s2.equals(s)) id++;
	}
	public String toString() {
		return "String: " + s + " id: " + id + ", c: " + c  + ", hashCode(): " + hashCode();
	}
	public int hashCode() {
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		result = 37 * result + c;
		return result;
	}	
	public boolean equals(Object o) {
		return o instanceof Ex26 &&
				s.equals(((Ex26)o).s) &&
				id == ((Ex26)o).id &&
				c == ((Ex26)o).c;
	}
	public static void main(String[] args) {
		Map<Ex26,Integer> map = new HashMap<Ex26,Integer>();
		Ex26[] cs = new Ex26[5];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new Ex26("hi", 'x');
			map.put(cs[i], i); // Autobox int -> Integer
		}
		System.out.println(map);
		for(Ex26 cstring : cs) {
			System.out.println("Looking up " + cstring);
			System.out.println(map.get(cstring));
		}	

	}
}

/*Output:

{String: hi id: 4, c: x, hashCode(): 5418770=3, String: hi id: 1, c: x, hashCode(): 5418659=0, String: hi id: 5, c: x, hashCode(): 5418807=4, String: hi id: 2, c: x, hashCode(): 5418696=1, String: hi id: 3, c: x, hashCode(): 5418733=2}
Looking up String: hi id: 1, c: x, hashCode(): 5418659
0
Looking up String: hi id: 2, c: x, hashCode(): 5418696
1
Looking up String: hi id: 3, c: x, hashCode(): 5418733
2
Looking up String: hi id: 4, c: x, hashCode(): 5418770
3
Looking up String: hi id: 5, c: x, hashCode(): 5418807
4

 */