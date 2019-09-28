package chapter15practices;

//Repeat the previous exercise for a three-dimensional array.
import java.util.*;

public class Ex4 {
	static double[][][] create3Array(int size1, int size2, int size3, 
			double start, double end) {
		if(!(start < end)) {
			System.out.println("Start must be less than end");
			return null;
		}
		if((size1 < 1) || (size2 < 1) || (size3 < 1)) {
			System.out.println("Size must be > 0");
			return null;
		}
		double[][][] result = new double[size1][size2][size3];
		for(int i = 0; i < size1; i++) 
			result[i] = Ex3.createArray(size2, size3, start, end);
		return result;
	} 
	static void print3Array(double[][][] da) {
		System.out.println(Arrays.deepToString(da));
	}
	public static void main(String[] args) {
		print3Array(create3Array(0,2,3,4,5));
		print3Array(create3Array(2,3,3,5,4));
		print3Array(create3Array(1,2,2,5,10));
		print3Array(create3Array(2,2,3,5,10));
		print3Array(create3Array(3,3,3,5,10));
		print3Array(create3Array(3,5,5,10,20));
	}
}

/*Output:

Size must be > 0
null
Start must be less than end
null
[[[5.0, 10.0], [5.0, 10.0]]]
[[[5.0, 7.5, 10.0], [5.0, 6.666666666666666, 10.0]], [[5.0, 7.5, 10.0], [5.0, 6.666666666666666, 10.0]]]
[[[5.0, 7.5, 10.0], [5.0, 6.666666666666666, 10.0], [5.0, 6.875, 10.0]], [[5.0, 7.5, 10.0], [5.0, 6.666666666666666, 10.0], [5.0, 6.875, 10.0]], [[5.0, 7.5, 10.0], [5.0, 6.666666666666666, 10.0], [5.0, 6.875, 10.0]]]
[[[10.0, 12.5, 15.0, 17.5, 20.0], [10.0, 11.0, 13.0, 16.0, 20.0], [10.0, 11.25, 13.333333333333332, 16.25, 20.0], [10.0, 11.428571428571429, 13.571428571428571, 16.428571428571427, 20.0], [10.0, 11.5625, 13.75, 16.5625, 20.0]], [[10.0, 12.5, 15.0, 17.5, 20.0], [10.0, 11.0, 13.0, 16.0, 20.0], [10.0, 11.25, 13.333333333333332, 16.25, 20.0], [10.0, 11.428571428571429, 13.571428571428571, 16.428571428571427, 20.0], [10.0, 11.5625, 13.75, 16.5625, 20.0]], [[10.0, 12.5, 15.0, 17.5, 20.0], [10.0, 11.0, 13.0, 16.0, 20.0], [10.0, 11.25, 13.333333333333332, 16.25, 20.0], [10.0, 11.428571428571429, 13.571428571428571, 16.428571428571427, 20.0], [10.0, 11.5625, 13.75, 16.5625, 20.0]]]

 */
