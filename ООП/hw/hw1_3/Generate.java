package hw.hw1_3;

import java.time.LocalDate;
import java.util.ArrayList;

import hw.hw1_3.clients.Animal;
import hw.hw1_3.clients.*;
import hw.hw1_3.clients.animals.*;
import hw.hw1_3.workers.*;


public class Generate {
    //#region генераторы рабочих
    public ArrayList<Worker> generateWorkers(Integer docCount, Integer nurseCount, Integer cleanerCount) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.addAll(generateDoctors(docCount));
        workers.addAll(generateNurses(nurseCount));
        workers.addAll(generateCleaners(cleanerCount));

        return workers;
    }

    public ArrayList<Doctor> generateDoctors(Integer docCount) {
        ArrayList<Doctor> workers = new ArrayList<>();
        for (int i = 0; i < docCount; i++) {
            Doctor doc = new Doctor("Доктор" + i + "_имя", "Доктор" + i + "_фамилия", "Доктор" + i + "_лицензия");
            workers.add(doc);
        }
        return workers;
    }

    public ArrayList<Nurse> generateNurses(Integer nurseCount) {
        ArrayList<Nurse> workers = new ArrayList<>();
        for (int i = 0; i < nurseCount; i++) {
            Nurse nurse = new Nurse("Медсестра" + i + "_имя", "Медсестра" + i + "_фамилия", "Медсестра" + i + "_лицензия");
            workers.add(nurse);
        }
        return workers;
    }

    public ArrayList<Cleaner> generateCleaners(Integer cleanerCount) {
        ArrayList<Cleaner> workers = new ArrayList<>();
        for (int i = 0; i < cleanerCount; i++) {
            Cleaner cleaner = new Cleaner("Уборщик" + i + "_имя", "Уборщик" + i + "_фамилия");
            workers.add(cleaner);
        }
        return workers;
    }
    //#endregion

    //#region генераторы животных
    public ArrayList<Animal> generateAnimals(Integer catCount, Integer dogCount, Integer duckCount, Integer penguinCount, Integer pigeonCount) {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.addAll(generateCats(catCount));
        animals.addAll(generateDogs(dogCount));
        animals.addAll(generateDucks(duckCount));
        animals.addAll(generatePenguins(penguinCount));
        animals.addAll(generatePigeons(pigeonCount));

        return animals;
    }

    public ArrayList<Cat> generateCats(Integer catCount) {
        ArrayList<Cat> animals = new ArrayList<>();
        for (int i = 0; i < catCount; i++) {
            Cat cat = new Cat("Кот" + i, new Owner("Хозяин" + i), LocalDate.now(), null, 10D);
            animals.add(cat);
        }
        return animals;
    }

    public ArrayList<Dog> generateDogs(Integer dogCount) {
        ArrayList<Dog> animals = new ArrayList<>();
        for (int i = 0; i < dogCount; i++) {
            Dog dog = new Dog("Собака" + i, new Owner("Хозяин" + i), LocalDate.now(), null);
            animals.add(dog);
        }
        return animals;
    }

    public ArrayList<Duck> generateDucks(Integer duckCount) {
        ArrayList<Duck> animals = new ArrayList<>();
        for (int i = 0; i < duckCount; i++) {
            Duck duck = new Duck("Утка" + i, new Owner("Хозяин" + i), LocalDate.now(), null);
            animals.add(duck);
        }
        return animals;
    }

    public ArrayList<Penguin> generatePenguins(Integer penguinCount) {
        ArrayList<Penguin> animals = new ArrayList<>();
        for (int i = 0; i < penguinCount; i++) {
            Penguin penguin = new Penguin("Пингвин" + i, new Owner("Хозяин" + i), LocalDate.now(), null);
            animals.add(penguin);
        }
        return animals;
    }

    public ArrayList<Pigeon> generatePigeons(Integer pigeonCount) {
        ArrayList<Pigeon> animals = new ArrayList<>();
        for (int i = 0; i < pigeonCount; i++) {
            Pigeon pigeon = new Pigeon("Голубь" + i, new Owner("Хозяин" + i), LocalDate.now(), null);
            animals.add(pigeon);
        }
        return animals;
    }
    //#endregion
}
