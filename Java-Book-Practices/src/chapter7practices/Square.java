package chapter7practices;

public class Square extends Shape {
	@Override
	public void draw() {
		System.out.println("Square.draw()");
	}
	@Override
	public void erase() {
		System.out.println("Square.erase()");
	}

	@Override
	public String toString() {
		return "Square";
	}
}