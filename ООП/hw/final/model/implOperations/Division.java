package model.implOperations;

import java.util.ArrayList;

import model.Convert;
import model.Operation;

public class Division extends Operation {

    public Division() { super(); }

    protected String continueBinaryOperation(ArrayList<Double> list, Integer countComplex) {
        if (list.get(1) == 0) return null;
        else if (list.size() == countComplex) return list.get(0) / list.get(1) + "";
        else if (countComplex == 0) return list.get(0) / list.get(1) + "";
        else return Convert.toComplexString(list.get(0) / list.get(1));
    }
}
