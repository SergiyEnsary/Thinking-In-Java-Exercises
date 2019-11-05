package chapter17practices;

//Modify Exercise 8 to force all the lines in the LinkedList to uppercase
//and send the results to System.out.


import java.util.*;
import java.io.*;

public class Ex9 {

	public static String readReverseAndUpperCaseLines(String filename) throws IOException {
		LinkedList<String> ll = new LinkedList<String>();
		BufferedReader in = new BufferedReader(new FileReader(new File("src\\" + filename)));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			ll.add(s.toUpperCase());
		ListIterator<String> it = ll.listIterator(ll.size());
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
			
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Usage: Enter file name.");
			System.exit(0);
		}
		readReverseAndUpperCaseLines(args[0]);
	}

}

/*Usage: enter file name
test
THIS FILE IS USED FOR SOME INPUT OUTPUT CLASSES
THIS IS A TEST FILE

*/