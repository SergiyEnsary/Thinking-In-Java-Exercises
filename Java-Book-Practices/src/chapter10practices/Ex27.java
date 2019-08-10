package chapter10practices;

import java.util.*;
/* Write a class called Command that contains a String and has a method operation()
 * that displays the String. Write a second class with a method that fills a Queue
 * with Command objects and returns it. Pass the filled Queue to a method in a third
 * class that consumes the objects in the Queue and calls their operation() methods.
 */

class Command {
	String str;
	Command(String str) { this.str = str; }
	void operation() { System.out.print(str); }
}

class Build {	
	Queue<Command> makeQueue() {
		Queue<Command> queue = new LinkedList<Command>();
		for(int i = 0; i < 10; i++) {
			queue.offer(new Command(i + " "));
		}
		return queue;
	}
}

public class Ex27 {
	public static void commandEater(Queue<Command> queueCommand) {
		while(queueCommand.peek() != null) {
			queueCommand.poll().operation();
		}
	}
	public static void main(String[] args) {
		Build build = new Build();
		commandEater(build.makeQueue());	
	}
}
