package chapter11practices;

public class Switch {
	private boolean state = false;
	public boolean read() { 
		return state; 
	}
	public void on() { 
		state = true; 
		System.out.print(this); 
	}
	public void off() { 
		state = false; 
		System.out.print(this); 
	}
	public String toString() { 
		return state ? "on" : "off"; 
	}
}