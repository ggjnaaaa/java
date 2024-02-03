package hw.hw1_3.clients.animals;

import java.time.LocalDate;
import hw.hw1_3.clients.*;
import hw.hw1_3.clients.actions.*;

public class Cat extends Animal implements Goable, Swimable {
    //Todo напомнить в чём разница в double
    Double discount;

    public Cat(String nickName, Owner owner, LocalDate birthDate, Illness illness, Double discount) {
        super(nickName, owner, birthDate, illness); //Todo сначала конструктор Супер-класса
        this.discount = discount;
    }

    public Cat() {
        super();
        this.discount = 10D;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    //Todo статикой пользоваться аккуратно ( пароли там не хранить :-) )
    public static void meow(){
        System.out.println("Мяяяу!");
    }

    @Override
    public String toString() {
        return super.toString() + "Discount: " + discount + "\n";
    }

    @Override
    public double getRunSpeed() {
        return 10.0;
    }

    @Override
    public double getSwimSpeed() {
        return 5.0;
    }
}
