package Java_Uni.tp8.ex1;

import java.util.ArrayList;

class InventaireUtils {
    static void afficherInventaireGenerique(Inventaire<?> inv) {
        ArrayList<?> produits = inv.getListeProduits();
        for (Object produit : produits) {
            System.out.println(produit);
        }
    }
}
