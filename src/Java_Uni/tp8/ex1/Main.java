package Java_Uni.tp8.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static void main() {
        Inventaire<Ordinateur> inv1 = new Inventaire<>();
        Inventaire<Imprimante> inv2 = new Inventaire<>();
        inv1.ajouterProduit("or1", new Ordinateur("dell",2));
        inv1.ajouterProduit("or2", new Ordinateur("acer",1));
        inv1.ajouterProduit("or3", new Ordinateur("bino",3));
        inv2.ajouterProduit("imp1", new Imprimante("hp",3));
        inv2.ajouterProduit("imp2", new Imprimante("epson",2));

        System.out.println(inv1.calculerValeurTotale());
        System.out.println(inv2.calculerValeurTotale());

        ArrayList<Ordinateur> ordprod = inv1.getListeProduits();
        Collections.sort(ordprod);
        System.out.println(ordprod);

        ordprod.sort(new Comparator<Ordinateur>() {
            @Override
            public int compare(Ordinateur o1, Ordinateur o2) {
                return o1.nom().compareTo(o2.nom());
            }
        });
        System.out.println(ordprod);

        InventaireUtils.afficherInventaireGenerique(inv1);
        InventaireUtils.afficherInventaireGenerique(inv2);

    }
}
