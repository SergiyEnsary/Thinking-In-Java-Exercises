package chapter4practices;

/*	Chapter 4
 * Exercise 21:    (1) Create an enum of the least-valuable six types of paper currency. Loop through the
 *      values( ) and print each value and its ordinal( ).
 */

public class Chapter4Exercise21 {
	public enum Money {
		ONE_DOLLAR, TWO_DOLLAR, FIVE_DOLLAR, TEN_DOLLAR, TWENTY_DOLLAR, FIFTY_DOLLAR;

		public static void choose(Money money) {
			switch (money) {
			case ONE_DOLLAR:
				System.out.println("One Dollar");
				break;
			case TWO_DOLLAR:
				System.out.println("Two Dollars");
				break;
			case FIVE_DOLLAR:
				System.out.println("Five Dollars");
				break;
			case TEN_DOLLAR:
				System.out.println("Ten Dollars");
				break;
			case TWENTY_DOLLAR:
				System.out.println("Twenty Dollars");
				break;
			case FIFTY_DOLLAR:
				System.out.println("Fifty Dollars");
			}
		}
	}
	public static void main(String[] args) {

		for (Money s : Money.values()) {
			System.out.println(s + ", ordinal " + s.ordinal());
		}
		/*
		 * Exercise 22:   (2) Write a switch statement for the enum in the previous example. For each case, output a
		 *      description of that particular currency.
		 */
		for (Money m : Money.values()) {
			Money.choose(m);
		}
	}
}
