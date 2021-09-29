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

        randomLike();

        modosit();

        for (Bejegyzes bejegyzes : bejegyzesek) {
            System.out.println(bejegyzes.toString());
        }

        System.out.println("Legtöbb like: " + legnepszerubb());

        tobbMint35();

        System.out.println("15-nél kevesebb likeot kapó bejegyzésel száma: "+ kevesebbMint15());
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

    public static void randomLike() {
        Random rnd = new Random();
        int szor20 = (bejegyzesek.size() * 20);
        for (int i = 0; i < szor20; i++) {
            bejegyzesek.get(rnd.nextInt(bejegyzesek.size())).like();
        }
    }

    public static void modosit() {
        System.out.print("Módosítsa a második bejegyzést: ");
        String edit = sc.next();
        bejegyzesek.get(1).setTartalom(edit);
    }

    public static int legnepszerubb() {
        int max = bejegyzesek.get(0).getLikeok();
        for (int i = 1; i < bejegyzesek.size(); i++) {
            if (max < bejegyzesek.get(i).getLikeok()) {
                max = bejegyzesek.get(i).getLikeok();
            }
        }
        return max;
    }

    public static void tobbMint35() {
        boolean van = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35) van = true;
        }
        if (van) System.out.println("Van olyan bejegyzés ami 35 likenál többet kapott");
        else System.out.println("Nincs olyan bejegyzés ami 35 likenál többet kapott");
    }

    public static int kevesebbMint15() {
        int darab = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() < 15) darab++;
        }
        return darab;
    }

    public static void rendez() {
        int temp = bejegyzesek.get(0).getLikeok();

    }
}
