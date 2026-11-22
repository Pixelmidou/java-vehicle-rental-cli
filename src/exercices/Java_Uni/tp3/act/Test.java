package Java_Uni.tp3.act;

public class Test {
    public static void main(String[] args) {
        BanditManchot jeu = new BanditManchot();
        int gain = jeu.joue();
        System.out.println("gain : " + gain);
    }
}
