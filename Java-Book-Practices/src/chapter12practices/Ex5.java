package chapter12practices;

/* For each of the basic conversion types in the above table, write the 
* most complex formatting expression possible. That is, use all the possible
* format specifiers available for that conversion type.
*/
import java.math.*;
import java.util.*;

public class Ex5 {
	public static void main(String[] args) {
		Formatter formatter = new Formatter(System.out);

		char a = 'a';
		System.out.println("char u = \'a\'");
		formatter.format("%-2s%-2S%-2c%-2C%-5b%-5B%-3h%-3H%%\n", a,a,a,a,a,a,a,a);
		
		int b = 121;
		System.out.println("int v = 121");
		formatter.format("%-4s%-4S%-4d%-4c%-4C%-5b%-5B%-4x%-4X%-4h%-4H%%\n", b,b,b,b,b,b,b,b,b,b,b);
		
		BigInteger w = new BigInteger("50000000000000");
		System.out.println("BigInteger w = 50000000000000");
		formatter.format("%-15s%-15S%-5b%-5B%-15x%-15X%-5h%-5H%%\n", w,w,w,w,w,w,w,w); 

		double x = 179.543;
		System.out.println("double x = 179.543");
		formatter.format("%-8s%-8S%-5b%-5B%-15f%-15e%-15E%-12h%-12H%%\n", x,x,x,x,x,x,x,x,x);
		
		Conversion y = new Conversion();
		System.out.println("Conversion y = new Conversion()");
		formatter.format("%-20s%-20S%-5b%-5B%-10h%-10H%%\n", y,y,y,y,y,y);

		boolean z = false;
		System.out.println("boolean z = false");
		formatter.format("%-7s%-7S%-7b%-7B%-7h%-7H%%\n", z,z,z,z,z,z);
	}
}
/*Output:

char u = 'a'
a A a A true TRUE 61 61 %
int v = 121
121 121 121 y   Y   true TRUE 79  79  79  79  %
BigInteger w = 50000000000000
50000000000000 50000000000000 true TRUE 2d79883d2000   2D79883D2000   8842a1a78842A1A7%
double x = 179.543
179.543 179.543 true TRUE 179.543000     1.795430e+02   1.795430E+02   1ef462c     1EF462C     %
Conversion y = new Conversion()
chapter12practices.Conversion@28a418fcCHAPTER12PRACTICES.CONVERSION@28A418FCtrue TRUE 28a418fc  28A418FC  %
boolean z = false
false  FALSE  false  FALSE  4d5    4D5    %
 
 */
