package hw.hw1_3.workers;

import java.time.LocalDate;

import hw.hw1_3.clients.Animal;

public abstract class BasicMedicalWorker extends Worker {
    private String license;

    public BasicMedicalWorker(LocalDate dateOfBirth, String firstName, String lastName, String license) {
        super(dateOfBirth, firstName, lastName); 
        this.license = license;
    }

    public BasicMedicalWorker(String firstName, String lastName, String license) { 
        super(firstName, lastName); 
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void injection(Animal animal) {
        System.out.println(String.format("Животному %s (%s) сделал укол %s %s", animal.getNickName(), animal.getID(), firstName, lastName));
    }

    @Override
    public String toString() {
        return super.toString() + "\nЛицензия = " + license;
    }
}
