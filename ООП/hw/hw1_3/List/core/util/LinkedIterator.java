package hw.hw1_3.List.core.util;

import java.util.Iterator;

import hw.hw1_3.List.core.lists.MyLinkedList;

public class LinkedIterator<T> implements Iterator<T> {
    private MyLinkedList<T> values;
    private int index;

    public LinkedIterator(MyLinkedList<T> values) {
        this.values = values;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < values.size();
    }

    @Override
    public T next() {
        return values.get(index++);
    }
}
