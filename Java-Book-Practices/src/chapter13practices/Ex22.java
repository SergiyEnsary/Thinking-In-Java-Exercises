package chapter13practices;

//Modify SimpleDynamicProxy.java so that it measures method-call times.

import java.lang.reflect.*;
import java.util.*;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long timeIn = new Date().getTime();
		System.out.println("**** proxy: " + proxy.getClass() +
			", method: " + method + ", args: " + args +
			", invoked at " + timeIn + " on " + (new Date()));
		if(args != null) {
			for(Object arg : args) {
				System.out.println("  " + args);
			}
		}
		long timeOut = new Date().getTime();
		System.out.println("Method call-return time: " + (timeOut - timeIn) + " msecs");
		return method.invoke(proxied, args);		
	}
}

class Ex22 {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("asdf");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		
		Interface proxy = (Interface)Proxy.newProxyInstance(
			Interface.class.getClassLoader(),
			new Class[]{ Interface.class },
			new DynamicProxyHandler(real));
		consumer(proxy);		
	}
}

/*Output:

doSomething
somethingElse asdf
**** proxy: class chapter13practices.$Proxy0, method: public abstract void chapter13practices.Interface.doSomething(), args: null, invoked at 1566854106200 on Mon Aug 26 16:15:06 CDT 2019
Method call-return time: 16 msecs
doSomething
**** proxy: class chapter13practices.$Proxy0, method: public abstract void chapter13practices.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@548c4f57, invoked at 1566854106216 on Mon Aug 26 16:15:06 CDT 2019
  [Ljava.lang.Object;@548c4f57
Method call-return time: 1 msecs
somethingElse asdf

*/
