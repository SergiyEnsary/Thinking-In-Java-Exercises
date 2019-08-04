package chapter8practices;
  
//Prove that all the methods in an interface are automatically public
  class Ex6b implements Ex6 {
 	public void sayOne() { System.out.println("one"); }
 	public void sayTwo() { System.out.println("two"); }
 	public void sayThree() { System.out.println("three"); }
  } 

public class Chapter8Exercise06 {	
	public static void main(String[] args) {
		Ex6b x = new Ex6b();
		x.sayOne();
		x.sayTwo();
		x.sayThree();
	}
}