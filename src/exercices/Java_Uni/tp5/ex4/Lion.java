package Java_Uni.tp5.ex4;

class Lion extends Animal {
    private Origine origine;

    Lion(Origine origine, String nom, int age) {
        super(nom, age);
        this.origine = origine;
    }

    @Override
    protected void faireSon() {
        System.out.println("Le lion rugit : Roooar !");
    }

    @Override
    public String toString() {
        return super.toString() + "\norigine : " + origine;
    }

    @Override
    public void seDeplacer() {
        System.out.println("Le lion marche sur la terre.");
    }
}
