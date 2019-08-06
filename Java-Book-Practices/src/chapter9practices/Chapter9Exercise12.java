package chapter9practices;

/* Repeat Exercise 7 using an anonymous inner class.
 * (Exercise 7: Create a class with a private field and a private method. 
 * Create an inner class with a method that modifies the outer-class field 
 * and calls the outer class method.In a second outer-class method, create
 * an object of the inner class and call its method, then show the effect on
 * the outer-class object.) 
 */

interface Inner12 {
	void modifyOuter();
}

public class Chapter9Exercise12 {
	private int outerField = 1;
	private void hi() { System.out.println("Outer says hi"); }
	public Inner12 inner() {
		return new Inner12() {
			public void modifyOuter() { 
				outerField *= 2;
				hi(); 
			}
		}; 
	}
	public void showOi() { System.out.println(outerField); }
	public static void main(String[] args) {
		Chapter9Exercise12 output = new Chapter9Exercise12();
		output.showOi();
		output.inner().modifyOuter();
		output.showOi();
	}
}
