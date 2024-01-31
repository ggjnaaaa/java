package hw.hw1;

import java.util.ArrayList;

import hw.hw1.clients.Animal;
import hw.hw1.clients.*;
import hw.hw1.clients.animals.*;
import hw.hw1.workers.Doctor;
import hw.hw1.workers.Nurse;
import hw.hw1.workers.Worker;

/**
 * program
 */
public class program {
    public static void main(String[] args) {

        VeterinaryClinic vetClin = new VeterinaryClinic();
        Generate gen = new Generate();

        ArrayList<Worker> workers = gen.generateWorkers(3, 2, 2);
        ArrayList<Animal> animals = gen.generateAnimals(1, 2, 2, 1, 2);

        //#region лечение всех животных
        System.out.println("---------------------------------- \nЖивотные: \n");
        for (Animal animal : animals) System.out.println(animal);
        System.out.println("---------------------------------- \nРаботники: \n");
        for (Worker worker : workers) System.out.println(worker);

        ArrayList<Doctor> doctors = vetClin.getDoctors(workers);
        ArrayList<Nurse> nurses = vetClin.getNurses(workers);

        System.out.println("---------------------------------- \nЖивотные: \n");
        for (Animal animal : vetClin.goWork(doctors, nurses, animals)) System.out.println(animal);
        //#endregion

        //#region вывод всех бегающих, всех плавающих и всех летающих
        System.out.println("---------------------------------- \nВсе бегающие: \n");
        for (Animal animal : vetClin.getGoAnimals(animals)) System.out.println(animal);

        System.out.println("---------------------------------- \nВсе плавающие: \n");
        for (Animal animal : vetClin.getSwimAnimals(animals)) System.out.println(animal);

        System.out.println("---------------------------------- \nВсе летающие: \n");
        for (Animal animal : vetClin.getFlyAnimals(animals)) System.out.println(animal);
        //#endregion

        Animal an = vetClin.getGoAnimals(animals).get(0);
        if (an instanceof Cat) {
            System.out.println(((Cat)an).swim());
            System.out.println(((Cat)an).run());
        }
    }
}