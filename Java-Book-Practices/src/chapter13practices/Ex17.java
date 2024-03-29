package chapter13practices;

//Modify the regular expression in ShowMethods.java to additionally
//strip off the keywords native and final (hint: us the OR operator '|').

import java.lang.reflect.*;
import java.util.regex.*;

public class Ex17 {
	private static String usage =
			"usage:\n" +
			"ShowMethods qualified.class.name\n" +
			"To show all methods in class or:\n" +
			"ShowMethods qualified.class.name word\n" +
			"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("(\\s*final)|(\\w+\\.)|(\\s*native)");
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1) {
				for(Method method : methods)
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				for(Constructor ctor : ctors)
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for(Method method : methods)
					if(method.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for(Constructor ctor : ctors)
					if(ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch(ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
}

/* Output:

public static void main(String[])
public void wait() throws InterruptedException
public void wait(long,int) throws InterruptedException
public void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public int hashCode()
public Class getClass()
public void notify()
public void notifyAll()
public ShowMethods()

*/