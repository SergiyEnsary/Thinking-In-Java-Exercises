package chapter6practices;
/* Chapter 6
 * Exercise 19:    (2) Create a class with a blank final reference to an object. Perform the initialization of
 *      the blank final inside all constructors. Demonstrate the guarantee that the final must be initialized
 *      before use, and that it cannot be changed once initialized.
 *      
 * Exercise 20:   (1) Show that the @Override annotation solves the problem in this section.
 */
public class Chapter6Exercise19and20 {
	public static void main(String[] args) {
		Frog frog = new Frog();
		BlankFinal blankFinal = new BlankFinal(frog);
		OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
	}
}
