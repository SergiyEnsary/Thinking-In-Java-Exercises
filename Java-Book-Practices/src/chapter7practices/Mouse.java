package chapter7practices;

public class Mouse extends Rodent {

    Stringed stringed = new Stringed();

    public Mouse() {
        System.out.println("Create Mouse");
    }

    public void move() {
        System.out.println("Into Hiding.");
    }

    public void gnaw() {
        System.out.println("Into the wall.");
    }
    public void dispose() {
        System.out.println("Dispose of Mouse");
        stringed.dispose();
        super.dispose();
    }
}