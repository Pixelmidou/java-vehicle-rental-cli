package Java_cores.GUI;

import javax.swing.*;
import java.awt.*;

public class MyJframe extends JFrame {
    // another way to create frames
    MyJframe() {

        this.setVisible(true);

        this.setSize(420, 420);

        this.setTitle("Jframe java :)");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        ImageIcon image = new ImageIcon("src/Java_cores/GUI/eggplant.png");
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(0x123456));

    }
}
