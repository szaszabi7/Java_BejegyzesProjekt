package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bejegyzes2();

        beker();

        beolvas("bejegyzesek.txt");
        System.out.println(bejegyzesek.toString());
    }

    public static void bejegyzes2() {
        bejegyzesek.add(new Bejegyzes("Józsi","Ez egy bejegyzés"));
        bejegyzesek.add(new Bejegyzes("Feri","Ez egy másik bejegyzés"));
    }

    public static void beker() {
        System.out.print("Adja meg hány db bejegyzést szeretne hozzáadni: ");
        int db = sc.nextInt();
        String[] adat = new String[2];
        for (int i = 0; i < db; i++) {
            System.out.print("\nNév: ");
            adat[0] = sc.next();
            System.out.print("Tartalom: ");
            adat[1] = sc.next();
            bejegyzesek.add(new Bejegyzes(adat[0], adat[1]));
        }
    }

    public static void beolvas(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            String[] adatok;
            while (sor != null) {
                adatok = sor.split(";");
                sor = br.readLine();
                bejegyzesek.add(new Bejegyzes(adatok[0], adatok[1]));
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
