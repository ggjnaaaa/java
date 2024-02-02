package hw.hw1.drugstore;

public abstract class Component implements Comparable<Component> {
    private String title;
    private Double weight;
    private int power;

    public Component(String title, Double weight, int power) { //ALT + Insert
        this.title = title;
        this.weight = weight;
        this.power = power;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Component o) {
        return Integer.compare(this.power, o.power);
    }
}
