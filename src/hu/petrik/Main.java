package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void main(String[] args) {
        bejegyzesek.add(new Bejegyzes("Józsi","Ez egy bejegyzés"));
        bejegyzesek.add(new Bejegyzes("Feri","Ez egy másik bejegyzés"));

        System.out.println(bejegyzesek.toString());

    }
}
