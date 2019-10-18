package chapter16practices;

//Repeat Exercise 13 using a SlowMap. 
import java.util.*;

public class Ex15 {
	public static void main(String[] args) {
		// File whose words are to be counted:
		String fileName = "WordCounter15.java";
		// List of all words in file:
		ArrayList<String> wordList = new TextFile(fileName, "\\W+");
		SlowMap<String,Integer> wordCount = new SlowMap<String,Integer>();
		Iterator it = wordList.iterator();
		while(it.hasNext()) {
			String s = (String)it.next();
			if(!(wordCount.containsKey(s))) wordCount.put(s,1);
			else {
				int count = wordCount.get(s);
				wordCount.put(s, ++count);
			}
		}
		System.out.println(wordCount);		
	}
}