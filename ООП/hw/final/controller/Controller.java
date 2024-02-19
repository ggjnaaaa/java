package controller;

import model.Operation;
import model.implOperations.*;

public class Controller implements Controllable {
    private Operation operation;

    public String addition(String value1, String value2) {
        if (!(operation instanceof Addition)) operation = new Addition();
        return operation.doBinaryOperation(value1, value2);
    }

    public String subtraction(String value1, String value2) {
        if (!(operation instanceof Subtraction)) operation = new Subtraction();
        return operation.doBinaryOperation(value1, value2);
    }

    public String multiplication(String value1, String value2) {
        if (!(operation instanceof Multiplication)) operation = new Multiplication();
        return operation.doBinaryOperation(value1, value2);
    }

    public String division(String value1, String value2) {
        if (!(operation instanceof Division)) operation = new Division();
        return operation.doBinaryOperation(value1, value2);
    }
}
