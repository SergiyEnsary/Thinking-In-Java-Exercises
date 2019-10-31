package chapter17practices;

//Use Directory.walk() to sum the sizes of all files in a directory
//tree whose names match a particular regular expression.

import java.io.*;

public class Ex4 {
	public static void main(String[] args) {
		long sum = 0;
		if(args.length == 0) {
			for(File file : Directory.walk(".").files) {
				System.out.print(file + ": ");
				System.out.println(file.length());
				sum += file.length();
			}

		}
		else 
			for(String arg : args) {
				{
					for(File file : Directory.walk(".", arg).files) {
						System.out.print(file + ": ");
						System.out.println(file.length());
						sum += file.length();
					}
					System.out.println();
				}
			}
		System.out.println("Total size: " + sum);
	}
}

/*Output:
....
./src/chapter10practices/Ex10.java: 2083
./src/chapter10practices/Ex12.java: 954
./src/chapter10practices/Ex24.java: 1335
./src/chapter10practices/Ex7.java: 963
./src/chapter10practices/Ex30.java: 1177
./src/chapter10practices/Ex19.java: 1894
./src/chapter10practices/Ex8.java: 635
./src/chapter10practices/Ex4.java: 1605
./src/chapter10practices/Ex25.java: 1305
./src/chapter10practices/Ex29.java: 547
./src/chapter10practices/Ex1.java: 857
./src/debug/Debug.java: 167
./.classpath: 386
./.project: 378
./test2.txt: 0
./.gitignore: 6
./test.txt: 67
Total size: 1808095
 */