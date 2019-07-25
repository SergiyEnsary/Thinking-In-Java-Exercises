package chapter4practices;
/*
 * Exercise 20:   (1) Create a main( ) that uses varargs instead of the ordinary main( ) syntax. Print all the
 *      elements in the resulting args array. Test it with various numbers of command-line arguments.
 */
public class Chapter4Exercise20 {
public static void main(String [] args) {
	for (String string : args) {
        System.out.println(string);
    }
}
}
