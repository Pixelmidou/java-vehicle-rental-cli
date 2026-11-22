package Java_Uni.tp3.ex3;

import java.util.Vector;

public class Ballon {
    public static Vector<Ballon> ballons = new Vector<>();
    String[] idstring = {"mafchoucha","moyenGonflé","bienGonflé"};
    private final int id;
    private final int taille;

    Ballon(int id, int taille) {
        if (id < 1 || id > 3) {
            throw new IllegalArgumentException("il faut id : 1,2,3");
        }
        this.id = id;
        this.taille = taille;
        ballons.addElement(this);
    }

    @Override
    public String toString() {
        return "id = " + idstring[id-1] + "\n" + "taille = " + taille + "\n";
    }

}
