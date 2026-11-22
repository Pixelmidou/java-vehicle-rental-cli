package Java_Uni.tp8.ex1;

record Ordinateur(String nom, double prix) implements Inventoriable,Comparable<Ordinateur> {
    @Override
    public int compareTo(Ordinateur o) {
        return Double.compare(this.prix, o.prix);
    }
}
