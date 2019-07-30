package outsidePackage;

public class AClass {

    protected void protectedMethod() {
        System.out.println("protectedMethod in " + this);
    }

    public String toString() {
        return "AClass";
    }
}