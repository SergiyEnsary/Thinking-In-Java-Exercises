package chapter9practices;

/* Create a class with a private field and a private method. Create an
 * inner class with a method that modifies the outer-class field and calls
 * the outer class method. In a second outer-class method, create an object
 * of the inner class and call its method, then show the effect on the
 * outer-class object. 
 */

class PrivateField {
	private int pF = 1;
	private void hi() { System.out.println("Outer hi"); }

	class Inner {
		void modifyOuter() { 
			pF *= 2;
			hi(); 
		}
	}

	public void showPF() { System.out.println(pF); }

	void testInner() {
		Inner in = new Inner();
		in.modifyOuter();
	}
}

public class Chapter9Exercise07{
	public void main(String[] args) {
		PrivateField out = new PrivateField();
		out.showPF();
		out.testInner();
		out.showPF();
	}
}

