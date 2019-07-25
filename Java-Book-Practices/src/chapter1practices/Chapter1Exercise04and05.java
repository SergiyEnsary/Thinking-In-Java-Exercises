package chapter1practices;

/*
 * Exercise 4:  (1) Turn the DataOnly code fragments into a program that compiles and runs.
 *
 * Exercise 5:  (1) Modify the previous exercise so that the values of the data in DataOnly are assigned to and
 *      printed in main( ).
 *
 */
public class Chapter1Exercise04and05{
	
	public static void main(String[] args) {
		class DataOnly {
		    int i;
		    double d;
		    boolean b;
		}
		//compiles and runs
		DataOnly data = new DataOnly();
		
		//assigned and printed
		data.i = 47;
		data.d = 1.1;
		data.b = false;

		System.out.println(data.i);
		System.out.println(data.d);
		System.out.println(data.b);
	}
}