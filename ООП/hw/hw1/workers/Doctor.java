package hw.hw1.workers;

import java.time.LocalDate;

import hw.hw1.clients.Animal;
import hw.hw1.clients.Illness;

/**
 * Doctor
 */
public class Doctor extends Worker {
    public Nurse nurse;
    public Animal animal;
    private String license;

    public Doctor(LocalDate dateOfBirth, String firstName, String lastName, String license) {
        super(dateOfBirth, firstName, lastName); 
        this.license = license;
        nurse = null;
    }

    public Doctor(String firstName, String lastName, String license) { 
        super(firstName, lastName); 
        this.license = license;
        nurse = null;
    }

    public Doctor(LocalDate dateOfBirth, String firstName, String lastName, String license, Nurse nurse) {
        super(dateOfBirth, firstName, lastName); 
        this.license = license;
        this.nurse = nurse;
    }
    
    public Doctor(String firstName, String lastName, String license, Nurse nurse) { 
        super(firstName, lastName); 
        this.license = license;
        this.nurse = nurse;
    }

    public String getLicense() {
        return license;
    }

    public boolean treatAnimal(Animal animal) {
        if (this.animal != null) return false;
        else {
            checkAnimal(animal);
            formingDiagnosis(animal);
            prescribingMedicines(animal);

            return true;
        }
    }

    public boolean treatAnimal(Animal animal, Nurse nurse) {
        if (nurse.doctor != null || this.animal != null) return false;
        else {
            this.nurse = nurse;
            nurse.workingWithDoctor(this);
            treatAnimal(animal);
            nurse.stopWorkingWithDoctor();
            this.nurse = null;

            return true;
        }
    }

    private void checkAnimal(Animal animal) {
        System.out.println(String.format("Животное %s на осмотре у врача %s %s.", animal.getNickName(), firstName, lastName));
    }
    private void formingDiagnosis(Animal animal) {
        System.out.println(String.format("Животному %s поставлен диагноз врачом %s %s.", animal.getNickName(), firstName, lastName));
        animal.setIllness(new Illness("Новый диагноз."));
    }
    private void prescribingMedicines(Animal animal) {
        System.out.println(String.format("Животному %s выписано лекарство врачом %s %s.", animal.getNickName(), firstName, lastName));
        animal.getIllness().setMedicament("Новые лекарства.");
    }

    @Override
    public String toString() {
        return "ДОКТОР" + super.toString() + String.format("\nЛицензия = %s \nМедсестра = %s\n", license, nurse);
    }

    
}