package chapter6practices;

public class SecondClass {

	FirstClass firstClass;

	public SecondClass() {
		firstClass = new FirstClass();
		System.out.println(firstClass + " has been created inside " + this);
	}

	public String toString() {
		return "SecondClass";
	}
}