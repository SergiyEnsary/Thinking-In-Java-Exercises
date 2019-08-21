package chapter13practices;

/* Modify the previous exercise so that it uses instancof to check the
 * type before performing the downcast.
 */
import java.util.*;

abstract class Shape4 {
	void draw() { System.out.println(this + ".draw()"); }
	abstract public String toString();
}

class Circle4 extends Shape4 {
	public String toString() { return "Circle"; }
}

class Square4 extends Shape4 {
	public String toString() { return "Square"; }
}

class Triangle4 extends Shape4 {
	public String toString() { return "Triangle"; }
}

class Rhomboid4 extends Shape4 {
	public String toString() { return "Rhomboid"; }
}

public class Ex4 {
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape4> shapeList = Arrays.asList(new Circle4(), new Square4(), new Triangle4(), new Rhomboid4());
		// downcasting back to specific shape:
		for(Shape4 shape : shapeList)
			shape.draw();
		Rhomboid4 r = new Rhomboid4();
		// Upcast:
		Shape4 s = (Shape4)r;
		s.draw();
		// check type before downcast:
		if(s instanceof Circle4) {
			((Circle4)s).draw();
		}
		else if(!(s instanceof Circle4)) {
			System.out.println(s +" is not a Circle");		
		}
	}
}

/*Output:

Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()
Rhomboid.draw()
Rhomboid is not a Circle

*/