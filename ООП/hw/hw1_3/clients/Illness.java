package hw.hw1_3.clients;

public class Illness {
    String title;
    String medicament;

    public Illness(String title) {
        this.title = title;
        this.medicament = null;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    @Override
    public String toString() {
        return String.format("\n  Диагноз: %s \n  Лекарство: %s", title, medicament);
    }
}
