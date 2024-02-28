package hw3.exceptions;

import java.io.IOException;

public class InputException extends IOException {
    public InputException(String message) {
        super("Неверный ввод. " + message);
    }

    public InputException() {
        this("");
    }
}
