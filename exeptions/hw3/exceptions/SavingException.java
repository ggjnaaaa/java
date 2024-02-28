package hw3.exceptions;

import java.io.IOException;

public class SavingException extends IOException {
    public SavingException(String message) {
        super("Ошибка сохранения. " + message);
    }

    public SavingException() {
        this("");
    }
}
