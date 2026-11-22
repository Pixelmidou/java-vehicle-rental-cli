package Java_Uni.tp5.ex4;

public class Main {
    public static void main(String[] args) {

        Lion l = new Lion(Origine.ASIATIQUE,"Salah", 9);
        Poisson p = new Poisson(TypeEau.SALEE,"blah", 10);
        Oiseau o = new Oiseau("ROUGE","incon", 8);

        Animal[] animaux = {l, p, o};
        for (Animal animal : animaux) {
            System.out.println(animal);
            animal.faireSon();
            animal.seDeplacer();
            System.out.println();
        }

    }
}
