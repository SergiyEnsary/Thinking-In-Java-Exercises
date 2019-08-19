package chapter12practices;
/*
 * Exercise 12: (5) Modify Groups.java to count all of the unique words that do not start
 * with a capital letter.
 */
import java.util.*;
import java.util.regex.*;
public class Ex12 { 
	public static void main(String[] args) { 
		Set<String> words = new HashSet<String>();
		Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);
		while(m.find()) words.add(m.group(1)); 
		System.out.println("Number of unique words = " + words.size()); 
		System.out.println(words.toString()); 
	} 
}
/*
 *Output:

Number of unique words = 25
[raths, mimsy, mome, gimble, that, claws, brillig, son, gyre, and, borogoves, bite, bird, catch, shun, toves, jaws, in, outgrabe, my, the, slithy, were, wabe, frumious]

 */