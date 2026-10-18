package Java_Uni.tp1.ex1;

import java.util.Scanner;

public class Operations_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a : ");
        int a = scanner.nextInt();

        System.out.print("b : ");
        int b = scanner.nextInt();

        System.out.printf("a + b = %d\n", a+b);
        System.out.printf("a - b = %d\n", a-b);
        System.out.printf("a * b = %d\n", a*b);

        scanner.close();
    }
}
