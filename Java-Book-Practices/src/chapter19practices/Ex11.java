package chapter19practices;

/** Create a class containing two data fields, and a method that manipulates
* those fields in a multistep process so that, during the execution of that 
* method, those fields are in an "improper state" (according to some definition
* that you establish). Add methods to read the fields, and create multiple 
* threads to call the various methods and show that the data is visible in its 
* "improper state." Fix the problem using the synchronized keyword.
**/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassB implements Runnable {
	private String fieldA;
	private String fieldB;
	public synchronized void manipulateFields() {
		for(int i = 0; i < 1000; i++) {
			fieldA = "incorrectA !!!!!!!!!!";
			fieldB = "incorrectB !!!!!!!!!!";
		}
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public MyClassB() {
		fieldA = "correctA";
		fieldB = "correctB";
	}
	public synchronized String getA() {
		return fieldA;
	}
	public synchronized String getB() {
		return fieldB;
	}
	public void run() {
		manipulateFields();
		System.out.println("fieldA: " + getA());
		System.out.println("fieldB: " + getB());
	}
	
}


public class Ex11 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		MyClassB obj = new MyClassB();
		for(int i = 0; i < 10000; i++) {
			exec.execute(obj);
		}
		exec.shutdown();
	}

}

/*Output(Shortened):
...
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldB: correctB
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldB: correctB
fieldA: correctA
fieldB: correctB
fieldB: correctB
fieldB: correctB
*/