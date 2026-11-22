package Java_cores.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Jlabels {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(); // creating the label
        label.setText("IDK honestly"); // adding text to the label ( can be done in the Jlabel construtor )
        frame.add(label); // adds the label to the frame

        // adding an image to the label
        ImageIcon image = new ImageIcon("src/Java_cores/GUI/eggplant.png");
        label.setIcon(image);

        // Changing the position of the label's text
        label.setHorizontalTextPosition(JLabel.CENTER); // LEFT,CENTER,RIGHT
        label.setVerticalTextPosition(JLabel.TOP); // TOP,CENTER,BOTTOM

        label.setForeground(new Color(0x0FF00)); // changing the color of the label's text
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // changing the label's text font

        label.setIconTextGap(-10); // sets the gap between the image and text in the label

        // setting a background color for a label
        // By default the label likes to take all available space
        // which in this case the whole frame ( that is why we see the whole frame as the label bg color )
        // we can see this behaviour apparent when creating a border for the label
        label.setBackground(new Color(0x0FF0)); // this by itself won't work
        label.setOpaque(true); // with this , it paints every pixel within bound ( within the label )

        // Setting a border for the label
        Border border = BorderFactory.createLineBorder(Color.CYAN, 5);
        label.setBorder(border);

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        // the behaviour of the label taking the whole space
        // is because of the layout manager of the frame
        // so we can set it to null , and control the spacing ourselves
        // we have to show everything manually
        // frame.setLayout(null);

        // sets x,y position within frame as well as the width and height
        // label.setBounds(100, 100, 250, 250);

        frame.pack();

    }
}
