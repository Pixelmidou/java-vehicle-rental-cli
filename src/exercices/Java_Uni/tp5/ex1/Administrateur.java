package Java_Uni.tp5.ex1;

public class Administrateur extends Utilisateur {
    private int niveausec;

    Administrateur(String username, String password, int niveausec) {
        super(username, password);
        this.niveausec = niveausec;
    }

    @Override
    public String toString() {
        return super.toString() + "\nniveau securite : " + niveausec;
    }

}
