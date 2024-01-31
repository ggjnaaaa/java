package hw.hw1;

import java.util.ArrayList;

import hw.hw1.clients.Animal;
import hw.hw1.clients.actions.*;
import hw.hw1.workers.*;

public class VeterinaryClinic {
    /*
     * Методы получения:
     * ходящих/летающих/плавающих животных из списка животных
     * врачей/медсестёр/уборщиков из списка рабочих
     */
    public ArrayList<Animal> getGoAnimals(ArrayList<Animal> animals) {
        ArrayList<Animal> goAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Goable)
                goAnimals.add(animals.get(i));

        return goAnimals;
    }

    public ArrayList<Animal> getFlyAnimals(ArrayList<Animal> animals) {
        ArrayList<Animal> flyAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Flyable)
                flyAnimals.add(animals.get(i));

        return flyAnimals;
    }

    public ArrayList<Animal> getSwimAnimals(ArrayList<Animal> animals) {
        ArrayList<Animal> swimAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i) instanceof Swimable)
                swimAnimals.add(animals.get(i));

        return swimAnimals;
    }

    public ArrayList<Doctor> getDoctors(ArrayList<Worker> workers) {
        ArrayList<Doctor> doctors = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i) instanceof Doctor)
                doctors.add((Doctor)workers.get(i));

        return doctors;
    }

    public ArrayList<Nurse> getNurses(ArrayList<Worker> workers) {
        ArrayList<Nurse> nurses = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i) instanceof Nurse)
                nurses.add((Nurse)workers.get(i));

        return nurses;
    }

    public ArrayList<Cleaner> getCleaners(ArrayList<Worker> workers) {
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
    public ArrayList<Animal> goWork(ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, ArrayList<Animal> animals) {
        ArrayList<Animal> animalsWithoutDiagnosis = getAnimalsWithoutDiagnosis(animals);
        ArrayList<Animal> result = new ArrayList<>();

        while (getAnimalsWithoutDiagnosis(animalsWithoutDiagnosis).size() != 0) {
            animalsWithoutDiagnosis = getAnimalsWithoutDiagnosis(animalsWithoutDiagnosis);
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
    private ArrayList<Animal> getAnimalsWithoutDiagnosis(ArrayList<Animal> animals) {
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
