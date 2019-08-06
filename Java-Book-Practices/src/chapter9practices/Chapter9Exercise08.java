package chapter9practices;

/* Determine whether an outer class has access to the private elements of 
 * its inner class. 
 */

class Outer8 {	
	class Inner {
		private int pi1 = 1;
		private int pi2 = 2;
		private void showIi2() { System.out.println(pi2); }
		private void hi() { System.out.println("Inner hi"); }
	}
	int outerinner = new Inner().pi1;
	void showOi() { System.out.println(outerinner); }
	void showIi2() { new Inner().showIi2(); } 
	void outerHi() { new Inner().hi(); }
}

public class Chapter9Exercise08{
	public static void main(String[] args) {
		Outer8 out = new Outer8();
		out.showOi();
		out.showIi2();
		out.outerHi();
	}
}
