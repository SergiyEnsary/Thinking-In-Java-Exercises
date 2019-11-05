package chapter17practices;

/* Open a text file so that you can read the file one line at a time. Read
* each line as a String and place that String object into a LinkedList. 
* Print all of the lines in the LinkedList in reverse order.
*/

import java.io.*;
import java.util.*;

public class Ex7 {
	
	public static String readAndReverse(String filename) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		LinkedList<String> list = new LinkedList<String>(); 
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			list.add(s);
		while(list.peekLast() != null)
			sb.append(list.pollLast() + "\n");
		in.close();
		return sb.toString();		
	}
	public static void main(String[] args) throws IOException {
		System.out.print(readAndReverse("test.txt"));
	}
}
/*Output:

This file is used for some Input output classes
This is a Test file

*/