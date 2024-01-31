package hw.hw1.clients.actions;

public interface Goable {
    public default double run() {
        System.out.println("Животное бежит");
        return getRunSpeed();
    }
    public double getRunSpeed();
}
