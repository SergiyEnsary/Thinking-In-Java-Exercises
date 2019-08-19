package chapter12practices;

/* Apply the regular expression:
 * 	(?i)((^[aeiou])|(\s+[aeiou]))\W+?[aeiou]\b
 * 	to
 * 	"Arline ate eight apples and one orange while Anita hadn't any"
 */ 
// Use args: "Arline ate eight apples and one orange while Anita hadn't any"
// 	(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
import java.util.regex.*;

public class Ex11 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile( "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
		Matcher m = p.matcher("Arline ate eight apples and " + "one orange while Anita hadn't any");
		while(m.find()) {
			System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1)); 
		}
	}
}
/*
 *Output:

Match "Arline" at positions 0-5
Match " ate" at positions 6-9
Match " one" at positions 27-30
Match " orange" at positions 31-37
Match " Anita" at positions 44-49

 */