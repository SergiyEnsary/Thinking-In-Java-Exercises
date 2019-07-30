package chapter6practices;
/*	Chapter 6
 * 	Exercise 2: (2) Inherit a new class from class Detergent. Override scrub()
 * 				and add a new method called sterilize()
 * 	Exercise 11: (3) Modify Detergent.java so that it uses delegation.
 */
public class Chapter6Exercise02and11 {
	public static void main(String[] args) {
		Tide tide = new Tide();
        tide.dilute();
        tide.apply();
        tide.scrub();
        tide.foam();
        tide.sterilize();
        System.out.println(tide);
	}
}
