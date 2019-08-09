package chapter10practices;
import java.util.*;
/* Fill a LinkedHashMap with String keys and objects of your choice.
* Now extract the pairs, sort them based on the keys, and reinsert
* them into the Map.
*/

public class Ex24{	
	public static void main(String[] args) {
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		
		map.put("ten", 10);
		map.put("nine", 9);
		map.put("eight", 8);
		map.put("seven", 7);
		map.put("six", 6);
		map.put("five", 5);
		map.put("four", 4);
		map.put("three", 3);
		map.put("two", 2);
		map.put("one", 1);
		map.put("zero", 0);
		
		System.out.println("Map to sort: " + map);
		
		Map<String,Integer> mapTemp = new LinkedHashMap<String,Integer>();
		Set<String> ss = new TreeSet<String>(map.keySet());
		Iterator<String> iterator = ss.iterator();
		
		while(iterator.hasNext()) {
			String str = (String)iterator.next();
			Integer intgr = map.get(str);
			map.remove(str);
			mapTemp.put(str, intgr);
		}
		
		Set<String> ssTemp = new TreeSet<String>(mapTemp.keySet());
		Iterator<String> iteratorTemp = ssTemp.iterator();
		
		while(iteratorTemp.hasNext()) {
			String string = (String)iteratorTemp.next();
			Integer integer = mapTemp.get(string);
			mapTemp.remove(string);
			map.put(string, integer);
		}
		
		mapTemp.clear();
		System.out.println("Sorted map: " + map);
	}
}
