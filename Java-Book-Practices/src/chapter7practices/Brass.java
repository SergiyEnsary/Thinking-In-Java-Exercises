package chapter7practices;

public class Brass extends Wind {

    public Brass() {
        System.out.println("Create Brass");
    }

    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
    void adjust() {
        System.out.println("Adjusting Brass");
    }

    public void dispose() {
        System.out.println("Dispose of Brass");
        super.dispose();
    }
}