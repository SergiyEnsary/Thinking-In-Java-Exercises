package chapter16practices;

//Modify MapPerformance.java to include tests of SlowMap.

import java.util.*;

public class Ex35 {
	static List<Test<Map<Integer,Integer>>> tests = new ArrayList<Test<Map<Integer,Integer>>>();
	static {
		tests.add(new Test<Map<Integer,Integer>>("put") {
			int test(Map<Integer,Integer> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					map.clear();
					for(int j = 0; j < size; j++) 
						map.put(j, j);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer,Integer>>("get") {
			int test(Map<Integer,Integer> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for(int i = 0; i < loops; i++)
					for(int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer,Integer>>("iterate") {
			int test(Map<Integer,Integer> map, TestParam tp) {
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
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(10, 500, 100, 500, 500, 100);
		Tester.run(new SlowMap<Integer,Integer>(), tests);
		Tester.run(new TreeMap<Integer,Integer>(), tests);
		Tester.run(new HashMap<Integer,Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer,Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer,Integer>(), tests);
		Tester.run(new WeakHashMap<Integer,Integer>(), tests);
		Tester.run(new Hashtable<Integer,Integer>(), tests);
	}
}	

/*Output:

---------- SlowMap ----------
size     put     get iterate
  10     501     188      89
 100     243     166      17
 500     380     295      23
---------- TreeMap ----------
size     put     get iterate
  10     897     190     102
 100     387      83      10
 500     150      35      18
---------- HashMap ----------
size     put     get iterate
  10     153      96     115
 100     110      31      17
 500      40      43      15
------- LinkedHashMap -------
size     put     get iterate
  10     289      58      33
 100      51      11       7
 500      27       9       9
------ IdentityHashMap ------
size     put     get iterate
  10     197      59      79
 100      42      28      17
 500      62      66      19
-------- WeakHashMap --------
size     put     get iterate
  10     338      97      58
 100      60       8      17
 500      71      29      14
--------- Hashtable ---------
size     put     get iterate
  10     369      60      63
 100      51      61      16
 500      46      17      14

*/