package Java_Uni.tp7.ex2;

import java.io.*;

class Biblio implements Serializable {

    void ajouterLivre(String filename, String titre, String auteur, int annee) {
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter writer = new BufferedWriter(fw)) {

            writer.write(titre + " " + auteur + " " + annee);
            writer.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void afficherlivres(String filename) {
        File file = new File(filename);
        if (file.length() == 0) {
            System.out.println("biblio vide");
            return;
        }

        try (FileReader fr = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
