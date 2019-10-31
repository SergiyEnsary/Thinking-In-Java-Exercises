package chapter17practices;

//Modify ProcessFiles.java so that it matches a regular expression
//rather that a fixed extension.

import java.io.*;
import java.util.regex.*;

public class ProcessFiles5 {
	public interface Strategy {
		void process(File file);
	}
	private Strategy strategy;
	private String regex;
	public ProcessFiles5(Strategy strategy, String regex) {
		this.strategy = strategy;
		this.regex = regex;
	}
	public void start(String[] args) {
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else
				for(String arg : args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						Pattern pattern = Pattern.compile(regex);
						if(pattern.matcher(arg).matches())            
							strategy.process(
									new File(arg).getCanonicalFile());
					}
				}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(
				root.getAbsolutePath(), regex))
			strategy.process(file.getCanonicalFile());
	}
	public static void main(String[] args) {
		new ProcessFiles5(new ProcessFiles5.Strategy() {
			public void process(File file) {
				System.out.println(file);
			}
		}, ".*D.*").start(args);
	}
} 

/*Output:

/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter6practices/Detergent.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter6practices/Door.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter6practices/Derived.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter6practices/Drawing.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter4practices/Chapter4Exercise07$1DefaultConstTest.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter7practices/DerivedClass1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter2practices/Dog.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter13practices/Dog.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter13practices/DynamicProxyHandler23.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter13practices/DynamicProxyHandler.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter12practices/Ex13$Display.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter12practices/DataHolder2.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter11practices/Description.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter11practices/Disposable.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter11practices/Derived.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/debugoff/Debug.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter14practices/MyClassD.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter14practices/DarthVader.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter14practices/D.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/SkipGenerator16$Double.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/CollectionData16.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/CollectionData.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/BigDecimalGenerator.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/RandomGenerator$Double.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter15practices/CountingGenerator$Double.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter16practices/CountingMapData$Entry.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter16practices/MapData.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter16practices/CountingMapData.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter1practices/Chapter1Exercise04and05$1DataOnly.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/protectedData/ProtectedData.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/SortedDirList2.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirList3.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirList2.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirList.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirListFileSizes.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/Directory.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirList2$1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/Directory$TreeInfo.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirectoryDemo.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/SortedDirList.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirList3$1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirFilter.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/DirListFileSizes$1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter17practices/Directory$1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter9practices/DragonZilla.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter9practices/DangerousMonster.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter9practices/DiceThrow.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter9practices/DiceThrow$1.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/Days.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/Dad03.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/DiceThrow.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/DiceThrowFactory.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/SecondDad04.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/chapter8practices/Dad04.class
/home/sergiy/git/Test-repo/Java-Book-Practices/bin/debug/Debug.class
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter6practices/Door.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter6practices/Drawing.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter6practices/Detergent.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter6practices/Derived.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter7practices/DerivedClass1.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter2practices/Dog.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter13practices/Dog.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/debugoff/Debug.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter14practices/DarthVader.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter15practices/CollectionData.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter16practices/CountingMapData.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter16practices/MapData.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/protectedData/ProtectedData.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/DirList.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/DirList2.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/DirList3.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/SortedDirList2.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/DirListFileSizes.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/Directory.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/chapter17practices/DirectoryDemo.java
/home/sergiy/git/Test-repo/Java-Book-Practices/src/debug/Debug.java

*/