package chapter12practices;

/* Analyze SprinklerSystem.toString() in reusing/SprinklerSystem.java to discover
 * whether writing the toString() with an explicit StringBuilder will save any
 * StringBuilder creations.
 */

class WaterSource {
	private String s;
	WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}
	public String toString() { return s; }
}

public class SprinklerSystem1 {
	private String valve1, valve2, valve3, valve4;	
	private WaterSource source = new WaterSource();
	private int i;
	private float f;
	// appears to create only one StringBuilder
	public String toString() {
		return
				"valve1 = " + valve1 + " " + 
				"valve2 = " + valve2 + " " +
				"valve3 = " + valve3 + " " +
				"valve4 = " + valve4 + " " +
				"i = " + i + " " + "f = " + f + " " + "\n" +
				"source = " + source;
	}
	public static void main(String[] args) {
		SprinklerSystem1 sprinklers = new SprinklerSystem1();
		System.out.println(sprinklers);
	}
}
/*
 *Output:
 *WaterSource()
 *valve1 = null valve2 = null valve3 = null valve4 = null i = 0 f = 0.0 
 *source = Constructed
 */