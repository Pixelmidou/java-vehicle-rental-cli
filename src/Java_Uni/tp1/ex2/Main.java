package Java_Uni.tp1.ex2;


public class Main {
    public static void main(String[] args) {

        if (args.length > 2 || args.length < 1) {
            System.out.println("non");
            return;
        }

        String nom = args[0];
        String prenom = "";

        if (args.length == 2) {
            prenom = args[1];
        }

        if (!prenom.isEmpty()) {
            Personne p1 = new Personne(nom, prenom);
            p1.afficher();
        } else {
            Personne p2 = new Personne(nom);
            p2.afficher();
        }
    }
}