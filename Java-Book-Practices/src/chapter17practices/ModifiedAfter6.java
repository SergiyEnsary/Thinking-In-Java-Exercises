package chapter17practices;

/* Use ProcessFiles to find all the Java source-source code files in
 * a particular directory subtree that have been modified after a 
 * particular date.
 */

import java.io.*;
import java.text.*;
import java.util.*;

public class ModifiedAfter6 {
	public static void main(final String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: directory date(mm/dd/yyyy)");
			System.out.println("(Outputs a listing of all java files in the given directory" +
					"\nthat were last modified on or after the given date.)");
			return;
		}
		final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		new ProcessFiles(new ProcessFiles.Strategy() {
			public void process(File file) {
				Date modDate = new Date(file.lastModified());
				try {
					if(modDate.after(sdf.parse(args[1])))
						System.out.println(file);
				} catch(ParseException e) {
					System.out.println(e.getMessage());
				}
			}
		}, "java").start(args);
	}
}