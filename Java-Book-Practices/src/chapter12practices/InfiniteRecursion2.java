package chapter12practices;

//Repair InfiniteRecursion.java
import java.util.*;

public class InfiniteRecursion2 {	
	public String toString() {
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}
	public static void main(String[] args) {
		List<InfiniteRecursion2> v = new ArrayList<InfiniteRecursion2>();
		for(int i = 0; i < 10; i++)
			v.add(new InfiniteRecursion2());
		System.out.println(v);
	}
}
/*Output:

[ InfiniteRecursion address: chapter12practices.InfiniteRecursion2@3cd1a2f1
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@2f0e140b
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@7440e464
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@49476842
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@78308db1
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@27c170f0
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@5451c3a8
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@2626b418
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@5a07e868
,  InfiniteRecursion address: chapter12practices.InfiniteRecursion2@76ed5528
]

 */