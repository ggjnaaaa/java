package hw3.view;

import java.util.Scanner;
import hw3.controller.Controller;

public class UserView {
    private Controller controller;
    private Scanner scanner;

    public UserView() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nВведите данные в формате {Фамилия Имя Отчество дата_рождения номер_телефона пол} латиницей"
                                + "\nДата рождения в формате  dd.mm.yyyy"
                                + "\nНомер телефона без пробела"
                                + "\nПол - символ латиницей f (женщина) или m (мужчина)\n");

            try { 
                controller.setPerson(scanner.nextLine());
            }
            catch (Exception e) { System.out.println(e.getMessage()); }

            System.out.println("Continue? Y/N");
            if (getUpperCharFromConsole() == 'N') return;
        }
    }

    private Character getUpperCharFromConsole() {
        try {
            return scanner.nextLine()
                        .replace(" ", "")
                        .toUpperCase()
                        .toCharArray()[0];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверный ввод.");
            return null;
        }
    }

}
