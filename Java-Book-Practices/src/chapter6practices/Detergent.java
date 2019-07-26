package chapter6practices;

public class Detergent {

    Cleanser cleanser = new Cleanser();

    @Override
    public String toString() {return cleanser.toString();}

    public void scrub() {
    	append(" Detergent.scrub()");
        cleanser.scrub();
    }

    public void apply() {cleanser.apply();}

    public void dilute() {cleanser.dilute();}

    public void append(String a) {cleanser.append(a);}

    public void foam() {append(" foam()");}
}
