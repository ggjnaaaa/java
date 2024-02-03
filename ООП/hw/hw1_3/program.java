package hw.hw1_3;

import java.util.ArrayList;

import hw.hw1_3.clients.Animal;
import hw.hw1_3.clients.animals.*;
import hw.hw1_3.workers.*;


/**
 * program
 */
public class program {
    public static void main(String[] args) {

        Doctor doc1 = new Doctor("Doc1", "Doc1", "bvu");
        Doctor doc2 = new Doctor("Doc2", "Doc2", "bvu");
        doc1.workingWithDoctor(doc2);
        doc1.stopWorkingWithDoctor();

        /*VeterinaryClinic vetClin = new VeterinaryClinic();
        Generate gen = new Generate();

        vetClin.addWorkers(gen.generateWorkers(3, 2, 2));
        vetClin.addAnimals(gen.generateAnimals(1, 2, 2, 1, 2));

        //#region лечение всех животных
        System.out.println("---------------------------------- \nЖивотные: \n");
        for (Animal animal : vetClin.getAnimals()) System.out.println(animal);
        System.out.println("---------------------------------- \nРаботники: \n");
        for (Worker worker : vetClin.getWorkers()) System.out.println(worker);

        ArrayList<Doctor> doctors = vetClin.getDoctors();
        ArrayList<Nurse> nurses = vetClin.getNurses();

        System.out.println("---------------------------------- \nЖивотные: \n");
        for (Animal animal : vetClin.goWork(doctors, nurses)) System.out.println(animal);
        //#endregion

        //#region вывод всех бегающих, всех плавающих и всех летающих
        System.out.println("---------------------------------- \nВсе бегающие: \n");
        for (Animal animal : vetClin.getGoAnimals()) System.out.println(animal);

        System.out.println("---------------------------------- \nВсе плавающие: \n");
        for (Animal animal : vetClin.getSwimAnimals()) System.out.println(animal);

        System.out.println("---------------------------------- \nВсе летающие: \n");
        for (Animal animal : vetClin.getFlyAnimals()) System.out.println(animal);
        //#endregion

        Animal an = vetClin.getGoAnimals().get(0);
        if (an instanceof Cat) {
            System.out.println(((Cat)an).swim());
            System.out.println(((Cat)an).run());
        }*/
    }
}