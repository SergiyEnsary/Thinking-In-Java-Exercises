package chapter16practices;

//Modify SetPerformance.java so that the Sets hold String objects instead 
//of Integers. Use a Generator from the Arrays chapter to create test values.

import java.util.*;
import chapter15practices.*;

public class Ex34 {
	static CountingGenerator.String cgs = new CountingGenerator.String(5);
	static CountingGenerator.String cgs2 = new CountingGenerator.String(5);
	static List<Test<Set<String>>> tests = new ArrayList<Test<Set<String>>>();
	static {
		tests.add(new Test<Set<String>>("add") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					set.clear();
					for(int j = 0; j < size; j++) 
						set.add(cgs.next());
				}
				return loops * size;
			}
		});
		tests.add(new Test<Set<String>>("contains") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for(int i = 0; i < loops; i++)
					for(int j = 0; j < span; j++)
						set.contains(cgs2.next());
				return loops * span;
			}
		});
		tests.add(new Test<Set<String>>("iterate") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops * 10;
				for(int i = 0; i < loops; i++) {
					Iterator<String> it = set.iterator();
					while(it.hasNext()) it.next();
				}
				return loops * set.size();
			}
		});
	}
	public static void main(String[] args) {
		if(args.length < 0)
			Tester.defaultParams = TestParam.array(args);
		Tester.fieldWidth = 10;
		Tester.run(new TreeSet<String>(), tests);
		Tester.run(new HashSet<String>(), tests);
		Tester.run(new LinkedHashSet<String>(), tests);	
	}
}	

/*Output:

------------- TreeSet -------------
size       add  contains   iterate
  10       570       220        62
 100       257        71         5
1000        73        56         2
10000        66        54         2
------------- HashSet -------------
size       add  contains   iterate
  10       261       185        36
 100       111        52         8
1000        57        49         8
10000        58        50         8
---------- LinkedHashSet ----------
size       add  contains   iterate
  10       268        66        19
 100        94        54         8
1000        59        54         6
10000        59        53         5

 */