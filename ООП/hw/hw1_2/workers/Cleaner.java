package hw.hw1_2.workers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cleaner extends Worker {
    public List<String> cleaningAreas;
    public Integer toolKitNumber;

    public Cleaner(LocalDate dateOfBirth, String firstName, String lastName) {
        super(dateOfBirth, firstName, lastName); 
        cleaningAreas = null;
        toolKitNumber = null;
    }

    public Cleaner(String firstName, String lastName) { 
        super(firstName, lastName); 
        cleaningAreas = null;
        toolKitNumber = null;
    }

    public Cleaner(LocalDate dateOfBirth, String firstName, String lastName, ArrayList<String> cleaningAreas, Integer toolKitNumber) {
        super(dateOfBirth, firstName, lastName); 
        this.cleaningAreas = new ArrayList<>(cleaningAreas);
        this.toolKitNumber = toolKitNumber;
    }
    
    public Cleaner(String firstName, String lastName, ArrayList<String> cleaningAreas, Integer toolKitNumber) { 
        super(firstName, lastName); 
        this.cleaningAreas = new ArrayList<>(cleaningAreas);
        this.toolKitNumber = toolKitNumber;
    }

    public void doAGeneralCleaning() {
        
        startCleaning();
        generalCleaning();
        endCleaning();
    }

    public void doAWetCleaning() {
        startCleaning();
        wetCleaning();
        endCleaning();
    }

    public void doADryCleaning() {
        startCleaning();
        dryCleaning();
        endCleaning();
    }

    private void startCleaning() {
        System.out.println("Начало уборки");
    }
    private void wetCleaning() {
        System.out.println("Влажная уборка.");
    }
    private void dryCleaning() {
        System.out.println("Сухая уборка.");
    }
    private void  generalCleaning() {
        System.out.println("Генеральная уборка.");
    }
    private void endCleaning() {
        System.out.println("Начало уборки");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nЗоны уборки = %s \nНабор инструментов = %s\n", cleaningAreas, toolKitNumber);
    }
}
