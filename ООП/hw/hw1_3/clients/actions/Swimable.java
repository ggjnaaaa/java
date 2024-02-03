package hw.hw1_3.clients.actions;

public interface Swimable {
    public default double swim()  {
        System.out.println("Животное плывёт");
        return getSwimSpeed();
    }
    public double getSwimSpeed();
    
}