package chapter3practices;

/*Chapter 3
 * Exercise 10:    (5) A vampire number has an even number of digits and is formed by multiplying a pair of numbers
 *	containing half the number of digits of the result. The digits are taken from the original number in any order.
 *	Pairs of trailing zeroes are not allowed. Examples include:
 *	1260 = 21 * 60
 *	1827 = 21 * 87
 *	2187 = 27 * 81
 *	Write a program that finds all the 4-digit vampire numbers. (Suggested by Dan Forhan.)
 */
public class Chapter3Exercise10 {
	public static void main(String args[]){
		int w, x, y , z; 
		for(int i=1000; i<10000; i++) {
			w = i/1000;
			x = (i%1000)/100;
			y = ((i%100)%100)/10;
			z = ((i%1000)%100)%10;
			if(areFangs(w,x,y,z,i)) {
				System.out.println(i+" is a vampire number");
			}
		}
	}
	//all fang compositions
	public static boolean areFangs(int w, int x, int y, int z, int num) {
		if(calc(w,x,y,z)==num) {return true;}
		if(calc(x,w,y,z)==num) {return true;}
		if(calc(w,x,z,y)==num) {return true;}
		if(calc(x,w,z,y)==num) {return true;}
		
		if(calc(w,y,x,z)==num) {return true;}
		if(calc(y,w,x,z)==num) {return true;}
		if(calc(w,y,z,x)==num) {return true;}
		if(calc(y,w,z,x)==num) {return true;}
		
		if(calc(w,z,x,y)==num) {return true;}
		if(calc(z,w,x,y)==num) {return true;}
		if(calc(w,z,y,x)==num) {return true;}
		if(calc(z,w,y,x)==num) {return true;}
		return false;
	}
	//calculates the fangs
	public static int calc(int w, int x, int y, int z) {
		return ((w*10)+x)*((y*10)+z);
	}
}