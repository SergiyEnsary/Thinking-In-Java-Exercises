package chapter7practices;

public class Stringed extends Instrument {

    public Stringed() {
        System.out.println("Create Stringed");
    }

    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
    String what() { return super.toString(); }
    void adjust() {
        System.out.println("Adjusting Stringed");
    }

    public void dispose() {
        System.out.println("Dispose of Stringed");
        super.dispose();
    }
}
