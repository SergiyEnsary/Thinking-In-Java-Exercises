package chapter12practices;

import java.io.PrintStream;
import java.util.*;
//Modify Turtle.java so that it sends all output to System.err.

public class Turtle3 {
	private String name;
	private Formatter f;
	public Turtle3(String name, Formatter f) {
		this.name = name;
		this.f = f;
	}
	public void move(int x, int y) {
		f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
	}
	public static void main(String[] args) {
		PrintStream outAlias = System.err;
		Turtle3 tommy = new Turtle3("Tommy", new Formatter(System.err));
		Turtle3 terry = new Turtle3("Terry", new Formatter(outAlias));
		tommy.move(0,0);
		terry.move(4,8);
		tommy.move(3,4);
		terry.move(2,5);
		tommy.move(3,3);
		terry.move(3,3);	
	}
}
/*Output(Red):

Tommy The Turtle is at (0,0)
Terry The Turtle is at (4,8)
Tommy The Turtle is at (3,4)
Terry The Turtle is at (2,5)
Tommy The Turtle is at (3,3)
Terry The Turtle is at (3,3)

*/