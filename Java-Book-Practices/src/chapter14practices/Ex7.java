package chapter14practices;

//Use composition instead of inheritance to adapt Fibonacci
//to make it interable.
import java.util.*;

import chapter13practices.Generator;

public class Ex7 implements Generator<Integer>, Iterable<Integer> {
	private int count = 0;
	private int m;
	public Integer next() { return fib(count++); }
	private int fib(int n) {
		if(n < 2) return 1;
		return fib(n - 2) + fib(n - 1);
	}
	public Ex7() {}
	public Ex7(int m) { this.m = m; }
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() { return m > 0; }
			public Integer next() {
				m--;
				return Ex7.this.next();
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		Ex7 gen = new Ex7();
		for(int i = 0; i < 18; i++)
			System.out.print(gen.next() + " ");
		System.out.println();
		Iterator it = new Ex7(20).iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
}

/*Output:

1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 

 */