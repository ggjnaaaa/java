package hw3.controller;

import hw3.model.CheckPerson;
import hw3.model.save.Saveable;
import hw3.model.save.impl.TXTsaving;

public class Controller {
    private CheckPerson cp;
    private Saveable saving;

    public Controller() {
        cp = new CheckPerson();
        saving = new TXTsaving();
    }

    public void setPerson(String data) throws Exception {
        saving.saving(data, cp.checking(data));
    } 
}
