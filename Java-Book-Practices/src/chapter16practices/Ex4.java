package chapter16practices;

/* Create a Collection initializer that opens a file and breaks
 * it into words using TextFile, and then uses the words as the
 * source of data for the resulting Collection. Demonstrate that 
 * it works.
 */
import java.util.*;
import java.io.*;


public class Ex4 {
	static Collection<String> CollectFromText(String fileName) {		
		String[] sa = TextFile.read(fileName).split(" ");
		return Arrays.asList(sa);
	}
	static Collection<String> CollectFromText2(String fileName) {		
		String[] sa = TextFile.read(fileName).split(" ");
		return new TreeSet<String>(new TextFile(fileName, "\\W+"));
	}
	public static void main(String[] args) {
		System.out.println(CollectFromText("Ex4.java"));
		System.out.println(CollectFromText2("Ex4.java"));
	}
}
