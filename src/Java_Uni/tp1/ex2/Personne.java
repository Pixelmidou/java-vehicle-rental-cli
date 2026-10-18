package Java_Uni.tp1.ex2;

public class Personne {
    private String nom;
    private String prenom;

    Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    Personne(String nom) {
        this.nom = nom;
        this.prenom = "Inconnu";
    }

    void afficher() {
        System.out.printf("\nnom : %s\nprenom : %s", nom, prenom);
    }

}
