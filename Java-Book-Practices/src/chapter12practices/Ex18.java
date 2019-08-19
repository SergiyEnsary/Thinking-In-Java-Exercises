package chapter12practices;

import java.util.regex.*;
/*
 * Write a program that reads a Java source-code file
 * and displays all the string literals in the code
 */
public class Ex18 {
	static final String STR_EXT_REGEX =
			"\"(?:[^\"\\\\\\n\\r]|(?:\\\\(?:[untbrf\\\\'\"]"
					+ "|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"";
	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			System.out.println(
					"Usage: java Ex18 file");
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		Pattern p =	Pattern.compile(STR_EXT_REGEX);
		Matcher m = p.matcher(src);
		while(m.find()) {
			System.out.println(m.group().substring(1, m.group().length() - 1));
		}
		// "This is NOT a string but a comment!"
		String dummy = "\u003F\u003f\n\060\607";
	}
} 
/*
 *Output:

\"(?:[^\"\\\\\\n\\r]|(?:\\\\(?:[untbrf\\\\'\"]
|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"
Usage: java Ex18 file
This is NOT a string but a comment!
\u003F\u003f\n\060\607 

*/