package chapter13practices;

/* Look up the interface for java.lang.Class in the JDK decumentation from 
 * http://java.sun.com. Write a program that takes the name of a class as a
 * command line argument, then uses the Class methods to dump all the 
 * information available for that class. Test your program with a standard
 * library class and a class you create.
 */
import java.lang.reflect.*;
import java.lang.annotation.*;

public class Ex20 {
	private static String usage =
			"usage: " +
			"ShowInfo qualified.class.name\n" +
			"to show available informations about chosen class.";
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		Class<?> c = null;
		try {
			c = Class.forName(args[0]);
		} catch(ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
		System.out.println("desiredAssertionStatus() :\n" + c.desiredAssertionStatus() + "\n");
		System.out.println("getAnnotatedInterfaces() : ");
		if(c.getAnnotatedInterfaces().length == 0) {
			System.out.println("Nothing found.\n");
		}
		else {
			for(AnnotatedType at : c.getAnnotatedInterfaces())
				System.out.println(at);
			System.out.println();
		}
		System.out.println("getAnnotatedSuperclass() :\n" + c.getAnnotatedSuperclass() + "\n");
		System.out.println("getAnnotations() :");
		if(c.getAnnotations().length == 0)
			System.out.println("Nothing found.\n");
		else {
			for(Annotation ann : c.getAnnotations())
				System.out.println(ann);
			System.out.println();
		}
		System.out.println("getCanonicalName :\n" + c.getCanonicalName() + "\n");
		System.out.println("getClasses() :");
		if(c.getClasses().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Class cl : c.getClasses())
				System.out.println(cl);
			System.out.println();
		}
		System.out.println("getClassLoader() :\n" + c.getClassLoader() + "\n");
		System.out.println("getComponentType() :\n" + c.getComponentType() + "\n");
		System.out.println("getConstructors() :");
		if(c.getConstructors().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Constructor constr : c.getConstructors())
				System.out.println(constr);
			System.out.println();
		}
		System.out.println("getDeclaredAnnotations() :");
		if(c.getDeclaredAnnotations().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Annotation ann : c.getDeclaredAnnotations())
				System.out.println(ann);
			System.out.println();
		}
		System.out.println("getDeclaredClasses() :");
		if(c.getDeclaredClasses().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Class cl : c.getDeclaredClasses())
				System.out.println(cl);
			System.out.println();
		}
		System.out.println("getDeclaredConstructors() :");
		if(c.getDeclaredConstructors().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Constructor constr : c.getDeclaredConstructors())
				System.out.println(constr);
			System.out.println();
		}
		System.out.println("getDeclaredFields() :");
		if(c.getDeclaredFields().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Field field : c.getDeclaredFields())
				System.out.println(field);
			System.out.println();
		}
		System.out.println("getDeclaredMethods() :");
		if(c.getDeclaredMethods().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Method m : c.getDeclaredMethods())
				System.out.println(m);
			System.out.println();
		}
		System.out.println("getDeclaringClass() :\n" + c.getDeclaringClass() + "\n");
		System.out.println("getEnclosingClass() :\n" + c.getEnclosingClass() + "\n");
		System.out.println("getEnclosingConstructor() :\n" + c.getEnclosingConstructor() + "\n");
		System.out.println("getEnclosingMethod() :\n" + c.getEnclosingMethod() + "\n");
		System.out.println("getEnumConstants() :\n" + c.getEnumConstants() + "\n");
		System.out.println("getFields() :");
		if(c.getFields().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Field field : c.getFields())
				System.out.println(field);
			System.out.println();
		}
		System.out.println("getGenericInterfaces() :");
		if(c.getGenericInterfaces().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Type gi : c.getGenericInterfaces())
				System.out.println(gi);
			System.out.println();
		}
		System.out.println("getGenericSuperclass() :\n" + c.getGenericSuperclass() + "\n");
		System.out.println("getInterfaces() :");
		if(c.getInterfaces().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Type i : c.getInterfaces())
				System.out.println(i);
			System.out.println();
		}
		System.out.println("getMethods() :");
		if(c.getMethods().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(Method m : c.getMethods())
				System.out.println(m);
			System.out.println();
		}
		System.out.println("getModifiers() :\n" + c.getModifiers() + "\n");
		System.out.println("getName() :\n" + c.getName() + "\n");
		System.out.println("getPackage() :\n" + c.getPackage() + "\n");
		System.out.println("getProtectionDomain() :\n" + c.getProtectionDomain() + "\n");
		System.out.println("getSigners() :");
		if(c.getSigners() == null) {
			System.out.println(c.getSigners() + "\n");
		}
		if(c.getSigners() != null) {
			if(c.getSigners().length == 0)
				System.out.println("None\n");
			if(c.getSigners().length > 0) {
				for(Object o : c.getSigners())
					System.out.println(o);
				System.out.println();
			}
		}
		System.out.println("getSimpleName() :\n" + c.getSimpleName() + "\n");
		System.out.println("getSuperclass() :\n" + c.getSuperclass() + "\n");
		System.out.println("getTypeName() :\n" + c.getTypeName() + "\n");
		System.out.println("getTypeParameters() :");
		if(c.getTypeParameters().length == 0) {
			System.out.println("Nothing found.\n");
		}else {
			for(TypeVariable tv : c.getTypeParameters())
				System.out.println(tv);
			System.out.println();
		}
		System.out.println("isAnnotation() :\n" + c.isAnnotation() + "\n");
		System.out.println("isAnonymousClass() :\n" + c.isAnonymousClass() + "\n");
		System.out.println("isArray() :\n" + c.isArray() + "\n");
		System.out.println("isEnum() :\n" + c.isEnum() + "\n");
		System.out.println("c.isInstance(Object.class) :\n" + c.isInstance(Object.class) + "\n");
		System.out.println("Object.class.isInstance(c) :\n" + Object.class.isInstance(c) + "\n");
		System.out.println("isInterface() :\n" + c.isInterface() + "\n");
		System.out.println("isLocalClass() :\n" + c.isLocalClass() + "\n");
		System.out.println("isMemberClass() :\n" + c.isMemberClass() + "\n");
		System.out.println("isPrimitive :\n" + c.isPrimitive() + "\n");
		System.out.println("isSynthetic() :\n" + c.isSynthetic() + "\n");
		System.out.println("toGenericString() :\n" + c.toGenericString() + "\n");
		System.out.println("toString() :\n" + c.toString() + "\n");
	}
}

