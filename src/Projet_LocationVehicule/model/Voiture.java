package Projet_LocationVehicule.model;

import java.util.Random;

public class Voiture extends Vehicule {
    private final int nbportes;
    private final Random random;

    public Voiture(String marque, String modele, double prix, boolean disponible, int nbportes) throws LocationException {
        this.random = new Random();
        super(marque, modele, prix, disponible);
        if (nbportes != 2 && nbportes != 4 && nbportes != 5) {
            throw new LocationException("nbportes : 2/4/5");
        }
        this.nbportes = nbportes;
    }

    public int getNbportes() {
        return nbportes;
    }

    protected String generateReference() {
        return "V" + random.nextInt(1000, 10000);
    }

    public String afficherDetails() {
        return super.afficherDetails() + "\nnbportes : " + nbportes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nnbportes : " + nbportes;
    }
}