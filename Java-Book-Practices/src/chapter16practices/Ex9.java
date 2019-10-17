package chapter16practices;

//Use RandomGenerator.String to fill a TreeSet, but use alphabetic 
//ordering. Print the TreeSet to verify the sort order.
import java.util.*;

import chapter15practices.RandomGenerator;

public class Ex9 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		RandomGenerator.String rgs = new RandomGenerator.String(5);
		for(int i = 0; i < 20; i++) {
			ts.add(rgs.next());
		}
		System.out.print(ts);
	}
}

/*Output:

[bkIna, cQrGs, dLsmw, eGZMm, EqUCB, gwsqP, hKcxr, HLGEa, HxxHv, JMRoE, Mesbt, nyGcF, OneOE, OWZnT, RFJQA, rUkZP, suEcU, WHkjU, YNzbr, zDyCy]

*/