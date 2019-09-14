package chapter14practices;

//Remove all generics from MultipleInterfaceVariants.java and modify
//the code so that the example compiles.

interface Payable { float getPay(); }

class Employee implements Payable {
	private float weeklyPay;
	public float getPay() {
		return weeklyPay;
	}		
} 

class Hourly extends Employee {
	public String name;
	protected float hourlyPay;
	public int hoursWorked;
	
	Hourly(String name, float pay, int hours) {
		this.name = name;
		this.hourlyPay = pay;
		this.hoursWorked = hours;
	}
	public float getPay() {
		System.out.println("Pay " + this.name + 
			" $" + this.hourlyPay * this.hoursWorked);
		return (this.hourlyPay * this.hoursWorked);	
	}
}

public class Ex31 {
	public static void main(String[] args) {
		Hourly hours = new Hourly("Joe", 50.00f, 40);
		hours.getPay();
	}
}

/*Output:

Pay Joe $2000.0

 */