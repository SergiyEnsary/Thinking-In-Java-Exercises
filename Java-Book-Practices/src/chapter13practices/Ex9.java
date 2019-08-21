package chapter13practices;

class A9 { 
	int i; 
	String s; 
	}

class B9 extends A9 { 
	int j; 
	float f; 
	}

class C9 extends B9 { 
	int k; 
	B9 b;
	}

public class Ex9 {
	public static void Hierarchy(Object o) {
		Object[] fields = o.getClass().getDeclaredFields();
		if(fields.length == 0) {
			System.out.println(o.getClass() + " has no fields");
		}
		if(fields.length > 0) {
			System.out.println("Field(s) of " + o.getClass() + ":");
			for(Object obj : fields) { 
				System.out.println(" " + obj);
			}
		}
		if(o.getClass().getSuperclass() != null) {			
			System.out.println(o.getClass() + " is a subclass of " + o.getClass().getSuperclass()); 
			try {
				Hierarchy(o.getClass().getSuperclass().newInstance());
			} catch(InstantiationException e) {
				System.out.println("Unable to instantiate obj");
			} catch(IllegalAccessException e) {
				System.out.println("Unable to access");
			}
		} 
	}		
	public static void main(String[] args) {
		Hierarchy(new C9());
	}
}

/*Output:

Field(s) of class chapter13practices.C9:
 int chapter13practices.C9.k
 chapter13practices.B9 chapter13practices.C9.b
class chapter13practices.C9 is a subclass of class chapter13practices.B9
Field(s) of class chapter13practices.B9:
 int chapter13practices.B9.j
 float chapter13practices.B9.f
class chapter13practices.B9 is a subclass of class chapter13practices.A9
Field(s) of class chapter13practices.A9:
 int chapter13practices.A9.i
 java.lang.String chapter13practices.A9.s
class chapter13practices.A9 is a subclass of class java.lang.Object
class java.lang.Object has no fields

 */