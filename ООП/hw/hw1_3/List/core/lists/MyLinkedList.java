package hw.hw1_3.List.core.lists;

import java.util.*;

import hw.hw1_3.List.core.MyList;
import hw.hw1_3.List.core.util.LinkedIterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(this);
    }

    @Override
    public void add(T elem) {
        if (head == null) {  // Если нет первого элемента
            head = new Node<T>(elem, null);
            size++;
            return;
        }

        Node<T> current = head;
        while (current.next != null) current = current.next;  // Поиск последнего элемента
        current.next = new Node<T>(elem, current);
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();  // Индекс вне границ массива
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index && currentNode != null) {  // Поиск элемента с нужным индексом
            currentIndex++;
            currentNode = currentNode.next;
        }
        
        if (currentNode.next == null) currentNode.prev.next = currentNode.next;  // Если элемент последний
        else if (currentNode.prev == null) {  // Если элемент первый
            currentNode.next.prev = null;
            head = currentNode.next;
        }
        else {
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
        }

        size--;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();  // Индекс вне границ массива
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index) {  // Поиск элемента с нужным индексом
            currentIndex++;
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T object) {
        if (size == 0 ) return -1;  // Если элементов нет вернёт -1

        int currentIndex = 0;
        Node<T> currentNode = head;

        if (currentNode.value == object) return currentIndex;
        while (currentIndex < size-1) {  // Перебор до нужного элемента
            currentIndex++;
            currentNode = currentNode.next;
            if (currentNode.value == object) return currentIndex;
        }
        return -1;  // Если элемента нет вернётся -1
    }

    @Override
    public void set(int index, T object) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();  // Индекс вне границ массива
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index) {  // Поиск элемента с нужным индексом
            currentIndex++;
            currentNode = currentNode.next;
        }

        currentNode.value = object;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        while (current.next != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        if (builder.length() == 1)
            return "[]";
        builder.append(current.value);
        builder.append("]");
        return builder.toString();
    }

    private static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node(T value, Node<T> prev) {
            this.value = value;
            this.prev = prev;
            next = null;
        }

        @Override
        public String toString() {
            return "Значение: " + value;
        }
    }
    
}
