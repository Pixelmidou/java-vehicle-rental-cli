package Java_Uni.tp2.ex1;

public class CompteBancaire {
    private final String nom;
    private double montant;

    CompteBancaire(String nom, double montant) {
        this.nom = nom;
        this.montant = montant;
    }

    void versementArgent(double argent) {
        if (argent <= 0) {
            System.out.println("argent négatif");
        } else {
            montant += argent;
        }
    }

    void retraitArgent(double argent) {
        if (argent > montant) {
            System.out.println("montant insuffisant");
        } else if (argent <= 0) {
            System.out.println("argent négatif");
        } else {
            montant -= argent;
        }
    }
    void afficherMontant() {
        System.out.printf("\nmontant : %f", montant);
    }
}
