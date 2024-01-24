package HW.homework6;

import java.util.ArrayList;
import java.util.HashMap;

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
}

public class program {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        
        myPhoneBook.add("Шарова Майя", "198596416");
        myPhoneBook.add("Шарова Майя", "165165523");
        myPhoneBook.add("Худяков Тимофей", "948498484");
        myPhoneBook.add("Худяков Тимофей", "651652165");
        myPhoneBook.add("Худяков Тимофей", "498464516");
        myPhoneBook.add("Худяков Тимофей", "865168454");
        myPhoneBook.add("Блинова Ева", "365416113");
        myPhoneBook.add("Блинова Ева", "438665132");
        myPhoneBook.add("Блинова Ева", "386563213");

        System.out.println("Поиск по имени Шарова Майя: " + myPhoneBook.find("Шарова Майя"));
        System.out.println("Вся телефонная книга: " + PhoneBook.getPhoneBook());
        System.out.println("Поиск по несуществующему имени: " + myPhoneBook.find(""));
    }
}