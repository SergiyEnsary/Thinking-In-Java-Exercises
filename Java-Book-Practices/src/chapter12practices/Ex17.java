package chapter12practices;

import java.util.regex.*;
import java.io.*;
//Ex17 in package chapter12practices;
// Write a program that reads a Java source-code file
// and displays all the comments.

public class Ex17  {
	static final String CMNT_EXT_REGEX =
			"(?x)(?m)(?s) # Comments, Multiline & Dotall: ON\n" +
			"/\\* # Match START OF THE COMMENT\n" +
			"(.*?) # Match all chars\n" +
			"\\*/ # Match END OF THE COMMENT\n" +
			"| //(.*?)$ # OR Match C++ style comments\n";
	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			System.out.println(
					"Usage: java Ex17 file");
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		Pattern p = Pattern.compile(CMNT_EXT_REGEX);
		Matcher m = p.matcher(src);
		while(m.find())
			System.out.println(m.group(1) != null ?
					m.group(1) : m.group(2));
	}
} 
/* Output:

Ex17 in package chapter12practices;
 Write a program that reads a Java source-code file
 and displays all the comments.

 */

