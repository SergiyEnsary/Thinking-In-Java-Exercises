package chapter7practices;

public class Reed extends Instrument {

    public Reed() {
        System.out.println("Create Reed");
    }

    void play(Note n) {
        System.out.println("Reed.play() " + n);
    }
    String what() { return super.toString(); }
    void adjust() {
        System.out.println("Adjusting Reed");
    }
    public void dispose() {
        System.out.println("Dispose of Reed");
        super.dispose();
    }
}