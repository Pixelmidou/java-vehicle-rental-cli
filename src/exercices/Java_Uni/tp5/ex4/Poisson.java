package Java_Uni.tp5.ex4;

class Poisson extends Animal {
    private TypeEau type_eau;

    Poisson(TypeEau type_eau, String nom, int age) {
        super(nom, age);
        this.type_eau = type_eau;
    }

    @Override
    protected void faireSon() {
        System.out.println("Le poisson ne fait pas de bruit...");
    }

    @Override
    public String toString() {
        return super.toString() + "\ntype_eau : " + type_eau;
    }

    @Override
    public void seDeplacer() {
        System.out.println("Le poisson nage dans l’eau.");
    }
}
