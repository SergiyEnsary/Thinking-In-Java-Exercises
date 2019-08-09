package chapter10practices;

import java.util.*;
/* Using a Map<String,Integer>, follow the form of UniqueWords.java to create a
* program that counts the occurrence of words in a file. Sort the results using 
* Collections.sort() with a second argument of String.CASE_INSENSITIVE_ORDER (to
* produce an alphabetic sort), and display the result.
*/

public class Ex21 {
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		System.out.println("Words to count: " + words);
		Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
		Map<String,Integer> wordCount =
			new LinkedHashMap<String,Integer>();
		Iterator it = words.iterator();
		int totalWords = 0;
		while(it.hasNext()) {
			String s = (String)it.next();
			if(words.contains(s)) {
				Integer count = wordCount.get(s);
				wordCount.put(s,
					count == null ? 1 : count + 1);
				totalWords++;
			}
		}
		System.out.println();
		System.out.println("Word count: " + wordCount);
		System.out.println();
		System.out.println("Total words: " + totalWords);		
	}		
}