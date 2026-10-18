package Java_Uni.tp1.ex1;

import java.util.Random;
import java.util.Scanner;

public class Operations_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int a = random.nextInt(1,11);
        int b = random.nextInt(1,11);
        int res1 = b-a;
        int res2 = a+b;
        int res3 = a*b;

        System.out.print("b-a : ");
        int op1 = scanner.nextInt();
        if (op1 == res1) {
            System.out.println("b-a correcte");
        } else {
            System.out.println("b-a fausse");
        }

        System.out.print("a+b : ");
        int op2 = scanner.nextInt();
        if (op2 == res2) {
            System.out.println("a+b correcte");
        } else {
            System.out.println("a+b fausse");
        }

        System.out.print("a*b : ");
        int op3 = scanner.nextInt();
        if (op3 == res3) {
            System.out.println("a*b correcte");
        } else {
            System.out.println("a*b fausse");
        }

        scanner.close();
    }
}
