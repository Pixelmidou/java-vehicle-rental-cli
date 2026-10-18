/**
 * Représente un produit stocké dans le catalogue,
 * avec nom, prix, quantité et code unique.
 * @author pixel
 * @version 1.00
 */

public class Produit {

    private String nom;
    private double prix;
    private int quantite;
    private String code;

    /**
     * Constructeur par défaut.
     */
    Produit() {
        this("Inconnu", 0.0, 0, "Inconnu0000");
    }

    /**
     * @param nom
     * @param prix
     * @param quantite
     * @param code
     */
    Produit(String nom, double prix, int quantite, String code) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.code = code;
    }

    /**
     *
     * @return nom
     */
    String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return prix
     */
    double getPrix() {
        return prix;
    }

    /**
     *
     * @param prix
     */
    void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     *
     * @return quantite
     */
    int getQuantite() {
        return quantite;
    }

    /**
     *
     * @param quantite
     */
    void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     *
     * @return code
     */
    String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    void setCode(String code) {
        this.code = code;
    }

    /**
     * @return prix * quantite
     */
    double calculerValeurStock() {
        return prix * quantite;
    }

    void afficherProduit() {
        System.out.println("Produit : " + nom);
        System.out.println("Code : " + code);
        System.out.println("Prix : " + prix);
        System.out.println("Quantité : " + quantite);
        System.out.println("Valeur du stock : " + calculerValeurStock());
    }
}
