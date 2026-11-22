package Java_Uni.tp8.ex1;

import java.util.*;

class Inventaire<T extends Inventoriable> {
    private HashMap<String, T> produits;
    private String id;

    Inventaire() {
        produits = new HashMap<>();
    }

    void ajouterProduit(String id, T produit) {
        produits.put(id, produit);
    }

    void supprimerProduit(String id) {
        if (produits.containsKey(id)) {
            produits.remove(id);
        } else {
            System.out.println("produit " + id + " inexistant");
        }
    }

    void afficherInventaireUn() {
        if (produits.isEmpty()) {
            System.out.println("HashMap vide");
        } else {
            produits.forEach((id, produit) -> {
                System.out.println(id + " " + produit);
            });
        }
    }

    void afficherInventaireDeux() {
        if (produits.isEmpty()) {
            System.out.println("HashMap vide");
        } else {
            for (String id : produits.keySet()) {
                System.out.println(id + " " + produits.get(id));
            }
        }
    }

    // EntrySet : traja3 object sous forme de Map.Entry<...>
    // .getKey() , .getValue() , .setValue()

    void afficherInventaireTrois() {
        if (produits.isEmpty()) {
            System.out.println("HashMap vide");
        } else {
            // Implicit Iterator ( foreach bidha mbniya 3la "for (X x : collection)" )
            for (Map.Entry<String, T> entry : produits.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    void afficherInventaireQuatre() {
        if (produits.isEmpty()) {
            System.out.println("HashMap vide");
        } else {
            // Explicit Iterator ( equivalent au traitement du methode precedente )
            Iterator<Map.Entry<String, T>> it = produits.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, T> entry = it.next();
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    double calculerValeurTotale() {
        double total = 0;
        if (produits.isEmpty()) {
            System.out.println("HashMap vide");
        } else {
            for (T produit : produits.values()) {
                total += produit.prix();
            }
        }
        return total;
    }

    ArrayList<T> getListeProduits() {
        return new ArrayList<>(produits.values());
    }

}
