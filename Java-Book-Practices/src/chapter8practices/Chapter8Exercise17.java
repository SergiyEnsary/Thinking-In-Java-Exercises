package chapter8practices;

interface Days {
	int SUNDAY = 1, MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, 
		THURSDAY = 5, FRIDAY = 6, SATURDAY = 7; 
}

class Week implements Days {
	private static int count = 0;
	private int id = count++;
	public Week() { System.out.println("Week() " + id); }
}

public class Chapter8Exercise17 {
	public static void main(String[] args) {
		System.out.println("SUNDAY = " + Days.SUNDAY);
		System.out.println("MONDAY = " + Days.MONDAY);
		System.out.println("Tuesday = " + Days.TUESDAY);
		System.out.println("Wednesday = " + Days.WEDNESDAY);
		System.out.println("Thursday = " + Days.THURSDAY);
		System.out.println("Friday = " + Days.FRIDAY);
		System.out.println("Saturday = " + Days.SATURDAY);
		Week w0 = new Week();
		Week w1 = new Week();
		Week w2 = new Week();
		Week w3 = new Week();
	}
}
