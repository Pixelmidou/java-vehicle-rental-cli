package Java_Uni.Projet.service;

import model.Client;
import model.Location;
import model.LocationException;
import model.Vehicule;
import utile.FichierUtil;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class AgenceLocation {
    private ArrayList<Vehicule> parc;
    private ArrayList<Client> clients;
    private ArrayList<Location> locationsActives;

    public AgenceLocation() {
        this.parc = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.locationsActives = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public Client trouverClientParId(String id) {
        for (Client client : clients) {
            if (client.getIdClient().equalsIgnoreCase(id)) {
                return client;
            }
        }
        return null;
    }

    public void louer(Client client, String vehiculeId, LocalDate debut, LocalDate fin) throws LocationException {
        Client c = trouverClientParId(client.getIdClient());
        Vehicule v = chercherVehiculeParId(vehiculeId);

        if (c == null && v == null) {
            throw new LocationException("client et vehicule inexistant");
        }
        if (c == null) {
            throw new LocationException("client inexistant");
        }
        if (v == null) {
            throw new LocationException("vehicule inexistant");
        }
        if (debut.isAfter(fin)) {
            throw new LocationException("date erreur");
        }
        if (!v.isDisponible()) {
            throw new LocationException("vehicule non disponible");
        }

        v.setDisponible(false);
        locationsActives.add(new Location(debut, fin, c, v));
    }

    public void restituer(String vehiculeId) throws LocationException {
        Vehicule v = chercherVehiculeParId(vehiculeId);
        if (v == null) {
            throw new LocationException("vehicule inexistant");
        }
        Iterator<Location> iterator = locationsActives.iterator();
        while (iterator.hasNext()) {
            Location location = iterator.next();
            if (location.getVehicule().equals(v)) {
                v.setDisponible(true);
                iterator.remove();
                return;
            }
        }
        throw new LocationException("aucune location trouve");
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Location> getLocationsActives() {
        return locationsActives;
    }

    public ArrayList<Vehicule> getParc() {
        return parc;
    }

    public Vehicule chercherVehiculeParId(String reference) {
        for (Vehicule vehicule : parc) {
            if (vehicule.getReference().equalsIgnoreCase(reference)) {
                return vehicule;
            }
        }
        return null;
    }

    public void ajouterVehicule(Vehicule veh) throws LocationException {
        if (veh == null) {
            throw new LocationException("vehicule null");
        }
        if (chercherVehiculeParId(veh.getReference()) != null) {
            throw new LocationException("vehicule existe deja");
        }
        parc.add(veh);
    }

    public void supprimerVehicule(String reference) throws LocationException {
        Iterator<Vehicule> iterator = parc.iterator();
        while (iterator.hasNext()) {
            Vehicule vehicule = iterator.next();
            if (vehicule.getReference().equalsIgnoreCase(reference)) {
                iterator.remove();
                return;
            }
        }
        throw new LocationException("vehicule inexistant");
    }

    public void modifierPrix(String reference, double nouveauPrix) throws LocationException {
        if (nouveauPrix < 0) {
            throw new LocationException("prix negatif");
        }
        Vehicule vehicule = chercherVehiculeParId(reference);
        if (vehicule == null) {
            throw new LocationException("vehicule inexistant");
        }
        vehicule.setPrix(nouveauPrix);
    }

    public ArrayList<Vehicule> vehiculesDisponibles() {
        ArrayList<Vehicule> vehdisp = new ArrayList<>();
        for (Vehicule vehicule : parc) {
            if (vehicule.isDisponible()) {
                vehdisp.add(vehicule);
            }
        }
        return vehdisp;
    }

    public void chargerDonnees() {
        try {
            parc.clear();
            parc.addAll(FichierUtil.chargerParc(new File("parc.csv")));

            clients.clear();
            clients.addAll(FichierUtil.chargerClients(new File("clients.csv")));

            locationsActives.clear();
            locationsActives.addAll(FichierUtil.chargerLocations(new File("locations.csv")));
            System.out.println(">> Données chargées avec succès.");
        } catch (Exception e) {
            System.out.println(">> Chargement impossible : " + e.getMessage()); }
    }
    // Méthode : sauvegarde complète
    public void sauvegarderDonnees() {
        try {
            FichierUtil.sauvegarderParc(new File("parc.csv"), parc);
            FichierUtil.sauvegarderClients(new File("clients.csv"), clients);
            FichierUtil.sauvegarderLocations(new File("locations.csv"), locationsActives);
            System.out.println(">> Données sauvegardées avec succès.");
        } catch (Exception e) {
            System.out.println(">> Erreur sauvegarde : " + e.getMessage());
        }
    }


}
