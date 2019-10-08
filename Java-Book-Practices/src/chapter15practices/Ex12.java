package chapter15practices;

//Create an initialized array of double using CountingGenerator.
//Print the results.
import java.util.*;

public class Ex12 {
	public static void main(String[] args) {
		double[] da = new double[10];
		CountingGenerator.Double dGen = new CountingGenerator.Double();
		for(int i = 0; i < da.length; i++)
			da[i] = dGen.next();
		System.out.println(Arrays.toString(da));	
	}
}

/*Output:

[0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]

 */