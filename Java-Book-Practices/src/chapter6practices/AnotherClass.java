package chapter6practices;

import outsidePackage.AClass;

public class AnotherClass extends AClass {

    public void callProtectedMethod() {
        protectedMethod();
    }
}