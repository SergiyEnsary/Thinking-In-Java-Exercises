package chapter13practices;

/* Implement a rotate(Shape) method in Shapes.java, such that it checks
* to see if it is rotating a Circle (and, if so, doesn't perform the
* operation).
*/
import java.util.*;

abstract class Shape5 {
	void draw() { System.out.println(this + ".draw()"); }
	abstract public String toString();
}

class Circle5 extends Shape5 {
	public String toString() { return "Circle"; }
}

class Square5 extends Shape5 {
	public String toString() { return "Square"; }
}

class Triangle5 extends Shape5 {
	public String toString() { return "Triangle"; }
}

class Rhomboid5 extends Shape5 {
	public String toString() { return "Rhomboid"; }
}

public class Ex5 {
	public static void rotate(Shape5 s) {
			if(!(s instanceof Circle5))
				System.out.println(s + " rotate");
		}			
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape5> shapeList = Arrays.asList(
			new Circle5(), new Square5(), new Triangle5(), new Rhomboid5()
		);
		// downcasting back to specific shape:
		for(Shape5 shape : shapeList)
			shape.draw();	
		System.out.println();	
		for(Shape5 shape : shapeList)
			rotate(shape);
	}
}

/*Output:

Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()

Square rotate
Triangle rotate
Rhomboid rotate

*/