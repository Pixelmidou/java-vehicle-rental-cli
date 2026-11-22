package Java_Uni.tp3.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choix = 99;
        System.out.println("1- creer ballon\n2- afficher ballons\n3- détruire ballon\n0- quitter");
        while (choix != 0) {
            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("id : ");
                    int id = scanner.nextInt();
                    System.out.print("taille : ");
                    int taille = scanner.nextInt();
                    new Ballon(id,taille);
                    break;
                case 2:
                    if (Ballon.ballons.isEmpty()) {
                        System.out.println("vide");
                        break;
                    }
                    int i = 1;
                    for (Ballon b : Ballon.ballons) {
                        System.out.println("ballon " + i + "\n" + b);
                        i++;
                    }
                    break;
                case 3:
                    if (Ballon.ballons.isEmpty()) {
                        System.out.println("bellehi cht7b tne7i !");
                        break;
                    }
                    System.out.print("ballon a supprimer : ");
                    int index = scanner.nextInt();
                    if (index < 1 || index > Ballon.ballons.size()) {
                        System.out.println("index 8alet");
                    } else {
                        Ballon.ballons.remove(index - 1);
                        System.out.println("ballon supprimé");
                    }
                    break;
                case 0:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("8alet");
                    break;
            }

        }

        scanner.close();
    }
}
