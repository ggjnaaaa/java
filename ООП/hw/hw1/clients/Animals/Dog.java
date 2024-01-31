package hw.hw1.clients.animals;

import java.time.LocalDate;
import hw.hw1.clients.*;
import hw.hw1.clients.actions.*;

public class Dog extends Animal implements Goable, Swimable {
    public Dog(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness); //Сходи в род.класс и вызови 4 параметра
    }

    public Dog(){
        super();
    }

    @Override
    public double getRunSpeed() {
        return 15.0;
    }

    @Override
    public double getSwimSpeed() {
        return 10.5;
    }

}
