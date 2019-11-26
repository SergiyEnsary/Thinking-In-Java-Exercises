package chapter19practices;

/** Modify Exercise 5 following the example of the ThreadMethod class,
* so that runTask() takes an argument of the number of Fibonacci 
* numbers to sum, and each time you call runTask() it returns the 
* Future produced by the call to submit().
**/

import java.util.concurrent.*;
import java.util.*;

class Ex10Fibonacci implements Callable<Integer> {
	private Integer n = 0;
	ExecutorService exec = Executors.newSingleThreadExecutor();
	private int fib(int x) {
		if(x < 2) return 1;
		return fib(x - 2) + fib(x - 1);
	}	
	public Integer call() {
		int result = 0;
		for(int i = 0; i < n; i++) 
			result += fib(i);		
		return (Integer)result;
	}
	public Future<Integer> runTask(Integer n) {
		this.n = n;	
		return exec.submit(this);		
	}
}

public class Ex10 {
	public static void main(String[] args) {		
		Ex10Fibonacci fib = new Ex10Fibonacci();
		try {
			for(int i = 0; i < 15; i++) {
				System.out.print("Sum of first " + i + " Fibonacci numbers = ");
				System.out.println(fib.runTask(i).get());

			}			
		} catch(InterruptedException e) {
			System.out.println(e);
			return;
		} catch(ExecutionException e) {
			System.out.println(e);	
		} finally {
			fib.exec.shutdown();
		}			
	}
}

/*Output:

Sum of first 0 Fibonacci numbers = 0
Sum of first 1 Fibonacci numbers = 1
Sum of first 2 Fibonacci numbers = 2
Sum of first 3 Fibonacci numbers = 4
Sum of first 4 Fibonacci numbers = 7
Sum of first 5 Fibonacci numbers = 12
Sum of first 6 Fibonacci numbers = 20
Sum of first 7 Fibonacci numbers = 33
Sum of first 8 Fibonacci numbers = 54
Sum of first 9 Fibonacci numbers = 88
Sum of first 10 Fibonacci numbers = 143
Sum of first 11 Fibonacci numbers = 232
Sum of first 12 Fibonacci numbers = 376
Sum of first 13 Fibonacci numbers = 609
Sum of first 14 Fibonacci numbers = 986

*/