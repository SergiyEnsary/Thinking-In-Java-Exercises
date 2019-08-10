package chapter10practices;

import java.util.*;

public class TextFile {
	private ArrayList<String> stringList;
	public TextFile() {
		this.stringList = new ArrayList<String>();
		this.stringList.add("one");
		this.stringList.add("two");
		this.stringList.add("three");
		this.stringList.add("four");
		this.stringList.add("five");
		this.stringList.add("six");
	}
	
	public ArrayList<String> getStrings() {
		return this.stringList;
	}
}
