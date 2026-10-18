package Java_Uni.tp2.ex1;

public class Main {
    public static void main(String[] args) {
        CompteBancaire c1 = new CompteBancaire("salah", 100);
        c1.afficherMontant();
        c1.versementArgent(9.9);
        c1.afficherMontant();
        c1.retraitArgent(10);
        c1.afficherMontant();
    }
}
