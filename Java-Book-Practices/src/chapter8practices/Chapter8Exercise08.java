package chapter8practices;
/* Create an interface called FastFood (with
 * appropriate methods) and change Sandwich so that it also implements
 * FastFood.
 */
public class Chapter8Exercise08 extends PortableLunch implements FastFood {
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lunch l = new Lunch();
	public Chapter8Exercise08() { System.out.println("Sandwich8()"); }
	public void cheeseburger() {
		System.out.println("Cheeseburger");
	}
	public void fries() {
		System.out.println("Fries");
	}
	public void softDrink(){
		System.out.println("Soft Drink");
	}
	public static void main(String[] args) {
		Chapter8Exercise08 s = new Chapter8Exercise08();
		s.cheeseburger();
		s.fries();
		s.softDrink();
		
	} 
}
