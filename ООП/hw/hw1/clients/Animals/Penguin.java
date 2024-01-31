package hw.hw1.clients.animals;

import java.time.LocalDate;

import hw.hw1.clients.*;
import hw.hw1.clients.actions.*;

public class Penguin extends Animal implements Goable, Swimable {
    public Penguin(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness); //Сходи в род.класс и вызови 4 параметра
    }

    public Penguin(){
        super();
    }

    @Override
    public double getRunSpeed() {
        return 5.0;
    }

    @Override
    public double getSwimSpeed() {
        return 15.0;
    }

}
