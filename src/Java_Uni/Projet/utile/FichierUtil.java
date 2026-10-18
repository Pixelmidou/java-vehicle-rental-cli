package Java_Uni.Projet.utile;

import model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FichierUtil {
    public static void sauvegarderParc(File fichier, ArrayList<Vehicule> parc) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier))) {
            for (Vehicule v : parc) {
                String type = v.getClass().getSimpleName();
                String line = type + "," +
                        v.getMarque() + "," +
                        v.getModele() + "," +
                        v.getPrix() + "," +
                        v.isDisponible();
                if (v instanceof Voiture voiture) {
                    line += "," + voiture.getNbportes();
                } else if (v instanceof Moto moto) {
                    line += "," + moto.getCylindre();
                }
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static ArrayList<Vehicule> chargerParc(File fichier) throws IOException {
        ArrayList<Vehicule> parc = new ArrayList<>();
        if (!fichier.exists()) return parc;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                String type = t[0];
                String marque = t[1];
                String modele = t[2];
                double prix = Double.parseDouble(t[3]);
                boolean dispo = Boolean.parseBoolean(t[4]);

                Vehicule v = null;

                switch (type) {
                    case "Voiture":
                        int portes = Integer.parseInt(t[5]);
                        try {
                            v = new Voiture(marque, modele, prix, dispo, portes);
                        } catch (LocationException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "Moto":
                        int cylindre = Integer.parseInt(t[5]);
                        v = new Moto(marque, modele, prix, dispo, cylindre);
                        break;
                }
                if (v != null) parc.add(v);
            }
        }
        return parc;
    }

    public static void sauvegarderClients(File fichier, ArrayList<Client> clients) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier))) {
            for (Client client : clients) {
                bw.write(client.getPrenom() + "," +
                        client.getNom() + "," +
                        client.getIdClient());
                bw.newLine();
            }
        }
    }

    public static ArrayList<Client> chargerClients(File fichier) throws IOException {
        ArrayList<Client> clients = new ArrayList<>();
        if (!fichier.exists()) return clients;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                String prenom = t[0];
                String nom = t[1];
                String idclient = t[2];
                Client c = new Client(idclient, prenom, nom);
                clients.add(c);
            }
        }
        return clients;
    }

    public static void sauvegarderLocations(File fichier, ArrayList<Location> locations) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier))) {
            for (Location location : locations) {
                bw.write(location.getClient().getIdClient() + "," +
                        location.getVehicule().getReference() + "," +
                        location.getDatedeb() + "," +
                        location.getDatefin() + "," +
                        location.getMontantTotal());
                bw.newLine();
            }
        }
    }

    public static ArrayList<Location> chargerLocations(File fichier) throws IOException {
        ArrayList<Location> locations = new ArrayList<>();
        if (!fichier.exists()) return locations;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                String idc = t[0];
                String idv = t[1];
                LocalDate datedeb = LocalDate.parse(t[2]);
                LocalDate datefin = LocalDate.parse(t[3]);
                double montantTotal = Double.parseDouble(t[4]);
                Location l = new Location(datedeb, datefin, montantTotal, idc, idv);
                locations.add(l);
            }
        }
        return locations;
    }
}