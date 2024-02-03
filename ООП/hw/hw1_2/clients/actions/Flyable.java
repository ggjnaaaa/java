package hw.hw1_2.clients.actions;

public interface Flyable {
    public default double fly() {
        System.out.println("Животное летит");
        return getFlySpeed();
    }
    public double getFlySpeed();
}
