package chapter19practices;

//Repeat Exercise 2 using the different types of executors shown in this section.

import java.util.concurrent.*;

class Ex4FibonacciA implements Runnable {
	private int n = 0;
	public Ex4FibonacciA(int n) {
		this.n = n;
	}
	private int fib(int x) {
		if(x < 2) return 1;
		return fib(x - 2) + fib(x - 1);
	}
	public void run() {
		for(int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");
			System.out.println();		
	}
}

class Ex4FibonacciB implements Runnable {
	private int n = 0;
	public Ex4FibonacciB(int n) {
		this.n = n;
	}
	private int fib(int x) {
		if(x < 2) return 1;
		return fib(x - 2) + fib(x - 1);
	}
	public void run() {
		for(int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");
			System.out.println();		
	}
}

class Ex4FibonacciC implements Runnable {
	private int n = 0;
	public Ex4FibonacciC(int n) {
		this.n = n;
	}
	private int fib(int x) {
		if(x < 2) return 1;
		return fib(x - 2) + fib(x - 1);
	}
	public void run() {
		for(int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");	
			System.out.println();	
	}
}

class Ex4FibonacciD implements Runnable {
	private int n = 0;
	public Ex4FibonacciD(int n) {
		this.n = n;
	}
	private int fib(int x) {
		if(x < 2) return 1;
		return fib(x - 2) + fib(x - 1);
	}
	public void run() {
		for(int i = 0; i < n; i++)
			System.out.print(fib(i) + " ");	
			System.out.println();	
	}
}

public class Ex4 {
	public static void main(String[] args) {
		ExecutorService exec1 = Executors.newCachedThreadPool();
		exec1.execute(new Ex4FibonacciA(15));		
		exec1.execute(new Ex4FibonacciB(15));		
		exec1.execute(new Ex4FibonacciC(15));
		exec1.execute(new Ex4FibonacciD(15));
		exec1.shutdown();		
		ExecutorService exec2 = Executors.newFixedThreadPool(4);
		exec2.execute(new Ex4FibonacciA(15));		
		exec2.execute(new Ex4FibonacciB(15));		
		exec2.execute(new Ex4FibonacciC(15));
		exec2.execute(new Ex4FibonacciD(15));
		exec2.shutdown();
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		exec3.execute(new Ex4FibonacciA(15));		
		exec3.execute(new Ex4FibonacciB(15));		
		exec3.execute(new Ex4FibonacciC(15));
		exec3.execute(new Ex4FibonacciD(15));
		exec3.shutdown();	
	}
}

/*Output:

1 1 2 3 5 8 13 1 21 1 34 2 55 3 89 5 8 144 13 21 233 34 55 377 89 1 1 610 2 144 3 
5 233 8 377 13 610 21 
34 55 89 144 233 377 610 
1 1 2 3 5 8 13 21 34 55 89 144 1 1 2 233 3 5 8 13 377 21 34 610 55 
89 144 1 1 1 2 1 233 1 3 1 5 2 3 5 8 1 2 1 377 2 3 610 
13 8 21 5 8 13 21 34 55 89 144 233 377 610 
3 5 8 13 21 34 55 89 144 233 377 610 
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 
34 55 89 13 144 21 34 55 89 233 144 377 233 610 
377 610 

*/