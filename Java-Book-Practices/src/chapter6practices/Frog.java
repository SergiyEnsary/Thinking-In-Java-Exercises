package chapter6practices;

public class Frog extends Amphibian {

    public String toString() {
        return "Frog";
    }
    @Override
    public void method() {
        System.out.println("This is overriding the base method.");
    }
}