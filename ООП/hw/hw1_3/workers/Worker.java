package hw.hw1_3.workers;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Worker {
    private LocalDate dateOfBirth;
    private String ID;
    protected String firstName;
    protected String lastName;
    
    public Worker(LocalDate dateOfBirth, String firstName, String lastName){
        this.dateOfBirth = dateOfBirth;
        this.ID = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Worker(String firstName, String lastName){
        this.dateOfBirth = null;
        this.ID = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return String.format("%s \nID = %s \nИмя = %s \nФамилия = %s \nДата рождения = %s",
         getType(), getID(), firstName, lastName, getDateOfBirth());
    }
}