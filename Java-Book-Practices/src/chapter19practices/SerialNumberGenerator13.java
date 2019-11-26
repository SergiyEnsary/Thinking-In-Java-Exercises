package chapter19practices;

public class SerialNumberGenerator13 {	
	private static volatile int serialNumber = 0;
	public static synchronized int nextSerialNumber() {
		return serialNumber++;
	}	
 }