package chapter18practices;

//Use a static import to modify TrafficLight.java so you 
//don't have to qualify the enum instances.

import static chapter18practices.Signal.*;

public class Ex1 {
	Signal color = RED;
	public void change() {
		switch(color) {
		case RED:	
			color = GREEN;
			break;
		case GREEN:
			color = YELLOW;
			break;
		case YELLOW:	
			color = RED;
			break;			
		}
	}
	public String toString() {
		return "The traffic light is " + color;
	}
	public static void main(String[] args) {
		Ex1 t = new Ex1();
		for(int i = 0; i < 7; i++) {
			System.out.println(t);
			t.change();
		}		
	}
}

/*Output:

The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED

 */