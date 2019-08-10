package chapter10practices;

import java.util.*;
/* Create a Map<String, ArrayList<Integer>>. Use net.mindview.TextFile
* to open a text file and read it in a word at a time (use "\\W+\" as
* the second argument to the TextFile constructor). Count the words as
* you read them in, and for each word in the file, record in the
* ArrayList<Integer> the word count associated with that word - that is,
* in effect, the location in the file where that word was found.
*/

public class Ex25 {
	public static void main(String[] args) {
		Map<String,ArrayList<Integer>> map = new LinkedHashMap<String,ArrayList<Integer>>();
		List<String> words = new LinkedList<String>();
		ArrayList<String> file = new TextFile().getStrings();
		for(int i = 0; i<file.size(); i++) {
			words.add(file.get(i));
		}
		System.out.println("Words in file: " + words);
		
		Iterator itWords = words.iterator();
		int count = 0;
		
		while(itWords.hasNext()) {
			String str = (String)itWords.next();
			count++;			
			
			if(!map.keySet().contains(str)) {	
				ArrayList<Integer> arrayList = new ArrayList<Integer>();		
				arrayList.add(0, count);
				map.put(str, arrayList);
			}
			
			else {
				map.get(str).add(count);
				map.put(str, map.get(str));  	
			}
		}
		System.out.println("Map of word locations: " + map);			
	}	
}