package Projet_LocationVehicule.main;

import Projet_LocationVehicule.model.*;
import Projet_LocationVehicule.service.AgenceLocation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuClient {
    static void afficherMenu() {
        System.out.println("1. Consulter Vehicule disponible");
        System.out.println("2. Louer un vehicule");
        System.out.println("3. Restituer un vehicule");
        System.out.println("4. Sauvegarder mes données");
        System.out.println("0. Afficher Parc");
    }

    static void fonctionalitesClient(AgenceLocation a1, int choixclient, Scanner scanner, Client clientConnecte) throws LocationException {
        switch (choixclient) {
            case 1:
                ArrayList<Vehicule> vehparc = a1.getParc();
                for (Vehicule vehicule : vehparc) {
                    if (vehicule.isDisponible()) {
                        System.out.println(vehicule);
                    }
                }
                break;
            case 2:
                System.out.print("saisir reference vehicule : ");
                scanner.nextLine();
                String idveh = scanner.nextLine();
                System.out.print("date debut (YYYY-MM-DD) : ");
                LocalDate debut = LocalDate.parse(scanner.nextLine());
                System.out.print("date fin (YYYY-MM-DD) : ");
                LocalDate fin = LocalDate.parse(scanner.nextLine());
                a1.louer(clientConnecte, idveh, debut, fin);
                break;
            case 3:
                System.out.print("saisir reference vehicule : ");
                scanner.nextLine();
                String idveh1 = scanner.nextLine();

                boolean retour = false;
                for (Location location : a1.getLocationsActives()) {
                    if (location.getVehicule().getReference().equalsIgnoreCase(idveh1) &&
                            location.getClient().getIdClient().equals(clientConnecte.getIdClient())) {
                        retour = true;
                        break;
                    }
                }

                if (!retour) {
                    throw new LocationException("vous ne posseder pas cet vehicule");
                }

                a1.restituer(idveh1);
                break;
            case 4:
                a1.sauvegarderDonnees();
                break;
            case 0:
                break;
            default:
                System.out.println("choix erreur");
                break;
        }
    }
}