package Java_Uni.tp2.ex2;

public class Triangle {
    double[] cote = new double[3];

    Triangle(double c1, double c2, double c3) {
        cote[0] = c1;
        cote[1] = c2;
        cote[2] = c3;
    }

    double perimetre() {
        return cote[0] + cote[1] + cote[2];
    }



}
