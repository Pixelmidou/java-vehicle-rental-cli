package Java_Uni.Projet.model;

import java.util.Random;

public class Moto extends Vehicule {
    private final int cylindre;
    private final Random random;

    public Moto(String marque, String modele, double prix, boolean disponible, int cylindre) {
        this.random = new Random();
        super(marque, modele, prix, disponible);
        this.cylindre = cylindre;
    }

    public int getCylindre() {
        return cylindre;
    }

    public String afficherDetails() {
        return super.afficherDetails() + "\nCylindre : " + cylindre;
    }

    protected String generateReference() {
        return "M" + random.nextInt(1000, 10000);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCylindre : " + cylindre;
    }
}