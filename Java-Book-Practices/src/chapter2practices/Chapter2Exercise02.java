package chapter2practices;
/* Chapter 2
 * Exercise 2:  (1) Create a class containing a float and use it to demonstrate aliasing.
 */
public class Chapter2Exercise02 {
	public static void main(String[] args) {
		class Alias {
		    float t;
		    Alias(float t) {
		        this.t = t;
		    }
		}
		Alias alias = new Alias(3);
        Alias alias1 = new Alias(4);

        System.out.println("1: alias: " + alias.t + ", alias1: " + alias1.t);
        alias = alias1;
        System.out.println("2: alias: " + alias.t + ", alias1: " + alias1.t);
        alias.t = 9;
        System.out.println("3: alias: " + alias.t + ", alias1: " + alias1.t);
	}
}
