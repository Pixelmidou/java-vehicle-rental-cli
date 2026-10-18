package Java_Uni.Projet.main;

import model.Administrateur;
import model.Client;
import model.LocationException;
import service.AgenceLocation;

import java.util.Scanner;

public class AppLocation {
    public static void main(String[] args) throws LocationException {
        Scanner scanner = new Scanner(System.in);

        int choix = 99;
        AgenceLocation ag1 = new AgenceLocation();

        System.out.println("chargement donnes :");
        ag1.chargerDonnees();

        while (choix != 0) {

            System.out.println("1. Espace Administrateur\n2. Espace Client\n0. Quitter");
            System.out.print("choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    String login = "admin";
                    String mdp = "admin@*1234";
                    Administrateur a1 = new Administrateur(login,mdp);
                    if (!a1.authentifier(login,mdp)) System.out.println("coordonné erreur");
                    int choixadmin = 99;
                    while (choixadmin != 0) {
                        MenuAdmin.afficherMenu();
                        System.out.print("choix : ");
                        choixadmin = scanner.nextInt();
                        MenuAdmin.fonctionalitesAdmin(ag1,choixadmin, scanner);
                    }
                    break;
                case 2:
                    System.out.print("saisir idclient : ");
                    scanner.nextLine();
                    String idclient = scanner.nextLine();
                    Client clientConnecte = ag1.trouverClientParId(idclient);
                    if (clientConnecte == null) {
                        System.out.println("client inexistant");
                        break;
                    }
                    int choixclient = 99;
                    while (choixclient != 0) {
                        MenuClient.afficherMenu();
                        System.out.print("choix : ");
                        choixclient = scanner.nextInt();
                        MenuClient.fonctionalitesClient(ag1, choixclient, scanner, clientConnecte);
                    }
                    break;
                case 0:
                    System.out.println("Sauvegarde des donees");
                    ag1.sauvegarderDonnees();
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix erreur");
            }
        }

        scanner.close();
    }
}