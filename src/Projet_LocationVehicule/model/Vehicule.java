package Projet_LocationVehicule.model;

public abstract class Vehicule {
    private final String reference;
    private String marque;
    private String modele;
    private double prix;
    private boolean disponible;

    Vehicule(String marque, String modele, double prix, boolean disponible) {
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.disponible = disponible;
        this.reference = generateReference();
    }

    abstract protected String generateReference();

    protected String afficherDetails() {
        return "Reference : " + reference + "\nMarque : " + marque + "\nModele : " + modele + "\nPrix : " + prix + "\nDisponible : " + disponible;
    }

    @Override
    public String toString() {
        return "Reference : " + reference + "\nMarque : " + marque + "\nModele : " + modele + "\nPrix : " + prix + "\nDisponible : " + disponible;
    }

    public String getReference() {
        return reference;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getModele() {
        return modele;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }


}
