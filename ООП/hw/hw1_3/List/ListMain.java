package hw.hw1_3.List;

import java.util.Iterator;

import hw.hw1_3.List.core.MyList;
import hw.hw1_3.List.core.lists.*;

public class ListMain {
    public static void main(String[] args) {
        MyList<Integer> mList = new MyLinkedList<>();

        System.out.println("Добавлены элементы:");
        mList.add(3);
        mList.add(5);
        mList.add(6);
        System.out.println(mList);
        System.out.println("\nРазмер:");
        System.out.println(mList.size());

        System.out.println("\nУдалён элемент с индексом 2:");
        mList.remove(2);
        System.out.println(mList);
        System.out.println("Размер: " + mList.size());

        System.out.println("\nПоиск индекса значения (ищет первый элемент, если элемента нет возвращается -1):");
        System.out.println("Результат поиска 5: " + mList.indexOf(5));
        System.out.println("Результат поиска 10: " + mList.indexOf(10));
        System.out.println("Результат поиска 3: " + mList.indexOf(3));

        // Приводит к вызову ошибки:
       // System.out.println(mList.get(-1));
       // System.out.println(mList.get(5));

        System.out.println("\nВывод значения по индексу:");
        System.out.println(mList.get(0));

        System.out.println("\nИзменение значения по индексу:");
        System.out.println(mList);
        mList.set(0, 20);
        System.out.println(mList);

        System.out.println("\nИтератор:");
        Iterator<Integer> iter = mList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
