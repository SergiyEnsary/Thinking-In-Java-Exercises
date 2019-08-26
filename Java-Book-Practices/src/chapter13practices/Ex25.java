package chapter13practices;

/* Create a class containing private, protected and package-access methods. 
 * Write code to access these methods from outside of the class's package.
 */

import java.lang.reflect.*;

import outsidePackage.*;

public class Ex25 {
	public static void main(String[] args) throws Exception {
		outsidePackage.A a = SecretMaker.makeSecret();
		System.out.println("a is of class type: " + a.getClass().getName());
		for(Method m : a.getClass().getDeclaredMethods()) {
			m.setAccessible(true);
			m.invoke(a);
		}
	}
}

/*Output:

a is of class type: outsidePackage.Secret
private Secret.h()
package Secret.f()
public Secret.e()
protected Secret.g()

*/