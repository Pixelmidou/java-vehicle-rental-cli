package Java_Uni.Projet.model;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    private static ArrayList<String> idlist = new ArrayList<>();
    private String idClient;
    private String nom;
    private String prenom;
    private final Random random;

    public Client(String prenom, String nom) throws LocationException {
        this.random = new Random();
        this.prenom = prenom;
        this.nom = nom;
        this.idClient = genererIdClientUnique();
    }

    public Client(String idClient, String prenom, String nom) {
        this.random = new Random();
        this.idClient = idClient;
        this.prenom = prenom;
        this.nom = nom;
        idlist.add(idClient);
    }

    private String genererIdClientUnique() throws LocationException {
        String temp;
        do {
            temp = genererIdClient();
        } while (idlist.contains(temp));
        idlist.add(temp);
        return temp;
    }

    private String genererIdClient() {
        return "C" + random.nextInt(1000, 10000);
    }

    public void setIdClient(String idClient) {
        idlist.remove(this.idClient);
        this.idClient = idClient;
        idlist.add(idClient);
    }

    public static ArrayList<String> getIdlist() {
        return idlist;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient='" + idClient + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}