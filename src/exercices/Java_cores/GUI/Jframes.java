package Java_cores.GUI;

import javax.swing.*;
import java.awt.*;

public class Jframes {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // creates a frame but it is not visible

        frame.setVisible(true); // makes the frame visible

        frame.setSize(420, 420); // sets the width,height of the frame (420x420)

        frame.setTitle("Jframe java :)"); // gives the frame a title

        // when pressing X to close the frame , it actually just hides the frame
        // it does not exit the program  , we can change this behaviour
        // so that when closing the frame the program also exits
        // Default option : HIDE_ON_EXIT
        // Other options : EXIT_ON_CLOSE / DO_NOTHING_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false); // prevents frame from being resized

        // Changing the logo of the frame ( the one besides the title )
        ImageIcon image = new ImageIcon("src/Java_cores/GUI/eggplant.png");
        frame.setIconImage(image.getImage());

        // Changing the background color of the frame
        // frame.getContentPane().setBackground(Color.BLACK)
        // frame.getContentPane().setBackground(new Color(255,0,0));
        frame.getContentPane().setBackground(new Color(0x123456));

        // same result
        // MyJframe myframe = new MyJframe();
        // or anonymous frame
        // new MyJframe();
    }
}
