package hw.hw1_3.List.core;

/**
 * MyList
 */
public interface MyList<T> extends Iterable<T> {
    void add(T elem);
    void remove(int index);
    T get(int index);
    int size();
    int indexOf(T object);
    void set(int index, T object);
}