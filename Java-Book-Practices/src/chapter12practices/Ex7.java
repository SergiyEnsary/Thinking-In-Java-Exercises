package chapter12practices;

/* Using the documentation for java.util.regex.Pattern as a resource,
* write and test a regular expression that checks a sentence to see
* that it begins with a captial letter and ends with a period.
*/
import java.util.regex.*;

public class Ex7 {

	public static void main(String[] args) {
		// starts with any capital A through Z
		// then zero or more of any char except endline
		// ends with . 
		String sen = "^[A-Z].*[\\.]$";
		String s1 = "Once upon a time.";
		String s2 = "abcd.";
		String s3 = "Abcd?";
		String s4 = "An easy way out.";
		String s5 = "Zorro.";
		String s6 = "X.";
		System.out.println(s1 + s1.matches(sen));
		System.out.println(s2 + s2.matches(sen));
		System.out.println(s3 + s3.matches(sen));
		System.out.println(s4 + s4.matches(sen));
		System.out.println(s5 + s5.matches(sen));
		System.out.println(s6 + s6.matches(sen));
	}
}

/* Output:

Once upon a time.true
abcd.false
Abcd?false
An easy way out.true
Zorro.true
X.true
 
 */
