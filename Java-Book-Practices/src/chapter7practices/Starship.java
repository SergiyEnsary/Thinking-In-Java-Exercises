package chapter7practices;

public class Starship {
    private static int i = 0;

    private AlertStatus alertStatus = new GreenAlert();

    public void status() {
        alertStatus.alert();
    }
    public void changeStatus() {
        if (i++ % 2 == 0) {
            alertStatus = new YellowAlert();
        } else {
            alertStatus = new RedAlert();
        }
    }
}
