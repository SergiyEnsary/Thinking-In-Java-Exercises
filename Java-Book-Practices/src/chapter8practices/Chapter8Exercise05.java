package chapter8practices;

public class Chapter8Exercise05 implements Ex5 {
	public void sayOne() { System.out.println("one"); }
	public void sayTwo() { System.out.println("two"); }
	public void sayThree() { System.out.println("three"); }
	public static void main(String[] args) {
		Chapter8Exercise05 x = new Chapter8Exercise05();
		x.sayOne();
		x.sayTwo();
		x.sayThree();
	}
}