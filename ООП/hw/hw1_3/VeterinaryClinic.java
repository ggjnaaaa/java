package hw.hw1_3;

import java.util.ArrayList;

import hw.hw1_3.clients.Animal;
import hw.hw1_3.clients.actions.*;
import hw.hw1_3.workers.*;

public class VeterinaryClinic {

    private ArrayList<Worker> workers;
    private ArrayList<Animal> animals;

    public VeterinaryClinic() {
        workers = new ArrayList<>();
        animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void addAnimals(ArrayList<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void addWorkers(ArrayList<Worker> workers) {
        this.workers.addAll(workers);
    }

    public void addAnimal(Animal animals) {
        this.animals.add(animals);
    }

    public void addWorker(Worker workers) {
        this.workers.add(workers);
    }

    public void deleteAnimal(String ID) {
        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i).getID() == ID)
            {
                animals.remove(i);
                return;
            }
    }

    public void deleteWorker(String ID) {
        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i).getID() == ID)
            {
                workers.remove(i);
                return;
            }
    }

    /*
     * Методы получения:
     * ходящих/летающих/плавающих животных из списка животных
     * врачей/медсестёр/уборщиков из списка рабочих
     */
    public ArrayList<Animal> getGoAnimals() {
        ArrayList<Animal> goAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Goable)
                goAnimals.add(animals.get(i));

        return goAnimals;
    }

    public ArrayList<Animal> getFlyAnimals() {
        ArrayList<Animal> flyAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Flyable)
                flyAnimals.add(animals.get(i));

        return flyAnimals;
    }

    public ArrayList<Animal> getSwimAnimals() {
        ArrayList<Animal> swimAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Swimable)
                swimAnimals.add(animals.get(i));

        return swimAnimals;
    }

    public ArrayList<Doctor> getDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i) instanceof Doctor)
                doctors.add((Doctor)workers.get(i));

        return doctors;
    }

    public ArrayList<Nurse> getNurses() {
        ArrayList<Nurse> nurses = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i) instanceof Nurse && !(workers.get(i) instanceof Doctor))
                nurses.add((Nurse)workers.get(i));

        return nurses;
    }

    public ArrayList<Cleaner> getCleaners() {
        ArrayList<Cleaner> cleaner = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i) instanceof Cleaner)
                cleaner.add((Cleaner)workers.get(i));

        return cleaner;
    }

    /*
     * Этот метод отправляет всех докторов лечить всех животных без диагноза и ставит к ним медсестёр 
     * Доктор может лечить без медсестры
     * Возвращается список животных с поставленным диагнозом
     */
    public ArrayList<Animal> goWork(ArrayList<Doctor> doctors, ArrayList<Nurse> nurses) {
        ArrayList<Animal> animalsWithoutDiagnosis = getAnimalsWithoutDiagnosis();
        ArrayList<Animal> result = new ArrayList<>();

        while (getAnimalsWithoutDiagnosis().size() != 0) {
            animalsWithoutDiagnosis = getAnimalsWithoutDiagnosis();
            for (int i = 0; i < animalsWithoutDiagnosis.size(); i++) {
                Doctor doc = getFreeDoctor(doctors);
                Nurse nurse = getFreeNurse(nurses);

                if (nurse != null && doc != null) doc.treatAnimal(animalsWithoutDiagnosis.get(i), nurse);
                else if (doc != null) doc.treatAnimal(animalsWithoutDiagnosis.get(i));
            }
        }
            
        return result;
    }

    /*
     * Этот метод возвращает список животных без диагноза
     */
    private ArrayList<Animal> getAnimalsWithoutDiagnosis() {
        ArrayList<Animal> animalsWithoutDiagnosis = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i).getIllness() == null) 
                animalsWithoutDiagnosis.add(animals.get(i));

        return animalsWithoutDiagnosis;
    }

    /*
     * Эти методы возвращают первого доктора/медсестру без работы
     */
    private Doctor getFreeDoctor(ArrayList<Doctor> doctors) {
        for (int i = 0; i < doctors.size(); i++)
            if (doctors.get(i).animal == null) 
                return doctors.get(i);

        return null;
    }

    private Nurse getFreeNurse(ArrayList<Nurse> nurses) {
        for (int i = 0; i < nurses.size(); i++)
            if (nurses.get(i).doctor == null) 
                return nurses.get(i);

        return null;
    }

    
}
