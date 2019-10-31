package chapter17practices;

//Modify DirList.java (or one of its variants) so that it
//sums up the file sizes of the selected files.


import java.io.*;
import java.util.regex.*;
import java.util.*;

public class DirListFileSizes {	
	public static void main(final String[] args) {
		File path = new File(".");
		File[] files;
		if(args.length == 0)
			files = path.listFiles(); 
		else
			files = path.listFiles(new FileFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File file) {
					return pattern.matcher(file.getPath()).matches();
				}
			});
		Arrays.sort(files);
		long sum = 0;
		for(File f : files) {
			System.out.print(f + ": ");
			System.out.println(f.length());
			sum += f.length();
		}
		System.out.println("Total size: " + sum);
	}
}

/*Output:

./.classpath: 386
./.gitignore: 6
./.project: 378
./.settings: 4096
./bin: 4096
./src: 4096
./test.txt: 67
./test2.txt: 0
Total size: 13125

*/