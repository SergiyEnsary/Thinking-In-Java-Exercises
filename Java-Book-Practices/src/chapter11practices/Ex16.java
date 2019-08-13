package chapter11practices;

//Modify reusing/CADSystem.java to demonstrate that returning from the 
//middle of a try-finally will still perform proper cleanup.

class Shape {
	Shape(int i) { 
		System.out.println("Shape constructor"); 
	}
	void dispose() { 
		System.out.println("Shape dispose"); 
	}		
}

class Circle extends Shape {
	
	Circle(int i) {
		super(i);
		System.out.println("Drawing Circle");
	}
	
	void Dispose() {
		System.out.println("Erasing circle");
		super.dispose();
	}
}

class Triangle extends Shape {
	
	Triangle(int i) {
		super(i);
		System.out.println("Drawing Triangle");
	}	
	
	void dipsose() { 
		System.out.println("Erasing Triangle"); 
		super.dispose();	
	}
}

class Line extends Shape {
	private int start, end;
	
	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Drawing Line: " + start + ", " + end); 
	}
	
	void dispose() {
		System.out.println("Erasing Line: " + start + ", " + end);
		super.dispose();
	}
}

public class Ex16 extends Shape {
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	
	public Ex16(int i) {
		super(i + 1);
		for(int index = 0; index < lines.length; index++) {
			lines[index] = new Line(index, index*index);
		}
		c = new Circle(1);
		t = new Triangle(1);
		System.out.println("Combined constructor");
	}
	
	public void dispose() {
		System.out.println("CADSystem.dispose()");
		t.dispose();
		c.dispose();
		for(int index = lines.length - 1; index >= 0; index--) {
			lines[index].dispose();
		}
		super.dispose();
	}
	
	public static void main(String[] args) {
		Ex16 ex16 = new Ex16(47);
		try {
			System.out.println("Returning from try block");
			return;
		} finally {
			ex16.dispose();
		} 
	}	
}