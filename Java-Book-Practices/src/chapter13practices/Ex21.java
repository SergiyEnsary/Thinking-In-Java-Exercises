package chapter13practices;

//Modify SimpleProxyDemo.java so that it measures method-call times.

import java.util.*;

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() { System.out.println("doSomething"); }
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	private static int doCount = 0;
	private static int sECount = 0;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	public void doSomething() { 
		long timeIn = new Date().getTime();
		System.out.println("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
		System.out.println("on " + new Date());
		doCount++;
		proxied.doSomething();
		System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
	}
	public void somethingElse(String arg) {
		long timeIn = new Date().getTime();
		System.out.println("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
		System.out.println("on " + new Date());
		sECount++;
		proxied.somethingElse(arg);
		System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
	}
}

class Ex21 {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("asdf");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		System.out.println();
		consumer(new SimpleProxy(new RealObject()));
		System.out.println();
		consumer(new SimpleProxy(new RealObject()));
		System.out.println();
		consumer(new SimpleProxy(new RealObject()));					
	}
}

/*Output:

doSomething
somethingElse asdf

Time called doSomething() 0: 1566853963238 msecs
on Mon Aug 26 16:12:43 CDT 2019
doSomething
Call-return time = 19 msecs
Time called somethingElse() 0: 1566853963257 msecs
on Mon Aug 26 16:12:43 CDT 2019
somethingElse asdf
Call-return time = 1 msecs

Time called doSomething() 1: 1566853963258 msecs
on Mon Aug 26 16:12:43 CDT 2019
doSomething
Call-return time = 0 msecs
Time called somethingElse() 1: 1566853963258 msecs
on Mon Aug 26 16:12:43 CDT 2019
somethingElse asdf
Call-return time = 0 msecs

Time called doSomething() 2: 1566853963258 msecs
on Mon Aug 26 16:12:43 CDT 2019
doSomething
Call-return time = 0 msecs
Time called somethingElse() 2: 1566853963258 msecs
on Mon Aug 26 16:12:43 CDT 2019
somethingElse asdf
Call-return time = 0 msecs

*/