package Java_Uni.tp5.ex1;

public class Main {
    public static void main(String[] args) {

        Administrateur a1 = new Administrateur("xxx","sss",1);
        Invite i1 = new Invite("xxx","sss","01:01:01");
        Invite i2 = new Invite("xxx","sss","00:00:00");

        System.out.println("vrai info admin : " + a1.seConnecter("xxx","sss"));
        System.out.println("faux info 1 admin : " + a1.seConnecter("xxx","ss"));
        System.out.println("faux info 2 admin : " + a1.seConnecter("xx","sss"));
        System.out.println("faux info 3 admin : " + a1.seConnecter("x","s"));

        System.out.println();
        System.out.println("Invite i1: ");
        System.out.println("Duree true/false : " + i1.seConnecter());
        System.out.println("Duree valeur : " + i1.getDuree());

        System.out.println("Invite i2: ");
        System.out.println("Duree true/false : " + i2.seConnecter());
        System.out.println("Duree valeur : " + i2.getDuree());

        System.out.println();
        Utilisateur[] users = {a1,i1,i2};
        System.out.println((users[0] instanceof Administrateur) ? "a1 est administrateur" : "a1 n'est pas administrateur");
        System.out.println((users[1] instanceof Administrateur) ? "i1 est administrateur" : "i1 n'est pas administrateur");
        System.out.println((users[2] instanceof Administrateur) ? "i2 est administrateur" : "i2 n'est pas administrateur");

    }
}
