package hw.hw1.clients.Animals;

import java.time.LocalDate;
import hw.hw1.clients.*;

public class Dog extends Animal {
    public Dog(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness); //Сходи в род.класс и вызови 4 параметра
    }

    public Dog(){
        super();
    }

    @Override
    public void fly() { }
}
