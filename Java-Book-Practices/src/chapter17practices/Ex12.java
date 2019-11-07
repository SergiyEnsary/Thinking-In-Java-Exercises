package chapter17practices;

/* Modify Exercise 8 to also open a text file so you can write text into it. 
* Write the lines in the LinkedList, along with line numbers, out to the file.
*/

import java.io.*;
import java.util.*;

public class Ex12 {
	public static String readAndReverse(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		LinkedList<String> list = new LinkedList<String>(); 
		StringBuilder sb = new StringBuilder();
		String[] temp = filename.split("\\.");
		String file = temp[0] + "Reversed." + temp[1]; 
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		while((s = in.readLine()) != null)
			list.add(lineCount++ + " " + s); 
		while(list.peekLast() != null) {
			String t = list.pollLast();
			out.println(t);
			sb.append(t + "\n"); 
		}
		in.close();
		out.close();
		return sb.toString();		
	}
	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Usage: enter file name");
			System.exit(1);
		}
		System.out.println(readAndReverse(args[0]));
	}
}