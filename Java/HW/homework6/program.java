// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
package HW.homework6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

class PhoneBook {
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNum) {

        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
        }
    }

    public ArrayList<String> find(String name) {
        if (phoneBook.containsKey(name))
            return phoneBook.get(name);
        else return new ArrayList<>();
    }

    public static HashMap<String, ArrayList<String>> getPhoneBook() {
        return phoneBook;
    }

    public void sort(){
        TreeMap<Integer, String> tm = new TreeMap<>();
        for (HashMap.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            ArrayList<String> numbers = entry.getValue();
            tm.put(numbers.size(), name);
        }

        TreeMap<Integer, String> tmDes = new TreeMap<>(tm.reversed());
        for (String name : tmDes.values()){
            System.out.println(name + "=" + phoneBook.get(name));
        }
    }
}

public class program {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        phoneBook.add("Шарова Майя", "198596416");
        phoneBook.add("Шарова Майя", "165165523");
        phoneBook.add("Худяков Тимофей", "948498484");
        phoneBook.add("Худяков Тимофей", "651652165");
        phoneBook.add("Худяков Тимофей", "498464516");
        phoneBook.add("Худяков Тимофей", "865168454");
        phoneBook.add("Блинова Ева", "365416113");
        phoneBook.add("Блинова Ева", "438665132");
        phoneBook.add("Блинова Ева", "386563213");

        System.out.println("Поиск по имени Шарова Майя: " + phoneBook.find("Шарова Майя"));
        System.out.println("Вся телефонная книга: " + PhoneBook.getPhoneBook());
        System.out.println("Поиск по несуществующему имени: " + phoneBook.find(""));
        System.out.println("Вся телефонная книга (отсортирована по убыванию количества телефонов):");
        phoneBook.sort();
    }
}