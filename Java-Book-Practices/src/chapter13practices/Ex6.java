package chapter13practices;

/* Modify Shapes.java so that it can "highlight" (set a flag in)
* all shapes of a particular type.  The toString() method for each 
* derived Shape should indicate whether that Shape is "highlighted."
*/
import java.util.*;

abstract class Shape6 {
	void draw() { System.out.println(this + ".draw()"); }
	abstract public String toString();
}

class Circle6 extends Shape6 {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Circle"; 
	}
}

class Square6 extends Shape6 {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Square"; 
	}
}

class Triangle6 extends Shape6 {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Triangle"; 
	}
}
class Rhomboid6 extends Shape6 {
	boolean flag = false;
	public String toString() {
		return (flag ? "H" : "Unh") + "ighlighted " + "Rhomboid"; 
		}
}


public class Ex6 {
	public static void setFlag(Shape6 s) {
			if(s instanceof Triangle6)
				((Triangle6)s).flag = true; 
		}			
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape6> shapeList = Arrays.asList(new Circle6(), new Square6(), new Triangle6(), new Rhomboid6());
		for(Shape6 shape : shapeList) {
			setFlag(shape);
			System.out.println(shape);
		}
	}
}

/*Output:

Unhighlighted Circle
Unhighlighted Square
Highlighted Triangle
Unhighlighted Rhomboid

 */