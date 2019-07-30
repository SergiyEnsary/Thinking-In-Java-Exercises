package chapter7practices;

public class Woodwind extends Wind {
    void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }
    String what() { return super.toString(); }
}