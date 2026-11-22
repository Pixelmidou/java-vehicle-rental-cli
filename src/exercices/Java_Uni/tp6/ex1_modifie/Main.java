package Java_Uni.tp6.ex1_modifie;

public class Main {
    public static void main(String[] args) throws ConnexionException {

        try {
            Administrateur a1 = new Administrateur("xxx","sss",1);
            a1.seConnecter("xxx", "sss");

            Invite i1 = new Invite("xxx","sss","00:00:00");
            i1.seConnecter();
        } catch (ConnexionException e) {
            System.out.println(e);
        }

    }
}
