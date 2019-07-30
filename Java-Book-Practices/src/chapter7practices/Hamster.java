package chapter7practices;

public class Hamster extends Rodent {

    Percussion percussion = new Percussion();

    public Hamster() {
        System.out.println("Create Hamster");
    }

    public void move() {
        System.out.println("Threw the Habitrail");
    }

    public void gnaw() {
        System.out.println("Threw the plastic.");
    }

    public void dispose() {
        System.out.println("Dispose of Hamster");
        percussion.dispose();
        super.dispose();
    }
}