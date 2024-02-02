package hw.hw1.drugstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy> {
    private List<Component> components = new ArrayList<>();
    private int index = 0;

    public void addComponents(Component ... components) {
        for(Component c : components){
            this.components.add(c);
        }
    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() { //Анонимный класс

            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public int compareTo(Pharmacy o) {
        Double componentsWeightSum = 0D;
        Double thisComponentsWeightSum = 0D;

        for(Component comp : o.components) componentsWeightSum += comp.getWeight();
        for(Component comp : components) thisComponentsWeightSum += comp.getWeight();

        if (thisComponentsWeightSum > componentsWeightSum) return 1;
        if (thisComponentsWeightSum < componentsWeightSum) return -1;
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("Components = %s", components);
    }
}
