package hw.hw1_2.clients.actions;

public interface Goable {
    public default double run() {
        System.out.println("Животное бежит");
        return getRunSpeed();
    }
    public double getRunSpeed();
}
