import java.util.Scanner;
/**
 * Gère une liste de produits et fournit des méthodes d'affichage et recherche.
 */
public class Catalogue {
    private Produit[] produits;
    private int nbProduits = 0;
    private final Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param nbprod
     */

    Catalogue(int nbprod) {
        produits = new Produit[nbprod];
    }

    void ajouterProduit() {
        if (nbProduits >= produits.length) {
            System.out.println("catalogue plein");
            return;
        }

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = scanner.nextDouble();

        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Code : ");
        String code = scanner.nextLine();

        produits[nbProduits] = new Produit(nom, prix, quantite, code);
        nbProduits++;
    }

    void afficherTous() {
        if (nbProduits == 0) {
            System.out.println("aucun produit");
            return;
        }

        for (int i = 0; i < nbProduits; i++) {
            produits[i].afficherProduit();
        }
    }

    /**
     *
     * @param nom
     */
    void chercherParNom(String nom) {
        boolean trouve = false;
        for (int i = 0; i < nbProduits; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                produits[i].afficherProduit();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("produit inexistant");
        }
    }

    /**
     *
     * @return valtotal
     */
    double valeurTotaleStock() {
        double valtotal = 0;
        for (int i = 0; i < nbProduits; i++) {
            valtotal += produits[i].calculerValeurStock();
        }
        return valtotal;
    }
}
