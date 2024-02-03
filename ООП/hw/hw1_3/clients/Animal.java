package hw.hw1_3.clients;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Animal {
    // protected видно в классе и во всех наследниках
    protected String nickName;
    protected Owner owner;
    protected LocalDate birthDate;
    protected Illness illness;
    private String ID;

    // Это пустой конструктор (по умолчанию)
    public Animal(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        this.nickName = nickName;
        this.owner = owner;
        this.birthDate = birthDate;
        this.illness = illness;
        this.ID = UUID.randomUUID().toString();
    }

    public Animal() {
        this("Кличка", new Owner("Хозяин"), LocalDate.now(), new Illness("Болеет"));
    }

    public String getNickName() {
        return nickName;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public String getID() {
        return ID;
    }

    public void lifeCycle() {
        wakeUp("12:00");
        hunt();
        eat();
        sleep();
    }

    private void wakeUp(String time) {
        System.out.println("Животное " + nickName + " проснулось в " + time);
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    private void hunt() {
        System.out.println("Животное охотится!");
    }
    private void eat() {
        System.out.println("Животное ест!");
    }
    private void sleep() {
        System.out.println("Животное уснуло!");
    }

    @Override
    public String toString() {
        return String.format("Имя = %s \nДень рождения = %s \nХозяин = %s \nЗаболевание = %s \n", nickName, birthDate, owner, illness);
    }
}
