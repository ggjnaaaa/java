package hw.hw1_2.workers;

import java.time.LocalDate;

import hw.hw1_2.clients.Animal;
import hw.hw1_2.clients.Illness;

/**
 * Doctor
 */
public class Doctor extends Nurse {
    public Nurse nurse;
    public Animal animal;

    public Doctor(LocalDate dateOfBirth, String firstName, String lastName, String license, Nurse nurse) {
        super(dateOfBirth, firstName, lastName, license); 
        this.nurse = nurse;
    }
    
    public Doctor(String firstName, String lastName, String license, Nurse nurse) { 
        super(firstName, lastName, license); 
        this.nurse = nurse;
    }

    public Doctor(LocalDate dateOfBirth, String firstName, String lastName, String license) {
        this(dateOfBirth, firstName, lastName, license, null); 
    }

    public Doctor(String firstName, String lastName, String license) { 
        this(firstName, lastName, license, null); 
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
    public void workingWithDoctor(Doctor doctor) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void stopWorkingWithDoctor() {
        throw new UnsupportedOperationException();
    }
}