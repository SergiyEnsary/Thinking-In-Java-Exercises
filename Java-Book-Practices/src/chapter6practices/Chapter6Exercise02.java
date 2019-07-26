package chapter6practices;
/*	Chapter 6
 * 	Exercise 2: (2) Inherit a new class from class Detergent. Override scrub()
 * 				and add a new method called sterilize()
 */
public class Chapter6Exercise02 {
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
