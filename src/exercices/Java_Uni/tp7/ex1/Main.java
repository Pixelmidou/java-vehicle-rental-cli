package Java_Uni.tp7.ex1;
import java.io.*;

public class Main {
    static void writeFile(Object... objects) {
        try (FileOutputStream file = new FileOutputStream("src/ex1/data.obj");
             BufferedOutputStream buffer = new BufferedOutputStream(file);
             ObjectOutputStream objout = new ObjectOutputStream(buffer)) {

            for (Object obj : objects) {
                if (obj instanceof int[] intarr) {
                    objout.writeObject(intarr);

                } else if (obj instanceof String[] stringarr) {
                    objout.writeObject(stringarr);

                } else {
                    throw new IllegalArgumentException("Seuls String[] et int[] sont autorisés");
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur d'écriture: " + e);
        }
    }

    static void readFile() {
        try (FileInputStream file = new FileInputStream("src/ex1/data.obj");
             BufferedInputStream buffer = new BufferedInputStream(file);
             ObjectInputStream objin = new ObjectInputStream(buffer)) {


            while (true) {
                try {
                    Object obj = objin.readObject();
                    if (obj instanceof int[] intarr) {
                        System.out.println(java.util.Arrays.toString(intarr));

                    } else if (obj instanceof String[] stringarr) {
                        System.out.println(java.util.Arrays.toString(stringarr));
                    }

                } catch (EOFException e) {
                    System.out.println("EOF");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void getFileSize(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File size: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist");
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        String[] strings = {"aa","bb","cc"};

        writeFile(ints,strings);
        getFileSize("src/ex1/data.obj");
        readFile();

    }
}
