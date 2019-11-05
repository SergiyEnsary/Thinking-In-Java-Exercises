package chapter17practices;

//Modify Exercise 8 to take additional command-line arguments of words to 
//find in the file. Print all lines in which any of the words match.


import java.io.*;
import java.util.*;

public class Ex10 {
	public static String findWordsInFile(String filename, List<String> wordsList) throws IOException {
		LinkedList<String> allLines = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			allLines.add(s);
		ListIterator<String> it = allLines.listIterator(allLines.size());
		System.out.println("Searching \"" + filename + "\" for the lines containing the following words: ");
		for(String word : wordsList)
			System.out.println("- " + word);
		System.out.println();
		while(it.hasPrevious()) {
			String line = it.previous();
			List<String> ls = Arrays.asList(line.split("\\W++"));
			if(!(Collections.disjoint(ls, wordsList))) {
				System.out.println(line);
			}
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		if(args.length < 2) {
			System.out.println("Usage: filename wordToFind1 wordToFind2 wordToFind3 ...");
			System.exit(0);
		}
		ArrayList<String> wordsToFind = new ArrayList<String>();
		for(int i = 1; i < args.length; i++) {
			wordsToFind.add(args[i]);
		}
		findWordsInFile(args[0], wordsToFind);
	}

}
/* Output:
Searching "Ex10.java" for the lines containing the following words: 
- String
- import
		ArrayList<String> wordsToFind = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
			List<String> ls = Arrays.asList(line.split("\\W++"));
			String line = it.previous();
		for(String word : wordsList)
		ListIterator<String> it = allLines.listIterator(allLines.size());
		String s;
		LinkedList<String> allLines = new LinkedList<String>();
	public static String findWordsInFile(String filename, List<String> wordsList) throws IOException {

import java.io.*;
import java.util.*;
*/