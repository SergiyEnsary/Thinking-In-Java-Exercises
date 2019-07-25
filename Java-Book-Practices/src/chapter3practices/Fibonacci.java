package chapter3practices;

public class Fibonacci {
	int i;
	int k;
	int j;

	public Fibonacci() {
		i = 0;
		k = 1;
	}
	public void printFib(int num) {
		System.out.println(k);
		for (int l = 1; l < num; l++) {
			System.out.println(j = i + k);
			i = k;
			k = j;
		}
	}
}
