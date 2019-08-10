package chapter10practices;

import java.util.*;
import chapter7practices.*;
/* Modify polymorphism/shape/RandomShapeGenerator.java to make it
* Iterable. You'll need to add a constructor that takes the number of
* elements that you want the iterator to produce before stopping. Verify
* that it works.
*/

public class Ex30 implements Iterable<Shape> {
	private Random random = new Random();
	
	public Shape make() {		
		switch(random.nextInt(3)) {
			default:
			case 0: return new Circle();
			case 1: return new Square();
			case 2: return new Triangle();
		}
	}
	
	private Shape[] shapes;
	
	Ex30(int newShape) {
		shapes = new Shape[newShape];
		for(int index = 0; index < newShape; index++)
			shapes[index] = make();
	}
	
	public Iterator<Shape> iterator() {
	
		return new Iterator<Shape>() {
			private int index = 0;
			public boolean hasNext() {
				return index < shapes.length;
			}
			public Shape next() {
				return shapes[index++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}			
		};
	}
	
	public static void main(String[] args) {
		Ex30 ex30 = new Ex30(20);
		for(Shape shape : ex30)
			System.out.println(shape);
	}
}
