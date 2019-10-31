package chapter17practices;

/* Create as class called SortedDirList with a constructor that takes
 * a File object and builds a sorted directory list from the files at 
 * that File. Add to this class two overloaded list() methods: the first
 * produces the whole list, and the second produces the subset of the list
 * that matches its argument (which is a regular expression).
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SortedDirList2 {
	private String[] dirList;
	public SortedDirList2(File dir) {
		dirList = dir.list();
		Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
	}
	public String[] list() { return dirList; }
	public String[] list(String regex) {
		Pattern pattern = Pattern.compile(regex);
		ArrayList<String> slist = new ArrayList<String>();
		int count = 0;
		for(String s : dirList) {
			if(pattern.matcher(s).matches()) {
				count++;
				slist.add(s);
			}
		}
		return slist.toArray(new String[count]);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s : dirList) 
			sb.append(s + '\n');
		return sb.toString();
	}
	public static void main(String[] args) {
		SortedDirList2 dirList = new SortedDirList2(new File("."));
		System.out.println(dirList);
		for(String s : dirList.list()) 
			System.out.println(s);
		System.out.println();
		for(String s : dirList.list(".+\\.java"))
			System.out.println(s);
	}
}

/*Output:

.classpath
.gitignore
.project
.settings
bin
src
test.txt
test2.txt

.classpath
.gitignore
.project
.settings
bin
src
test.txt
test2.txt

 */