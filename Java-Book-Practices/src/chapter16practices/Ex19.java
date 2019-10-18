package chapter16practices;

//Repeat Exercise 13 using a SimpleHashMap.
import java.util.*;

public class Ex19 {
	public static void main(String[] args) {
		String fileName = "WordCounter19.java";
		Set<String> words = new TreeSet<String>(new TextFile(fileName, "\\W+"));
		SimpleHashMap<String,Integer> wordCount = new SimpleHashMap<String,Integer>();
		ArrayList<String> fileList = new TextFile(fileName, "\\W+");
		for(String s : words) {
			int count = 0;
			for(String t : fileList) {
				if(t.equals(s)) count++;
			}
			wordCount.put(s, count);
		}
		System.out.println(wordCount);
	}
}