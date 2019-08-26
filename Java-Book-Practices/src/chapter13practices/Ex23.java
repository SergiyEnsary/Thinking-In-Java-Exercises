package chapter13practices;

//Inside invoke() in SimpleDynamicProxy.java, try to print the proxy argument and explain
//what happens.
import java.lang.reflect.*;

class DynamicProxyHandler23 implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler23(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy: " + proxy); // error
		System.out.println("**** proxy: " + proxy.getClass() +
				", method: " + method + ", args: " + args);
		if(args != null)
			for(Object arg : args)
				System.out.println("  " + args);
		return method.invoke(proxied, args);
	}
}

class Ex23 {
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
				new DynamicProxyHandler23(real));
		consumer(proxy);		
	}
}

/*Output:

doSomething
somethingElse asdf
Exception in thread "main" java.lang.StackOverflowError
	at java.base/java.lang.StringBuilder.<init>(StringBuilder.java:124)
	at chapter13practices.DynamicProxyHandler23.invoke(Ex23.java:13)

*/