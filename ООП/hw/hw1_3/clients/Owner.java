package hw.hw1_3.clients;

/**
 * Owner
 */
public class Owner {
    String fullName;

    public Owner(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "\n  Имя: " + fullName;
    }
    
}