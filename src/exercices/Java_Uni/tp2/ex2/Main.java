package Java_Uni.tp2.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Triangle[] triangles = new Triangle[3];

        for (int i = 0; i < triangles.length ; i++) {
            System.out.printf("c1-t%d : ", i+1);
            double c1 = scanner.nextDouble();
            System.out.printf("c2-t%d : ", i+1);
            double c2 = scanner.nextDouble();
            System.out.printf("c3-t%d : ", i+1);
            double c3 = scanner.nextDouble();
            triangles[i] = new Triangle(c1, c2, c3);
        }

        double[] perimetre = new double[3];

        for (int i = 0; i < triangles.length; i++) {
            double perim = triangles[i].perimetre();
            perimetre[i] = perim;
            System.out.printf("perimetre t%d = %f\n", i+1, perim);
        }

        Arrays.sort(perimetre);
        System.out.println("perimetre triée : " + Arrays.toString(perimetre));

        scanner.close();
    }
}
