package Java_Uni.tp7.ex2;

public class Main {
    public static void main(String[] args) {
        Biblio b1 = new Biblio();
        String filename = "src/ex2/livres.csv";
        b1.afficherlivres(filename);
        b1.ajouterLivre(filename, "aa", "bb", 2222);
        b1.ajouterLivre(filename, "cc", "dd", 3333);
        b1.afficherlivres(filename);
    }
}
