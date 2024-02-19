package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.Controllable;
import controller.Controller;
import controller.LoggerController;

public class UserView {
    private static Map<Character, CallOperations> operationsMap = new HashMap<>();
    private Controllable controller;
    private Scanner scanner;

    static {
        operationsMap.put('+', (controller, value1, value2) -> controller.addition(value1, value2));
        operationsMap.put('-', (controller, value1, value2) -> controller.subtraction(value1, value2));
        operationsMap.put('*', (controller, value1, value2) -> controller.multiplication(value1, value2));
        operationsMap.put('/', (controller, value1, value2) -> controller.division(value1, value2));
    }

    public UserView() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        setController();
        String value1;
        String value2;
        Character character;
        while (true) {
            System.out.printf("First number: ");
            value1 = scanner.nextLine();

            System.out.printf("Operation: ");
            character = getUpperCharFromConsole();

            System.out.printf("Second number: ");
            value2 = scanner.nextLine();

            try { 
                String result = operationsMap.get(character).Operation(controller, value1, value2);
                if (result != null) System.out.println(result);
            }
            catch (NullPointerException e) { System.out.println("Неверный ввод."); }

            System.out.println("Continue? Y/N");
            if (getUpperCharFromConsole() == 'N') return;
        }
    }

    private void setController() {
        while (controller == null) {
            System.out.println("Select the operating mode");
            System.out.println("L - logger mode.");
            System.out.println("D - default mode.");
            Character result = getUpperCharFromConsole();
            
            if (result == null) continue;
            else if (result == 'L') controller = new LoggerController();
            else if (result == 'D') controller = new Controller();
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
