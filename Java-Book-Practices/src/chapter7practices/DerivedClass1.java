package chapter7practices;

/*
 * Exercise 10:    (3) Create a base class with two methods. In the first method, call the second method.
 *      Inherit a class and override the second method. Create an object of the derived class, upcast it to
 *      the base type, and call the first method. Explain what happens.
 */
public class DerivedClass1 extends BaseClass1 {

    @Override
    public void method2() {
        System.out.println("DerivedClass1");
    }
}