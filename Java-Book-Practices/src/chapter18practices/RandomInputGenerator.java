package chapter18practices;

import java.util.Iterator;

import chapter13practices.Generator;
import chapter17practices.TextFile;

class RandomInputGenerator implements Generator<Input> {
	public Input next() { return Input.randomSelection(); }
}
// Create Inputs from a file of ‘;’-separated strings:
class FileInputGenerator implements Generator<Input> {
	private Iterator<String> input;
	public FileInputGenerator(String fileName) {
		input = new TextFile(fileName, ";").iterator();
	}
	public Input next() {
		if(!input.hasNext())
			return null;
		return Enum.valueOf(Input.class, input.next().trim());
	}
}