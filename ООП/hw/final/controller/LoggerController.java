package controller;

public class LoggerController implements Controllable {
    private Controllable controller;

    public LoggerController() {
        controller = new Controller();
    }

    public String addition(String value1, String value2) {
        String result = controller.addition(value1, value2);
        if (result != null) System.out.printf("%s + %s = ", value1, value2);
        return result;
    }

    public String subtraction(String value1, String value2) {
        String result = controller.addition(value1, value2);
        if (result != null) System.out.printf("%s - %s = ", value1, value2);
        return result;
    }

    public String multiplication(String value1, String value2) {
        String result = controller.addition(value1, value2);
        if (result != null) System.out.printf("%s * %s = ", value1, value2);
        return result;
    }

    public String division(String value1, String value2) {
        String result = controller.addition(value1, value2);
        if (result != null) System.out.printf("%s / %s = ", value1, value2);
        return result;
    }
}
