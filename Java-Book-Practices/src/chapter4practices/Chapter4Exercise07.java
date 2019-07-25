package chapter4practices;
/*	Chapter 4
 * Exercise 7:  (1) Create a class without a constructor, and then create an object of that class in main( ) to
 *      verify that the default constructor is automatically synthesized.
 */
public class Chapter4Exercise07 {
	public static void main(String[] args) {
		class DefaultConstTest{
		}
		DefaultConstTest test = new DefaultConstTest();
	}
}
