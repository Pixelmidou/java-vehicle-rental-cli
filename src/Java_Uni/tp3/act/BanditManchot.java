package Java_Uni.tp3.act;

import java.util.Scanner;

public class BanditManchot {
    private Roue[] roues = new Roue[4];
    private int[] user = new int[4];
    private final Scanner scanner = new Scanner(System.in);

    public BanditManchot() {
        for (int i = 0; i < roues.length; i++) {
            roues[i] = new Roue();
        }
    }

    private void saisirUser() {
        System.out.println("Saisir quatre entiers entre 1 et 4 :");
        for (int i = 0; i < 4; i++) {
            System.out.printf("Entier %d : ", i + 1);
            int x = scanner.nextInt();
            if (x < 1 || x > 4) {
                throw new IllegalArgumentException("Il faut entre 1 et 4");
            }
            user[i] = x;
        }
    }

    private void lancerRoues() {
        String[] results = new String[roues.length];
        for (int i = 0; i < roues.length; i++) {
            roues[i].lance();
            results[i] = roues[i].get().values().iterator().next();
            System.out.printf("Roue %d : %s%n", (i + 1), results[i]);
        }
    }

    private int calculerOccurence() {
        int kifkif = 0;
        for (int i = 0; i < roues.length; i++) {
            int indexsymb = roues[i].get().keySet().iterator().next();
            if (user[i] == indexsymb) {
                kifkif++;
            }
        }
        return kifkif;
    }

    public int joue() {
        saisirUser();
        lancerRoues();
        int kifkif = calculerOccurence();
        return switch (kifkif) {
            case 2 -> 10;
            case 3 -> 100;
            case 4 -> 1000;
            default -> 0;
        };
    }
}
