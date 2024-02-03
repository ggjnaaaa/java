package hw.hw1_3.workers;

import java.time.LocalDate;

public class Nurse extends BasicMedicalWorker {
    public Doctor doctor;

    public Nurse(LocalDate dateOfBirth, String firstName, String lastName, String license, Doctor doctor) {
        super(dateOfBirth, firstName, lastName, license); 
        this.doctor = doctor;
    }
    
    public Nurse(String firstName, String lastName, String license, Doctor doctor) { 
        super(firstName, lastName, license); 
        this.doctor = doctor;
    }

    public Nurse(LocalDate dateOfBirth, String firstName, String lastName, String license) {
        this(dateOfBirth, firstName, lastName, license, null); 
    }

    public Nurse(String firstName, String lastName, String license) { 
        this(firstName, lastName, license, null); 
    }

    public void workingWithDoctor(Doctor doctor) {
        if (getType() != "Doctor")
        {
            this.doctor = doctor;
        System.out.println(String.format("Медсестра %s %s работает с врачом %s %s", firstName, lastName, doctor.firstName, doctor.lastName));
        }
        
    }

    public void stopWorkingWithDoctor() {
        System.out.println(String.format("Медсестра %s %s заканчивает работу с врачом %s %s", firstName, lastName, doctor.firstName, doctor.lastName));
        doctor = null;
    }

    @Override
    public String toString() {
        return super.toString() + "\nДоктор = %s\n" + doctor;
    }

}
