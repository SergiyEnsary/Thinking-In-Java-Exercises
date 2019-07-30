package chapter7practices;

public class UniCycle extends Cycle {

    public String toString() {
        return "UniCycle";
    }

    public int wheels() {
        return 1;
    }

    public void balance() {
        System.out.println("Balancing on " + this);
    }
}