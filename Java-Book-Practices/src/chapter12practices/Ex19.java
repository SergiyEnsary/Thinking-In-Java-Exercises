package chapter12practices;
/*
 * Build on Exercises 17 and 18 to write a program
 * that examines Java source code and produces all
 * class names used in a particular program. 
 */
import java.util.regex.*;

public class Ex19 {
	
	private static final String Identifier ="[$A-Za-z_][$A-Za-z_0-9]*";
	private static final String ClassOrInterfaceType =Identifier + "(?:\\." + Identifier + ")*";
	
	static final String CU_REP_REGEX =
			"class\\s+" + Identifier +
			"|extends\\s+" + ClassOrInterfaceType +
			"|new\\s+" + ClassOrInterfaceType;
	
	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			System.out.println(
					"Usage: java Ex19 file");
			System.exit(0);
		}
		String src = TextFile.read(args[0]);
		
		src = src.replaceAll(Ex17.CMNT_EXT_REGEX, "");
		src = src.replaceAll(Ex18.STR_EXT_REGEX, "");
		
		Pattern p = Pattern.compile(CU_REP_REGEX);
		Matcher m = p.matcher(src);
		while(m.find())
			System.out.println(m.group());
	}
} 
/*
 *Output:

class Ex17
class Ex18
class Ex19

*/