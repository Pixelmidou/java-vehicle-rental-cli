package Java_Uni.tp5.ex1;

import java.time.LocalTime;

public class Invite extends Utilisateur {
    private LocalTime duree;

    Invite(String username, String password, String duree) {
        super(username, password);
        this.duree = LocalTime.parse(duree);
    }

    protected boolean seConnecter() {
        return duree.toSecondOfDay() > 0;
    }

    String getDuree() {
        return duree.toString();
    }

}
