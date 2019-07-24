package practices;

public class Exercise008 {
  public static void main(String[] args) {
        long n1 = 0x23fL;    // Hexadecimal (lowercase)
        System.out.print("n1: " + Long.toBinaryString(n1));
        long n2 = 0x23FL;    // Hexadecimal (uppercase)
        System.out.print("n2: " + Long.toBinaryString(n2));
        long n3 = 01767L;    // Octal
        System.out.print("n3: " + Long.toBinaryString(n3));
    }
}
