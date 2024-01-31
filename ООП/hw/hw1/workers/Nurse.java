package hw.hw1.workers;

import java.time.LocalDate;

public class Nurse extends Worker {
    public Doctor doctor;
    private String license;

    public Nurse(LocalDate dateOfBirth, String firstName, String lastName, String license) {
        super(dateOfBirth, firstName, lastName); 
        this.license = license;
        doctor = null;
    }

    public Nurse(String firstName, String lastName, String license) { 
        super(firstName, lastName); 
        this.license = license;
        doctor = null;
    }

    public Nurse(LocalDate dateOfBirth, String firstName, String lastName, String license, Doctor doctor) {
        super(dateOfBirth, firstName, lastName); 
        this.license = license;
        this.doctor = doctor;
    }
    
    public Nurse(String firstName, String lastName, String license, Doctor doctor) { 
        super(firstName, lastName); 
        this.license = license;
        this.doctor = doctor;
    }

    public String getLicense() {
        return license;
    }

    public void workingWithDoctor(Doctor doctor) {
        this.doctor = doctor;
        System.out.println(String.format("Медсестра %s %s работает с врачом %s %s", firstName, lastName, doctor.firstName, doctor.lastName));
    }

    public void stopWorkingWithDoctor() {
        System.out.println(String.format("Медсестра %s %s заканчивает работу с врачом %s %s", firstName, lastName, doctor.firstName, doctor.lastName));
        doctor = null;
    }

    @Override
    public String toString() {
        return "МЕДСЕСТРА" + super.toString() + String.format("\nЛицензия = %s \nВрач = %s\n", license, doctor);
    }

}
