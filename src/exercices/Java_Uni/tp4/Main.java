import java.util.Scanner;
/**
 * Classe principale du programme. Affiche un menu et appelle les méthodes du catalogue.
 */
public class Main {
    /**
     * Point d'entrée du programme. Gère le menu principal.
     * @param args arguments de ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("combien de produits ? : ");
        int prodnb = scanner.nextInt();
        scanner.nextLine();

        Catalogue c1 = new Catalogue(prodnb);

        for (int i = 0; i < prodnb; i++) {
            System.out.printf("\nProduit %d\n", i + 1);
            c1.ajouterProduit();
        }

        int choix = -1;

        while (choix != 0) {
            System.out.println("\n1- Afficher tous les produits");
            System.out.println("2- Rechercher un produit par nom");
            System.out.println("3- Calculer la valeur totale du stock");
            System.out.println("0- Quitter");
            System.out.print("choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> c1.afficherTous();
                case 2 -> {
                    System.out.print("nom a chercher : ");
                    String nom = scanner.nextLine();
                    c1.chercherParNom(nom);
                }
                case 3 -> {
                    double total = c1.valeurTotaleStock();
                    System.out.println("valeur du stock : " + total);
                }
                case 0 -> System.out.println("bye");
                default -> System.out.println("bhim");
            }
        }

        scanner.close();
    }
}
