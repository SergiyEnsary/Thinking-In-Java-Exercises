package chapter14practices;

/* Use a type tag along with reflection to create a method that uses the 
 * argument version of newInstance() to create an object of a class with
 * a constructor that has arguments.
 */

import java.lang.reflect.*;

class Creator<T> {
	Class<T> kind;
	public Creator(Class<T> kind) {
		this.kind = kind;
	}
	public T createNew(String typename) {
		try {
			Constructor<T> constructor = kind.getConstructor(typename.getClass());
			try {
				return (T)constructor.newInstance(typename);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}

public class Ex22 {
	public static void main(String[] args) {
		Creator<Integer> c = new Creator<Integer>(Integer.class);
		System.out.println(c.createNew("128"));		
	}
}

/*Output:

128

 */