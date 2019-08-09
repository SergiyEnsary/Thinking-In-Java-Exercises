package chapter10practices;

import java.util.*;
/* Starting with Statistics.java, create a program that runs the test repeatedly
 * and looks to see if any one number tends to appear more than the others in the
 * results.
 */

public class Ex23 {
	private static int getBestInt10(int n) {
		Random rand = new Random();
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

		for(int i = 0; i < 10000; i++) {
			int random = rand.nextInt(10);
			Integer freq = m.get(random);
			m.put(random, freq == null ? 1 : freq + 1);
		}

		int max = 0;
		for(int i = 0; i < m.keySet().size(); i++) {
			max = max < m.get(i) ? m.get(i) : max;
		}

		Set<Map.Entry<Integer,Integer>> me = new LinkedHashSet<Map.Entry<Integer,Integer>>(m.entrySet());
		int maxKey = 0;
		Iterator<Map.Entry<Integer,Integer>> iterator = me.iterator();

		while(iterator.hasNext()) {
			Map.Entry<Integer,Integer> findMax = iterator.next();
			if(findMax.getValue() == max) {
				maxKey = findMax.getKey();
			}
		}
		return maxKey;			
	}

	public static void main(String[] args) {
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();

		for(int index = 0; index < 2000; index++) {
			int x = getBestInt10(10000);
			Integer freq = map.get(x);
			map.put(x, freq == null ? 1 : freq + 1);
		}

		System.out.println("Most often picked ints, 0 - 10, in 2000 tests of 10,000 random picks: " + map);
	}
}
