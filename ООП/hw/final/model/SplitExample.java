package model;

import java.util.ArrayList;

public class SplitExample {
    public ArrayList<Double> getNumbers(String[] example) {
        ArrayList<Double> list = new ArrayList<>();
        try {
            for (int i = 0; i < example.length; i++)
                if (isComplex(example[i]))
                    list.add(Double.parseDouble(example[i].replace("i", "")));
                else
                    list.add(Double.parseDouble(example[i]));
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод.");
            return null;
        }
        return list;
    }

    public Integer getCountOfComplex(String[] example) {
        Integer count = 0;
        for (int i = 0; i < example.length; i++)
            if (isComplex(example[i]))
                count++;
        return count;
    }

    public Boolean isComplex(String example) {
        return example.indexOf("i") > -1;
    }
}
