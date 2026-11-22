package Java_Uni.tp3.ex2;

public class Employe {
    private final String matricule;
    private final String nom;
    private final String prenom;
    private final int annnes;
    private final int annemb;
    private double salaire;
    private static int nbemp = 0;

    Employe(String matricule, String nom, String prenom, int annnes, int annemb, double salaire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.annnes = annnes;
        this.annemb = annemb;
        this.salaire = salaire;
        nbemp++;
    }

    static void getNbemp() {
        System.out.println("nb emp : " + nbemp);
    }

    int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - this.annnes;
    }

    int getAnciennete() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - this.annemb;
    }

    void augmentationDuSalaire() {
        int anciennete = getAnciennete();
        if (anciennete < 5) {
            salaire *= 1.02;
        } else if (anciennete < 10) {
            salaire *= 1.05;
        } else {
            salaire *= 1.10;
        }
    }

    void afficherEmploye() {
        System.out.println("Matricule : " + matricule);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Année de naissance : " + annnes);
        System.out.println("Année d'embauche : " + annemb);
        System.out.println("Salaire : " + salaire);
        System.out.println("Âge : " + getAge() + " ans");
        System.out.println("Ancienneté : " + getAnciennete() + " ans");
    }

}
