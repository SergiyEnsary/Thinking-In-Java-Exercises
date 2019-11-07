package chapter17practices;

/* Modify BasicFileOutput.java so that it uses LineNumberReader to keep
* track of the line count. Note that it's much easier to just keep track
* programmatically.
*/

import java.io.*;

public class Ex13 {
	static String file = "Ex13.out";
	public static void main(String[] args) throws IOException {
		LineNumberReader in = new LineNumberReader(new FileReader("test.txt"));
		PrintWriter out = new PrintWriter(file);
		String s;
		while((s = in.readLine()) != null )
			out.println(in.getLineNumber() + ": " + s);
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}		
}

/*Output:

1: This is a Test file
2: This file is used for some Input output classes

*/