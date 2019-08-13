package chapter11practices;

//Show that WithFinally.java doesn't fail by throwing a 
//RuntimeException inside the try block.

public class Ex15 {
	private static Switch sw = new Switch();
	private static Integer[] x = new Integer[1];
	public static void f(int i) 
	throws OnOffException1, OnOffException2 {}
	public static void main(String[] args) {
		try {
			sw.on();
			f(x[0]);
		} catch(OnOffException1 e) {
			System.out.println("OnOffException1");
		} catch(OnOffException2 e) {
			System.out.println("OnOffException2");
		} finally {
			sw.off();
		} 
	}		
} 