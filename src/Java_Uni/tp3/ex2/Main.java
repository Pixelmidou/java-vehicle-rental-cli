package Java_Uni.tp3.ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Employe> employes = new ArrayList<>();
        String input = "";
        while (!input.equalsIgnoreCase("no")) {
            System.out.print("matricule : ");
            String matricule = scanner.nextLine();
            System.out.print("nom : ");
            String nom = scanner.nextLine();
            System.out.print("prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("naissance : ");
            int annnes = scanner.nextInt();
            scanner.nextLine();
            System.out.print("embauche : ");
            int annemb = scanner.nextInt();
            scanner.nextLine();
            System.out.print("salaire : ");
            double salaire = scanner.nextDouble();
            scanner.nextLine();

            employes.add(new Employe(matricule,nom,prenom,annnes,annemb,salaire));

            System.out.print("continue yes or no : ");
            input = scanner.nextLine();
        }

        Employe.getNbemp();

        scanner.close();
    }
}
