package Java_cores.GUI;

import javax.swing.*;

public class GUI_Intro {
    public static void main(String[] args) {

        try {
            String name = JOptionPane.showInputDialog("Enter your name : ");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age : "));
            JOptionPane.showMessageDialog(null, "Hello " + name + ", you are " + age + " old");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be a number");
        }

    }
}
