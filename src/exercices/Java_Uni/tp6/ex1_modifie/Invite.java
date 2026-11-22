package Java_Uni.tp6.ex1_modifie;

import java.time.LocalTime;

class Invite extends Utilisateur {
    private LocalTime duree;

    Invite(String username, String password, String duree) {
        super(username, password);
        this.duree = LocalTime.parse(duree);
    }

    protected boolean seConnecter() throws ConnexionException {
        if (duree.toSecondOfDay() <= 0) {
            throw new ConnexionException("Durée expirée");
        }
        return true;
    }

    String getDuree() {
        return duree.toString();
    }

}
