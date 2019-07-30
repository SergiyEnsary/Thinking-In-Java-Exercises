package chapter7practices;

public class Triangle extends Shape {
	@Override
	public void draw() {
		System.out.println("Triangle.draw()");
	}
	@Override
	public void erase() {
		System.out.println("Triangle.erase()");
	}
	@Override
	public String toString() {
		return "Triangle";
	}
}