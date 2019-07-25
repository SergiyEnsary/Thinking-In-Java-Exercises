package chapter4practices;
/*	Chapter 4
 * Exercise 19:    (2) Write a method that takes a vararg String array. Verify that you can pass either a
 *      comma-separated list of Strings or a String[] into this method.
 */
public class Chapter4Exercise19 {
	public static void main(String [] args) {
		class VarArgs {
		    public void printVarargs(String[] strings) {
		        for (int i =0; i<strings.length;i++) {
		            System.out.println(strings[i]);
		        }
		    }
		}
		
		VarArgs varArgs = new VarArgs();
		varArgs.printVarargs(new String[]{"One","Two","Three"});
		
		String[] strings1 = new String[]{"Four","Five","Six"};
		varArgs.printVarargs(strings1);
	}
}
