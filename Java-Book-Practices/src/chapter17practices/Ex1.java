package chapter17practices;

/* Modify DirList.java (or one of it's variants) so that the FilenameFilter
 * opens and reads each file (using the net.mindview.util.TextFile utility) 
 * and accepts the file based on whether any of the trailing arguments on the
 * command line exist in that file.
 */

import java.util.regex.*;
import java.io.*;
import java.util.*;
import chapter17practices.TextFile;

public class Ex1 {		
	public static void main(final String[] args) {
		File path = new File(".");
		final String[] list;
		if(args.length < 2) { 
			list = path.list();
			System.out.println("Usage: enter filtering regex");
			System.out.println("followed by words, one or more of which each file must contain.");
		}
		else {
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches() && 
							!(Collections.disjoint(Arrays.asList(args).subList(1, args.length), new TextFile(name, "\\W+")));
				}
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}

/*Output:

Usage: enter filtering regex
followed by words, one or more of which each file must contain.
.classpath
.gitignore
.project
.settings
bin
src
test.txt
test2.txt

 */