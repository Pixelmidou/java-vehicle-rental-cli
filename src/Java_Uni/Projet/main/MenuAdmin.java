package Java_Uni.Projet.main;

import model.*;
import service.AgenceLocation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    static public void afficherMenu() {
        System.out.println("1. Ajouter Vehicule");
        System.out.println("2. Supprimer Vehicule");
        System.out.println("3. Modifier prix vehicule");
        System.out.println("4. Afficher Parc");
        System.out.println("5. Ajouter Client");
        System.out.println("6. Afficher Clients");
        System.out.println("7. Louer un vehicule");
        System.out.println("8. Afficher Locations actives");
        System.out.println("9. Restituer un vehicule");
        System.out.println("10. Sauvegarder données");
        System.out.println("11. Charger données");
        System.out.println("0. Retour Menu principal");
    }

    static public void fonctionalitesAdmin(AgenceLocation a1,int choixadmin, Scanner scanner) throws LocationException {
        switch (choixadmin) {
            case 1:
                Vehicule vehicule;
                scanner.nextLine();
                System.out.print("voiture ou moto (v/m) : ");
                String choixveh = scanner.nextLine();
                System.out.print("saisir marque : ");
                String marque = scanner.nextLine();
                System.out.print("saisir model : ");
                String model = scanner.nextLine();
                System.out.print("saisir prix : ");
                double prix = scanner.nextDouble();
                if (choixveh.trim().equalsIgnoreCase("v")) {
                    System.out.print("saisir nbportes : ");
                    int nbportes = scanner.nextInt();
                    vehicule = new Voiture(marque,model,prix,true,nbportes);
                    a1.ajouterVehicule(vehicule);
                } else {
                    System.out.print("saisir cylindre : ");
                    int cylindre = scanner.nextInt();
                    vehicule = new Moto(marque,model,prix,true,cylindre);
                    a1.ajouterVehicule(vehicule);
                }
                break;
            case 2:
                System.out.print("reference voiture : ");
                scanner.nextLine();
                String reference1 = scanner.nextLine();
                a1.supprimerVehicule(reference1);
                break;
            case 3:
                System.out.print("reference voiture : ");
                scanner.nextLine();
                String reference2 = scanner.nextLine();
                System.out.print("nouveau prix : ");
                double prix1 = scanner.nextDouble();
                a1.modifierPrix(reference2,prix1);
                break;
            case 4:
                ArrayList<Vehicule> vehparc = a1.getParc();
                System.out.println(vehparc);
                break;
            case 5:
                System.out.print("nom : ");
                scanner.nextLine();
                String nom = scanner.nextLine();
                System.out.print("prenom : ");
                String prenom = scanner.nextLine();
                a1.ajouterClient(new Client(prenom,nom));
                break;
            case 6:
                ArrayList<Client> clients = a1.getClients();
                System.out.println(clients);
                break;
            case 7:
                System.out.print("saisir idclient : ");
                scanner.nextLine();
                String idclient = scanner.nextLine();
                Client c = a1.trouverClientParId(idclient);
                if (c == null) {
                    throw new LocationException("client inexistant");
                }
                System.out.print("saisir idveh : ");
                String idveh = scanner.nextLine();
                System.out.print("date debut (YYYY-MM-DD) : ");
                LocalDate debut = LocalDate.parse(scanner.nextLine());
                System.out.print("date fin (YYYY-MM-DD) : ");
                LocalDate fin = LocalDate.parse(scanner.nextLine());
                a1.louer(c,idveh,debut,fin);
                break;
            case 8:
                ArrayList<Location> locations = a1.getLocationsActives();
                System.out.println(locations);
                break;
            case 9:
                System.out.print("saisir idveh : ");
                scanner.nextLine();
                String idveh1 = scanner.nextLine();
                a1.restituer(idveh1);
                break;
            case 10:
                a1.sauvegarderDonnees();
                break;
            case 11:
                a1.chargerDonnees();
                break;
            case 0:
                break;
            default:
                System.out.println("choix erreur");
                break;
        }
    }
}