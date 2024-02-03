package hw.hw1_2.clients.animals;

import java.time.LocalDate;

import hw.hw1_2.clients.*;
import hw.hw1_2.clients.actions.*;

public class Duck extends Animal implements Goable, Swimable, Flyable {
    public Duck(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness); //Сходи в род.класс и вызови 4 параметра
    }

    public Duck(){
        super();
    }

    @Override
    public double getRunSpeed() {
        return 3.0;
    }

    @Override
    public double getSwimSpeed() {
        return 5.0;
    }

    @Override
    public double getFlySpeed() {
        return 10.0;
    }
}
