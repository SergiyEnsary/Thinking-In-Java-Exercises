package chapter10practices;

import java.util.*;
/*Take the resulting Map from previous exercise and re-create the
 *order of the words as they appeared in the original file
 */

public class Ex26{
	public static void main(String [] args) {
		Map<String, ArrayList<Integer>> map = new LinkedHashMap<String, ArrayList<Integer>>();
		List<String> words = new LinkedList<String>();
		ArrayList<String> file = new TextFile().getStrings();
		for(int i = 0; i<file.size(); i++) {
			words.add(file.get(i));
		}
		System.out.println("Words in file: " + words);
		Iterator mapIt = words.iterator();
		int count = 0;
		while(mapIt.hasNext()) {
			String str = (String)mapIt.next();
			if(!map.keySet().contains(str)) {
				ArrayList<Integer> arrayInt = new ArrayList<Integer>();
				arrayInt.add(0, count);
				map.put(str, arrayInt);
			}
			else {
				map.get(str).add(count);
				map.put(str, map.get(str));
			}
		}
		System.out.println();
		System.out.println("Map of word locations: " + map);
		Map<Integer,String> replay = new TreeMap<Integer,String>();
		Iterator<Map.Entry<String,ArrayList<Integer>>> iterator = 
				map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String,ArrayList<Integer>> mapEntry = iterator.next();
			for(int i = 0; i < mapEntry.getValue().size(); i++)
				replay.put(mapEntry.getValue().get(i),
						mapEntry.getKey());
		}
		System.out.println();
		System.out.println("TreeMap of ordered locations, words: " + replay);
		System.out.println();
		System.out.println("Words in original order: " +
				replay.values());
	}	
}