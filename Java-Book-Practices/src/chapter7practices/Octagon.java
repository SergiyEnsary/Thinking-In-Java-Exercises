package chapter7practices;

public class Octagon extends Shape {
    @Override
    public void draw() {
        System.out.println("Octagon.draw()");
    }
    @Override
    public void erase() {
        System.out.println("Octagon.erase()");
    }
    @Override
    public String toString() {
        return "Octagon";
    }
}