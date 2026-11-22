package Java_Uni.tp6.ex1_modifie;

class Administrateur extends Utilisateur {
    private int niveausec;

    Administrateur(String username, String password, int niveausec) {
        super(username, password);
        this.niveausec = niveausec;
    }

    @Override
    protected boolean seConnecter(String username, String pass) throws ConnexionException {
        if (niveausec <= 0) {
            throw new SecurityException("Niveau de sécurité insuffisant");
        }

        return super.seConnecter(username, pass);
    }


    @Override
    public String toString() {
        return super.toString() + "\nniveau securite : " + niveausec;
    }

}
