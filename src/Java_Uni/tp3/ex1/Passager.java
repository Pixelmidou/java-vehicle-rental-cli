package Java_Uni.tp3.ex1;

public class Passager {
    private String nat;
    private boolean valvisa;
    private int age;
    private boolean bilconf;
    private boolean accomp;
    private boolean bagsup;
    private double prix;

    Passager(String nat, boolean valvisa, int age, boolean bilconf, boolean accomp, boolean bagsup, double prix) {
        this.nat = nat;
        this.valvisa = valvisa;
        this.age = age;
        this.bilconf = bilconf;
        this.accomp = accomp;
        this.bagsup = bagsup;
        this.prix = prix;
    }

    void setNat(String nat) {
        this.nat = nat;
    }

    void setValvisa(boolean valvisa) {
        this.valvisa = valvisa;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setBilconf(boolean bilconf) {
        this.bilconf = bilconf;
    }

    void setAccomp(boolean accomp) {
        this.accomp = accomp;
    }

    void setBagsup(boolean bagsup) {
        this.bagsup = bagsup;
    }

    void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nat + " " + valvisa + " " + age + " " + bilconf + " " + accomp + " " + bagsup + " " + prix;
    }

    void verifierEmbarquement() {
        boolean x1 = !bilconf;
        boolean x2 = !valvisa && nat.equalsIgnoreCase("etranger");
        boolean x3 = age < 18 && !accomp;
        if (bagsup) prix += 100;
        if (!x1 && !x2 && !x3) {
            System.out.println("Embarquement autorisé | Prix : " + prix);
        } else {
            System.out.println("Embarquement refus");
            if (x1) System.out.println("Billet non confirmé");
            if (x2) System.out.println("Visa invalide");
            if (x3) System.out.println("Mineur non accompagné");
        }

    }

}
