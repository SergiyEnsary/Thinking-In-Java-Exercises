package chapter14practices;

/*
 * Verify that FixedSizeStack in GenericCast.java generates exceptions
 * if you try to go out of its bounds. Does this mean that bounds-checking
 * code is not required?
 */

class FixedSizeStack<T> {
	private int index = 0;
	private Object[] storage;
	
	public FixedSizeStack(int size) {
		storage = new Object[size];
	}
	
	int getIndex() { 
		return index; 
	} 
	
	public void push(T item) { 
		storage[index++] = item; 
	}
	
	@SuppressWarnings("unchecked")
	public T pop() { return (T)storage[--index]; }
}

public class Ex32 {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
		
		for(String str : "A B C D E F G H I J".split(" ")) {
			strings.push(str);
		}
		
		if(strings.getIndex() < SIZE) {
			strings.push("oops");
		}
		
		for(int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}					
	}		
}

/*Output:

J I H G F E D C B A 

 */