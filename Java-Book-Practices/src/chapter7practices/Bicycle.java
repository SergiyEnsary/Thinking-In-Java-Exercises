package chapter7practices;

public class Bicycle extends Cycle{
	public String toString() {
		return "Bicycle";
	}

	public int wheels() {
		return 2;
	}

	public void balance() {
		System.out.println("Balancing on " + this);
	}
}
