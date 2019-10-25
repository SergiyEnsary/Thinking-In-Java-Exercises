package chapter16practices;

/* Look up the HashMap class in the JDK documentation. Create a
 * HashMap, fill it with elements, and determine the load factor.
 * Test the lookup speed with this map, then attempt to increase
 * the speed by making a new HashMap with a larger initial capacity
 * and copying the old map into the new one, then run your lookup
 * speed test again on the new map.
 */

import java.util.*;
import chapter15practices.*;

public class Ex38 {
	static List<Test<Map<Integer,String>>> tests = new ArrayList<Test<Map<Integer,String>>>();
	static CountingGenerator.String cgs = new CountingGenerator.String(5);
	static {
		tests.add(new Test<Map<Integer,String>>("put") {
			int test(Map<Integer,String> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					map.clear();
					for(int j = 0; j < size; j++) 
						map.put(j, cgs.next());
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer,String>>("get") {
			int test(Map<Integer,String> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for(int i = 0; i < loops; i++)
					for(int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer,String>>("iterate") {
			int test(Map<Integer,String> map, TestParam tp) {
				int loops = tp.loops * 10;
				for(int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while(it.hasNext()) it.next();
				}
				return loops * map.size();
			}
		});
	}
	public static void main(String[] args) {
		HashMap<Integer,String> map1 = new HashMap<Integer,String>();		
		System.out.println("map1: " + map1);
		map1.putAll(new CountingMapData(16));
		System.out.println("map1: " + map1);	
		HashMap<Integer,String> map2 = new HashMap<Integer,String>(64);
		System.out.println("map2: " + map2);
		map2.putAll(map1);
		System.out.println("map2: " + map2);
		HashMap<Integer,String> map3 = new HashMap<Integer,String>(1028);
		System.out.println("map3: " + map3);
		map2.putAll(map1);
		System.out.println("map3: " + map3);
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000, 1000);
		System.out.println("Comparative time tests:");		
		Tester.run(map1, tests);
		Tester.run(map2, tests);
		Tester.run(map3, tests);
	}
} 

/*Output:

map1: {}
map1: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0}
map2: {}
map2: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0}
map3: {}
map3: {}
Comparative time tests:
---------- HashMap ----------
 size     put     get iterate
   10     589      81      86
  100     163      27      13
 1000      90       5       2
---------- HashMap ----------
 size     put     get iterate
   10      53       3       3
  100      81      14       2
 1000      55       7       1
---------- HashMap ----------
 size     put     get iterate
   10     144       2      53
  100      93       5       6
 1000      71       3       1

 */