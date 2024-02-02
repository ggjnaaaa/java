package hw.hw1.drugstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hw.hw1.drugstore.components.*;

public class Drugmain {
     public static void main(String[] args) {
        Component water = new Water("Water", 10D, 1);
        Component azitronite = new Azitronite("Azitronite", 2D, 14);
        Component penicillin = new Penicillin("penicillin", 1.6D, 6);


        Pharmacy p1 = new Pharmacy();
        p1.addComponents(water);

        Pharmacy p2 = new Pharmacy();
        p2.addComponents(penicillin, water, azitronite);

        Pharmacy p3 = new Pharmacy();
        p3.addComponents(azitronite, penicillin);

        List<Pharmacy> pharmacy = new ArrayList<>();

        pharmacy.add(p1);
        pharmacy.add(p2);
        pharmacy.add(p3);

        System.out.println(pharmacy);
        Collections.sort(pharmacy);
        System.out.println(pharmacy);
    }
}
