package hw.hw1;

import java.time.LocalDate;
import java.util.ArrayList;

import hw.hw1.clients.Animal;
import hw.hw1.clients.Illness;
import hw.hw1.clients.Owner;
import hw.hw1.clients.Animals.*;

/**
 * program
 */
public class program {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        Cat cat = new Cat("кот", new Owner("хозяин"), LocalDate.now(), new Illness("болезнь"), 10D);
        animals.add(cat);

        Dog dog = new Dog("собака", new Owner("хозяин"), LocalDate.now(), new Illness("болезнь"));
        animals.add(dog);

        Duck duck = new Duck("утка", new Owner("хозяин"), LocalDate.now(), new Illness("болезнь"));
        animals.add(duck);

        Penguin penguin = new Penguin("пингвин", new Owner("хозяин"), LocalDate.now(), new Illness("болезнь"));
        animals.add(penguin);


        for (Animal animal : animals) {
            System.out.println(String.format("Животное: %s ", animal));

            System.out.println("Ходит: ");
            animal.toGo();
            System.out.println("Плавает: ");
            animal.swim();
            System.out.println("Летает: ");
            animal.fly();
            System.out.println("-------------------------- \n");
        }
    }
}