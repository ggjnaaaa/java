package hw3.model.save;

import hw3.exceptions.InputException;
import hw3.exceptions.SavingException;

public interface Saveable {
    public void saving(String data, String fileName) throws SavingException, InputException;
}
