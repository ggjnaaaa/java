package hw.hw1_2.clients.animals;

import java.time.LocalDate;

import hw.hw1_2.clients.Animal;
import hw.hw1_2.clients.Illness;
import hw.hw1_2.clients.Owner;
import hw.hw1_2.clients.actions.*;

public class Pigeon extends Animal implements Goable, Flyable {
    public Pigeon(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness); //Сходи в род.класс и вызови 4 параметра
    }

    public Pigeon(){
        super();
    }

    @Override
    public double getRunSpeed() {
        return 5.0;
    }

    @Override
    public double getFlySpeed() {
        return 15.0;
    }
}
