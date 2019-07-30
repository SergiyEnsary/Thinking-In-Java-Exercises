package chapter7practices;

public class Gerbil extends Rodent {

    Brass brass = new Brass();

    public Gerbil() {
        System.out.println("Create Gerbil");
    }

    public void move() {
        System.out.println("To the pellet dish");
    }

    public void gnaw() {
        System.out.println("Into the pellets.");
    }

    public void dispose() {
        System.out.println("Dispose of Gerbil");
        brass.dispose();
        super.dispose();
    }
}