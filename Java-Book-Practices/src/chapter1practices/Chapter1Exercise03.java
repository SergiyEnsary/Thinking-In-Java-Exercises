package chapter1practices;
/*	Chapter 1
 *  Exercise 3: (1) Find the code fragments involving ATypeName and turn them into a
 *	program that compiles and runs.
 */
public class Chapter1Exercise03 {
	public static void main(String[] args) {
		class ATypeName { 
			private String newType = "Class within a class"; 
			public String getNewType() {
				return this.newType;
			}
		}
		ATypeName a = new ATypeName();
		System.out.println(a.getNewType());
	}
}