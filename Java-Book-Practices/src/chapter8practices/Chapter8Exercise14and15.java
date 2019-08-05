package chapter8practices;

/* Create three interfaces, each with two methods. Inherit a new interface
 * that combines the three, adding a new method. Create a class by 
 * implementing the new interface and also inheriting from a concrete class.
 * Now write four methods, each of which takes one of the four interfaces as
 * an argument. In main(), create an object of your class and pass it to 
 * each of the methods.
 */

interface History {
	void a();
	void b();
}

interface Science {
	void c();
	void d();
}

interface Labs {
	void e();
	void f();
}

interface Classes extends History, Science, Labs {
	void g();
}

class Id {
	private int id = 0;
	public void doc() {}
}

class Student extends Id implements Classes {
	private int id = 123456;
	public void a() {}
	public void b() {}
	public void c() {}
	public void d() {}
	public void e() {}
	public void f() {}
	public void g() {}
}

public class Chapter8Exercise14and15 {
	public static void m1(History history) { history.a(); }
	public static void m2(Science science) { science.c(); }
	public static void m3(Labs labs) { labs.e(); } 
	public static void m4(Classes classes) { classes.g(); }
	public static void main(String[] args) {
		Student student = new Student();
		m1(student);
		m2(student);
		m3(student);
		m4(student);
	}
}
/*
interface History {
	void a();
	void b();
}

interface Science {
	void c();
	void d();
}

interface Labs {
	void e();
	void f();
}

interface Classes extends History, Science, Labs {
	void g();
}

abstract class Id {
	private int i = 0;
	abstract void id();
}

class Student extends Id implements Classes {
	private int id = 123456;
	public void a() {}
	public void b() {}
	public void c() {}
	public void d() {}
	public void e() {}
	public void f() {}
	public void g() {}
	public void id() {}
}

public class Ex15 {
	public static void m1(History history) { history.a(); }
	public static void m2(Science science) { science.c(); }
	public static void m3(Labs labs) { labs.e(); } 
	public static void m4(Classes classes) { classes.g(); }
	public static void main(String[] args) {
		Student student = new Student();
		m1(student);
		m2(student);
		m3(student);
		m4(student);
	}
}
 */