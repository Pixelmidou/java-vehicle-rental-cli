package Java_Uni.tp5.ex4;

abstract class Animal implements Deplacable {
    protected String nom;
    protected int age;
    protected String matricule;

    private static int compt = 1;

    Animal(String nom, int age) {
        this.nom = nom;
        this.age = age;
        this.matricule = generateMatricule();
    }

    @Override
    public void seDeplacer() {
        System.out.println("Tous animal se déplace avec des moyens differents");
    }

    abstract protected void faireSon();

    private String generateMatricule() {
        String m = "AN" + compt + (age < 10 ? "0" + age : age);
        compt++;
        return m;
    }

    @Override
    public String toString() {
        return "nom : " + nom + "\nage : " + age + "\nmatricule : " + matricule;
    }

}
