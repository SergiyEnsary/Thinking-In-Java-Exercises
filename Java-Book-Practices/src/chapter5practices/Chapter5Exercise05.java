package chapter5practices;
/*	Chapter 5
 * 	Exercise 5: (2) Create a class with public, private, protected, and package-access fields and method members.
 * 				Create and object of this class and see what kind of compiler messages you get
 * 				when you try to access all the class members. Be aware that classes in the same
 * 				directory are part of the "default" package.
 */
public class Chapter5Exercise05 {
	
	public static void main(String[] args) {
		class Access{
		    public String a = "Public";
		    String b = "Package";
		    protected String c = "Protected";
		    private String d = "private";
		}
		Access access =new Access();
		System.out.println(access.a);
		System.out.println(access.b);
		System.out.println(access.c);
		System.out.println(access.d);
	}
}
