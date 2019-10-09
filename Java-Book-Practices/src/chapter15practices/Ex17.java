package chapter15practices;

//Create and test a Generator for BigDecimal, and ensure 
//that it works with the Generated methods.
import java.math.*;
import java.util.*;

import chapter13practices.Generator;

class BigDecimalGenerator implements Generator<BigDecimal> {
	private BigDecimal bd = new BigDecimal(0.0);
	public BigDecimal next() {
		return bd = bd.add(new BigDecimal(1.0));
	}
}

public class Ex17 {
	public static void main(String[] args) {
		BigDecimal[] bda1 = new BigDecimal[4];
		Generated.array(bda1, new BigDecimalGenerator());
		System.out.println(Arrays.toString(bda1));
		BigDecimal[] bda2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 5);
		System.out.println(Arrays.toString(bda2));
	}
}

/*Output:

[1, 2, 3, 4]
[1, 2, 3, 4, 5]

 */