/* Output:
desiredAssertionStatus() :
false
getAnnotatedInterfaces() : 
sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedParameterizedTypeImpl@52e922
getAnnotatedSuperclass() :
sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@25154f
getAnnotations() :
Nothing found.
getCanonicalName :
java.math.BigDecimal
getClasses() :
Nothing found.
getClassLoader() :
null
getComponentType() :
null
getConstructors() :
public java.math.BigDecimal(java.math.BigInteger,int)
public java.math.BigDecimal(java.math.BigInteger,java.math.MathContext)
public java.math.BigDecimal(java.math.BigInteger)
public java.math.BigDecimal(double,java.math.MathContext)
public java.math.BigDecimal(double)
public java.math.BigDecimal(long)
public java.math.BigDecimal(int,java.math.MathContext)
public java.math.BigDecimal(int)
public java.math.BigDecimal(java.math.BigInteger,int,java.math.MathContext)
public java.math.BigDecimal(long,java.math.MathContext)
public java.math.BigDecimal(char[],int,int,java.math.MathContext)
public java.math.BigDecimal(char[],int,int)
public java.math.BigDecimal(java.lang.String,java.math.MathContext)
public java.math.BigDecimal(java.lang.String)
public java.math.BigDecimal(char[],java.math.MathContext)
public java.math.BigDecimal(char[])
getDeclaredAnnotations() :
Nothing found.
getDeclaredClasses() :
class java.math.BigDecimal$LongOverflow
class java.math.BigDecimal$StringBuilderHelper
class java.math.BigDecimal$UnsafeHolder
getDeclaredConstructors() :
public java.math.BigDecimal(java.math.BigInteger,int)
public java.math.BigDecimal(java.math.BigInteger,java.math.MathContext)
public java.math.BigDecimal(java.math.BigInteger)
public java.math.BigDecimal(double,java.math.MathContext)
public java.math.BigDecimal(double)
public java.math.BigDecimal(long)
public java.math.BigDecimal(int,java.math.MathContext)
public java.math.BigDecimal(int)
public java.math.BigDecimal(java.math.BigInteger,int,java.math.MathContext)
public java.math.BigDecimal(long,java.math.MathContext)
public java.math.BigDecimal(char[],int,int,java.math.MathContext)
public java.math.BigDecimal(char[],int,int)
java.math.BigDecimal(java.math.BigInteger,long,int,int)
public java.math.BigDecimal(java.lang.String,java.math.MathContext)
public java.math.BigDecimal(java.lang.String)
public java.math.BigDecimal(char[],java.math.MathContext)
public java.math.BigDecimal(char[])
getDeclaredFields() :
private final java.math.BigInteger java.math.BigDecimal.intVal
private final int java.math.BigDecimal.scale
private transient int java.math.BigDecimal.precision
private transient java.lang.String java.math.BigDecimal.stringCache
static final long java.math.BigDecimal.INFLATED
private static final java.math.BigInteger java.math.BigDecimal.INFLATED_BIGINT
private final transient long java.math.BigDecimal.intCompact
private static final int java.math.BigDecimal.MAX_COMPACT_DIGITS
private static final long java.math.BigDecimal.serialVersionUID
private static final java.lang.ThreadLocal java.math.BigDecimal.threadLocalStringBuilderHelper
private static final java.math.BigDecimal[] java.math.BigDecimal.zeroThroughTen
private static final java.math.BigDecimal[] java.math.BigDecimal.ZERO_SCALED_BY
private static final long java.math.BigDecimal.HALF_LONG_MAX_VALUE
private static final long java.math.BigDecimal.HALF_LONG_MIN_VALUE
public static final java.math.BigDecimal java.math.BigDecimal.ZERO
public static final java.math.BigDecimal java.math.BigDecimal.ONE
public static final java.math.BigDecimal java.math.BigDecimal.TEN
public static final int java.math.BigDecimal.ROUND_UP
public static final int java.math.BigDecimal.ROUND_DOWN
public static final int java.math.BigDecimal.ROUND_CEILING
public static final int java.math.BigDecimal.ROUND_FLOOR
public static final int java.math.BigDecimal.ROUND_HALF_UP
public static final int java.math.BigDecimal.ROUND_HALF_DOWN
public static final int java.math.BigDecimal.ROUND_HALF_EVEN
public static final int java.math.BigDecimal.ROUND_UNNECESSARY
private static final double[] java.math.BigDecimal.double10pow
private static final float[] java.math.BigDecimal.float10pow
private static final long[] java.math.BigDecimal.LONG_TEN_POWERS_TABLE
private static volatile java.math.BigInteger[] java.math.BigDecimal.BIG_TEN_POWERS_TABLE
private static final int java.math.BigDecimal.BIG_TEN_POWERS_TABLE_INITLEN
private static final int java.math.BigDecimal.BIG_TEN_POWERS_TABLE_MAX
private static final long[] java.math.BigDecimal.THRESHOLDS_TABLE
private static final long java.math.BigDecimal.DIV_NUM_BASE
private static final long[][] java.math.BigDecimal.LONGLONG_TEN_POWERS_TABLE
static final boolean java.math.BigDecimal.$assertionsDisabled
getDeclaredMethods() :
private static java.math.BigDecimal java.math.BigDecimal.add(java.math.BigInteger,int,java.math.BigInteger,int)
private static long java.math.BigDecimal.add(long,long)
public java.math.BigDecimal java.math.BigDecimal.add(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.add(java.math.BigDecimal)
private static java.math.BigDecimal java.math.BigDecimal.add(long,int,java.math.BigInteger,int)
private static java.math.BigDecimal java.math.BigDecimal.add(long,int,long,int)
private static java.math.BigDecimal java.math.BigDecimal.add(long,long,int)
public boolean java.math.BigDecimal.equals(java.lang.Object)
public java.lang.String java.math.BigDecimal.toString()
public int java.math.BigDecimal.hashCode()
public java.math.BigDecimal java.math.BigDecimal.abs(java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.abs()
public java.math.BigDecimal java.math.BigDecimal.pow(int)
public java.math.BigDecimal java.math.BigDecimal.pow(int,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.min(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.max(java.math.BigDecimal)
public int java.math.BigDecimal.compareTo(java.lang.Object)
public int java.math.BigDecimal.compareTo(java.math.BigDecimal)
public int java.math.BigDecimal.intValue()
public long java.math.BigDecimal.longValue()
public float java.math.BigDecimal.floatValue()
public double java.math.BigDecimal.doubleValue()
static java.math.BigDecimal java.math.BigDecimal.valueOf(java.math.BigInteger,int,int)
public static java.math.BigDecimal java.math.BigDecimal.valueOf(double)
public static java.math.BigDecimal java.math.BigDecimal.valueOf(long)
static java.math.BigDecimal java.math.BigDecimal.valueOf(long,int,int)
public static java.math.BigDecimal java.math.BigDecimal.valueOf(long,int)
static java.math.BigInteger java.math.BigDecimal.access$000(java.math.BigDecimal)
private void java.math.BigDecimal.readObject(java.io.ObjectInputStream) throws java.io.IOException,java.lang.ClassNotFoundException
private void java.math.BigDecimal.writeObject(java.io.ObjectOutputStream) throws java.io.IOException
private static void java.math.BigDecimal.print(java.lang.String,java.math.BigDecimal)
public int java.math.BigDecimal.signum()
private static java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigInteger,int,long,int,long,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.divide(long,int,java.math.BigInteger,int,long,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.divide(long,int,long,int,long,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.divide(long,int,long,int,int,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int,java.math.RoundingMode)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,java.math.RoundingMode)
private static java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigInteger,int,java.math.BigInteger,int,int,int)
private static java.math.BigDecimal java.math.BigDecimal.divide(long,int,java.math.BigInteger,int,int,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigInteger,int,java.math.BigInteger,int,long,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigInteger,int,long,int,int,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.remainder(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.remainder(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.round(java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.ulp()
public int java.math.BigDecimal.scale()
private int java.math.BigDecimal.adjustScale(int,long)
private java.math.BigDecimal java.math.BigDecimal.audit()
private static int java.math.BigDecimal.bigDigitLength(java.math.BigInteger)
private static java.math.BigInteger java.math.BigDecimal.bigMultiplyPowerTen(long,int)
private java.math.BigInteger java.math.BigDecimal.bigMultiplyPowerTen(int)
private static java.math.BigInteger java.math.BigDecimal.bigMultiplyPowerTen(java.math.BigInteger,int)
private static java.math.BigInteger java.math.BigDecimal.bigTenToThe(int)
public byte java.math.BigDecimal.byteValueExact()
private static int java.math.BigDecimal.checkScale(java.math.BigInteger,long)
private int java.math.BigDecimal.checkScale(long)
private static int java.math.BigDecimal.checkScale(long,long)
private static int java.math.BigDecimal.checkScaleNonZero(long)
private static boolean java.math.BigDecimal.commonNeedIncrement(int,int,int,boolean)
private static long java.math.BigDecimal.compactValFor(java.math.BigInteger)
private int java.math.BigDecimal.compareMagnitude(java.math.BigDecimal)
private static int java.math.BigDecimal.compareMagnitudeNormalized(long,int,java.math.BigInteger,int)
private static int java.math.BigDecimal.compareMagnitudeNormalized(java.math.BigInteger,int,java.math.BigInteger,int)
private static int java.math.BigDecimal.compareMagnitudeNormalized(long,int,long,int)
private static java.math.BigDecimal java.math.BigDecimal.createAndStripZerosToMatchScale(java.math.BigInteger,int,long)
private static java.math.BigDecimal java.math.BigDecimal.createAndStripZerosToMatchScale(long,int,long)
private static long[] java.math.BigDecimal.divRemNegativeLong(long,long)
public java.math.BigDecimal[] java.math.BigDecimal.divideAndRemainder(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal[] java.math.BigDecimal.divideAndRemainder(java.math.BigDecimal)
private static long java.math.BigDecimal.divideAndRound(long,long,int)
private static java.math.BigDecimal java.math.BigDecimal.divideAndRound(java.math.BigInteger,java.math.BigInteger,int,int,int)
private static java.math.BigInteger java.math.BigDecimal.divideAndRound(java.math.BigInteger,long,int)
private static java.math.BigInteger java.math.BigDecimal.divideAndRound(java.math.BigInteger,java.math.BigInteger,int)
private static java.math.BigDecimal java.math.BigDecimal.divideAndRound(java.math.BigInteger,long,int,int,int)
private static java.math.BigDecimal java.math.BigDecimal.divideAndRound(long,long,int,int,int)
private static java.math.BigDecimal java.math.BigDecimal.divideAndRound128(long,long,long,int,int,int,int)
private static java.math.BigInteger java.math.BigDecimal.divideAndRoundByTenPow(java.math.BigInteger,int,int)
private static java.math.BigDecimal java.math.BigDecimal.divideSmallFastPath(long,int,long,int,long,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.divideToIntegralValue(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.divideToIntegralValue(java.math.BigDecimal)
private static java.math.BigDecimal java.math.BigDecimal.doRound(java.math.BigDecimal,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.doRound(java.math.BigInteger,int,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.doRound(long,int,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.doRound128(long,long,int,int,java.math.MathContext)
private static java.math.BigInteger java.math.BigDecimal.expandBigIntegerTenPowers(int)
private java.lang.String java.math.BigDecimal.getValueString(int,java.lang.String,int)
private java.math.BigInteger java.math.BigDecimal.inflated()
public int java.math.BigDecimal.intValueExact()
private java.lang.String java.math.BigDecimal.layoutChars(boolean)
private static int java.math.BigDecimal.longCompareMagnitude(long,long)
static int java.math.BigDecimal.longDigitLength(long)
private static boolean java.math.BigDecimal.longLongCompareMagnitude(long,long,long,long)
private static long java.math.BigDecimal.longMultiplyPowerTen(long,int)
public long java.math.BigDecimal.longValueExact()
private static long java.math.BigDecimal.make64(long,long)
private static void java.math.BigDecimal.matchScale(java.math.BigDecimal[])
public java.math.BigDecimal java.math.BigDecimal.movePointLeft(int)
public java.math.BigDecimal java.math.BigDecimal.movePointRight(int)
private static long java.math.BigDecimal.mulsub(long,long,long,long,long)
private static java.math.BigDecimal java.math.BigDecimal.multiply(long,long,int)
private static java.math.BigDecimal java.math.BigDecimal.multiply(long,java.math.BigInteger,int)
private static java.math.BigDecimal java.math.BigDecimal.multiply(java.math.BigInteger,java.math.BigInteger,int)
public java.math.BigDecimal java.math.BigDecimal.multiply(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.multiply(java.math.BigDecimal,java.math.MathContext)
private static long java.math.BigDecimal.multiply(long,long)
private static java.math.BigDecimal java.math.BigDecimal.multiplyAndRound(long,long,int,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.multiplyAndRound(java.math.BigInteger,java.math.BigInteger,int,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.multiplyAndRound(long,java.math.BigInteger,int,java.math.MathContext)
private static java.math.BigDecimal java.math.BigDecimal.multiplyDivideAndRound(long,long,long,int,int,int)
private static boolean java.math.BigDecimal.needIncrement(long,int,int,long,long)
private static boolean java.math.BigDecimal.needIncrement(long,int,int,java.math.MutableBigInteger,long)
private static boolean java.math.BigDecimal.needIncrement(java.math.MutableBigInteger,int,int,java.math.MutableBigInteger,java.math.MutableBigInteger)
public java.math.BigDecimal java.math.BigDecimal.negate()
public java.math.BigDecimal java.math.BigDecimal.negate(java.math.MathContext)
private static long java.math.BigDecimal.parseExp(char[],int,int)
public java.math.BigDecimal java.math.BigDecimal.plus()
public java.math.BigDecimal java.math.BigDecimal.plus(java.math.MathContext)
private java.math.BigDecimal[] java.math.BigDecimal.preAlign(java.math.BigDecimal,java.math.BigDecimal,long,java.math.MathContext)
public int java.math.BigDecimal.precision()
private static int java.math.BigDecimal.precision(long,long)
private static java.math.BigDecimal java.math.BigDecimal.roundedTenPower(int,int,int,int)
private static int java.math.BigDecimal.saturateLong(long)
public java.math.BigDecimal java.math.BigDecimal.scaleByPowerOfTen(int)
static java.math.BigDecimal java.math.BigDecimal.scaledTenPow(int,int,int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int,int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int,java.math.RoundingMode)
public short java.math.BigDecimal.shortValueExact()
public java.math.BigDecimal java.math.BigDecimal.stripTrailingZeros()
private static java.math.BigDecimal java.math.BigDecimal.stripZerosToMatchScale(java.math.BigInteger,long,int,int)
public java.math.BigDecimal java.math.BigDecimal.subtract(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.subtract(java.math.BigDecimal)
public java.math.BigInteger java.math.BigDecimal.toBigInteger()
public java.math.BigInteger java.math.BigDecimal.toBigIntegerExact()
public java.lang.String java.math.BigDecimal.toEngineeringString()
public java.lang.String java.math.BigDecimal.toPlainString()
public java.math.BigInteger java.math.BigDecimal.unscaledValue()
private static boolean java.math.BigDecimal.unsignedLongCompare(long,long)
private static boolean java.math.BigDecimal.unsignedLongCompareEq(long,long)
static java.math.BigDecimal java.math.BigDecimal.zeroValueOf(int)
getDeclaringClass() :
null
getEnclosingClass() :
null
getEnclosingConstructor() :
null
getEnclosingMethod() :
null
getEnumConstants() :
null
getFields() :
public static final java.math.BigDecimal java.math.BigDecimal.ZERO
public static final java.math.BigDecimal java.math.BigDecimal.ONE
public static final java.math.BigDecimal java.math.BigDecimal.TEN
public static final int java.math.BigDecimal.ROUND_UP
public static final int java.math.BigDecimal.ROUND_DOWN
public static final int java.math.BigDecimal.ROUND_CEILING
public static final int java.math.BigDecimal.ROUND_FLOOR
public static final int java.math.BigDecimal.ROUND_HALF_UP
public static final int java.math.BigDecimal.ROUND_HALF_DOWN
public static final int java.math.BigDecimal.ROUND_HALF_EVEN
public static final int java.math.BigDecimal.ROUND_UNNECESSARY
getGenericInterfaces() :
java.lang.Comparable<java.math.BigDecimal>
getGenericSuperclass() :
class java.lang.Number
getInterfaces() :
interface java.lang.Comparable
getMethods() :
public java.math.BigDecimal java.math.BigDecimal.add(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.add(java.math.BigDecimal)
public boolean java.math.BigDecimal.equals(java.lang.Object)
public java.lang.String java.math.BigDecimal.toString()
public int java.math.BigDecimal.hashCode()
public java.math.BigDecimal java.math.BigDecimal.abs(java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.abs()
public java.math.BigDecimal java.math.BigDecimal.pow(int)
public java.math.BigDecimal java.math.BigDecimal.pow(int,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.min(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.max(java.math.BigDecimal)
public int java.math.BigDecimal.compareTo(java.lang.Object)
public int java.math.BigDecimal.compareTo(java.math.BigDecimal)
public int java.math.BigDecimal.intValue()
public long java.math.BigDecimal.longValue()
public float java.math.BigDecimal.floatValue()
public double java.math.BigDecimal.doubleValue()
public static java.math.BigDecimal java.math.BigDecimal.valueOf(double)
public static java.math.BigDecimal java.math.BigDecimal.valueOf(long)
public static java.math.BigDecimal java.math.BigDecimal.valueOf(long,int)
public int java.math.BigDecimal.signum()
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int,java.math.RoundingMode)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,int)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,java.math.RoundingMode)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.divide(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.remainder(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.remainder(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.round(java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.ulp()
public int java.math.BigDecimal.scale()
public byte java.math.BigDecimal.byteValueExact()
public java.math.BigDecimal[] java.math.BigDecimal.divideAndRemainder(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal[] java.math.BigDecimal.divideAndRemainder(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.divideToIntegralValue(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.divideToIntegralValue(java.math.BigDecimal)
public int java.math.BigDecimal.intValueExact()
public long java.math.BigDecimal.longValueExact()
public java.math.BigDecimal java.math.BigDecimal.movePointLeft(int)
public java.math.BigDecimal java.math.BigDecimal.movePointRight(int)
public java.math.BigDecimal java.math.BigDecimal.multiply(java.math.BigDecimal)
public java.math.BigDecimal java.math.BigDecimal.multiply(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.negate()
public java.math.BigDecimal java.math.BigDecimal.negate(java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.plus()
public java.math.BigDecimal java.math.BigDecimal.plus(java.math.MathContext)
public int java.math.BigDecimal.precision()
public java.math.BigDecimal java.math.BigDecimal.scaleByPowerOfTen(int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int,int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int)
public java.math.BigDecimal java.math.BigDecimal.setScale(int,java.math.RoundingMode)
public short java.math.BigDecimal.shortValueExact()
public java.math.BigDecimal java.math.BigDecimal.stripTrailingZeros()
public java.math.BigDecimal java.math.BigDecimal.subtract(java.math.BigDecimal,java.math.MathContext)
public java.math.BigDecimal java.math.BigDecimal.subtract(java.math.BigDecimal)
public java.math.BigInteger java.math.BigDecimal.toBigInteger()
public java.math.BigInteger java.math.BigDecimal.toBigIntegerExact()
public java.lang.String java.math.BigDecimal.toEngineeringString()
public java.lang.String java.math.BigDecimal.toPlainString()
public java.math.BigInteger java.math.BigDecimal.unscaledValue()
public byte java.lang.Number.byteValue()
public short java.lang.Number.shortValue()
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
getModifiers() :
1
getName() :
java.math.BigDecimal
getPackage() :
package java.math, Java Platform API Specification, version 1.8
getProtectionDomain() :
ProtectionDomain  null
 null
 <no principals>
 java.security.Permissions@1c7c054 (
 ("java.security.AllPermission" "<all permissions>" "<all actions>")
)
getSigners() :
null
getSimpleName() :
BigDecimal
getSuperclass() :
class java.lang.Number
getTypeName() :
java.math.BigDecimal
getTypeParameters() :
Nothing found.
isAnnotation() :
false
isAnonymousClass() :
false
isArray() :
false
isEnum() :
false
c.isInstance(Object.class) :
false
Object.class.isInstance(c) :
true
isInterface() :
false
isLocalClass() :
false
isMemberClass() :
false
isPrimitive :
false
isSynthetic() :
false
toGenericString() :
public class java.math.BigDecimal
toString() :
class java.math.BigDecimal
*/