package Projet_LocationVehicule.model;


public class Administrateur {
    private String login;
    private String mdp;

    public Administrateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public boolean authentifier(String login, String mdp) {
        return login.equals(this.login) && mdp.equals(this.mdp);
    }

}
