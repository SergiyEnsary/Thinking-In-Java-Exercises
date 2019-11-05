package chapter17practices;

//Modify Exercise 7 so that the name of the file you read is provided as a 
//command-line argument.


import java.io.*;
import java.util.*;

public class Ex8 {
	public static String readAndReverse(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		LinkedList<String> list = new LinkedList<String>(); 
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
		while(list.peekLast() != null)
			sb.append(list.pollLast() + "\n");
		in.close();
		return sb.toString();		
	}
	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			Scanner input = new Scanner(System.in);
			System.out.println("Usage: enter file name");
			String fileInput = input.nextLine()+".txt";
			System.out.print(readAndReverse(fileInput));
		}
	}
}

/*Usage: enter file name
test
This file is used for some Input output classes
This is a Test file

*/