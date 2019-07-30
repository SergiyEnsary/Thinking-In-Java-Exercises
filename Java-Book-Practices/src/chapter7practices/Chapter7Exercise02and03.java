package chapter7practices;

/*	Chapter 7
 * 	Exercise 2:  (1) Add the @Override annotation to the shapes example.
 *
 *  Exercise 3:  (1) Add a new method in the base class of Shapes.java that prints a message, but do not
 *          override it in the derived classes. Explain what happens. Now override it in one of the derived
 *          classes but not the others, and see what happens. Finally, override it in all the derived classes.
 */
public class Chapter7Exercise02and03 {
	public static void main(String[] args) {
		Shape[] s = new Shape[9];

		for(int i = 0; i < s.length; i++) {
			s[i] = Shapes.gen.next();
			System.out.println(s[i]);
		}

		for(Shape shp : s) {
			shp.draw();
		}
	}
}
