package chapter14practices;

//Create a Holder for each of the primitive wrapper types, and show that
//autoboxing and autounboxing works for the set() and get() methods of 
//each instance.

public class Ex30 {
	public static void main(String[] args) {
		Holder<Character> charHolder = new Holder<Character>();
		Holder<Byte> byteHolder = new Holder<Byte>();
		Holder<Short> shortHolder = new Holder<Short>();
		Holder<Integer> intHolder = new Holder<Integer>();
		Holder<Long> longHolder = new Holder<Long>();
		Holder<Float> floatHolder = new Holder<Float>();
		Holder<Double> doubleHolder = new Holder<Double>();
		// Autoboxing and autounboxing work:
		
		charHolder.set('a');
		
		System.out.println(charHolder.get() + ", ");
		System.out.println(charHolder.get().getClass());
		
		char c = charHolder.get();
		System.out.println("char c = charHolder.get() = " + c);
		
		byte b = 1;
		byteHolder.set(b);
		System.out.println(byteHolder.get() + ", ");
		System.out.println(byteHolder.get().getClass());
		
		byte bb = byteHolder.get();
		System.out.println("byte bb = byteHolder.get() = " + bb);			
		
		short s = 1;
		shortHolder.set(s);
		System.out.println(shortHolder.get() + ", ");
		System.out.println(shortHolder.get().getClass());
		
		short ss = shortHolder.get();
		System.out.println("short ss = shortHolder.get() = " + ss);
		intHolder.set(1);
		System.out.println(intHolder.get() + ". ");
		System.out.println(intHolder.get().getClass());
		
		int i = intHolder.get();
		System.out.println("int i = intHolder.get() = " + i);
		
		long l = 2;
		longHolder.set(l);
		System.out.println(longHolder.get() + ", ");
		System.out.println(longHolder.get().getClass());
		
		long ll = longHolder.get();
		System.out.println("long ll = longHolder.get() = " + ll);
		
		float f = 1f;
		floatHolder.set(f);
		System.out.println(floatHolder.get() + ", ");
		System.out.println(floatHolder.get().getClass());
		
		float ff = floatHolder.get();
		System.out.println("float ff = floatHolder.get() = " + ff);
		
		double d = 1.1;
		doubleHolder.set(d);
		System.out.println(doubleHolder.get() + ", ");
		System.out.println(doubleHolder.get().getClass());
		
		double dd = doubleHolder.get();
		System.out.println("double dd = doubleHolder.get() = " + dd);		
	}		
		
}

/*Output:

a, 
class java.lang.Character
char c = charHolder.get() = a
1, 
class java.lang.Byte
byte bb = byteHolder.get() = 1
1, 
class java.lang.Short
short ss = shortHolder.get() = 1
1. 
class java.lang.Integer
int i = intHolder.get() = 1
2, 
class java.lang.Long
long ll = longHolder.get() = 2
1.0, 
class java.lang.Float
float ff = floatHolder.get() = 1.0
1.1, 
class java.lang.Double
double dd = doubleHolder.get() = 1.1

 */