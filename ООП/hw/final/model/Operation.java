package model;

import java.util.ArrayList;

public abstract class Operation {
    protected SplitExample split;

    public Operation() {
        split = new SplitExample();
    }

    public String doBinaryOperation(String value1, String value2) {
        ArrayList<Double> list = split.getNumbers(new String[]{value1, value2});
        Integer countComplex = split.getCountOfComplex(new String[]{value1, value2});

        if (list == null) return null;
        return continueBinaryOperation(list, countComplex);
    }

    protected abstract String continueBinaryOperation(ArrayList<Double> list, Integer countComplex);
}
