package hw.hw1_3.List.core.lists;

import hw.hw1_3.List.core.MyList;
import hw.hw1_3.List.core.util.ArrayIterator;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private int size;
    private T[] values;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.size = 0;
        this.capacity = 2;
        try {
            this.values = (T[]) new Object[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private void addCapacity() {
        try {
            capacity = capacity * 2;
            T[] temp = (T[]) new Object[capacity];
            System.arraycopy(values, 0, temp, 0, values.length);
            values = temp;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void add(T elem) {
        if (size == capacity) {
            addCapacity();
        }
        values[size++] = elem;
    }

    @Override
    public void remove(int index) {
        capacity = capacity - 1;
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(values, 0, temp, 0, index);
        int amountElementsAfterIndex = values.length - index - 1;
        System.arraycopy(values, index + 1, temp, index, amountElementsAfterIndex);
        values = temp;
        size--;
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (values[i] == object) return i;
        }
        return -1;
    }

    @Override
    public void set(int index, T object) {
        try {
            values[index] = object;
        }
        catch (ArrayIndexOutOfBoundsException i) {
            i.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int index = 0;
        while (index < size - 1) {
            builder.append(values[index]).append(", ");
            index++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.append(values[index]);
        builder.append("]");
        return builder.toString();
    }
}
