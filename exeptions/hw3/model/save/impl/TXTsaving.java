package hw3.model.save.impl;

import hw3.exceptions.InputException;
import hw3.exceptions.SavingException;
import hw3.model.save.Saveable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TXTsaving implements Saveable {
    private String dbStringPath = "hw3/db";

    @Override
    public void saving(String data, String fileName) throws SavingException, InputException {
        fileName = dbStringPath + "/" + fileName + ".txt";
        try { new File(fileName).createNewFile(); } catch (IOException e) {throw new InputException("Фамилия записана неверно и не может использоваться для имени файла."
                                                                                                    + "\nПроверьте ввод, имя должно быть написано латиницей без дополнительных символов.");}
        
        ArrayList<String> dataList = readFile(fileName);
        dataList.add(data);
        writeFile(fileName, dataList);
    }

    private ArrayList<String> readFile(String fileName) throws SavingException{ 
        ArrayList<String> dataList = new ArrayList<>();

        try (FileReader fr = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fr);) {
            String line = reader.readLine();
            while (line != null) {
                dataList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new SavingException(e.getMessage());
        }

        return dataList;
    }

    private void writeFile(String fileName, ArrayList<String> dataList) throws SavingException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : dataList) {
                writer.write(line);
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            throw new SavingException(e.getMessage());
        }
    }
}
