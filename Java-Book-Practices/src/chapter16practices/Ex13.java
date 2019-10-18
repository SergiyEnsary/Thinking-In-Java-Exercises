package chapter16practices;

/* Use AssociativeArray.java to create a word-occurrence counter,
* mapping String to Integer. Using the net.mindview.util.TextFile 
* utility in this book, open a text file and break up the words
* in that file using whitespace and punctuation, and count the 
* occurrence of the words in that file.
*/
import java.util.*;
import java.io.*;

public class Ex13 {
	public static void main(String[] args) {
		String fileName = "Ex13.java";
		Set<String> words = new TreeSet<String>(new TextFile(fileName, "\\W+"));
		AssociativeArray<String,Integer> wordCount = new AssociativeArray<String,Integer>(words.size());
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