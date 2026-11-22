package Java_Uni.tp5.ex4;

class Oiseau extends Animal {
    private String couleur;

    Oiseau(String couleur, String nom, int age) {
        super(nom, age);
        this.couleur = couleur;
    }

    @Override
    protected void faireSon() {
        System.out.println("L’oiseau chante : Cui-cui !");
    }

    @Override
    public String toString() {
        return super.toString() + "\ncouleur : " + couleur;
    }

    @Override
    public void seDeplacer() {
        System.out.println("L’oiseau vole dans le ciel.");
    }
}
