package Hangman;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        /*
        JFrame frame = new JFrame(); // Creates a frame
        frame.setTitle("Hangman");// Sets title of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit application when X is pressed
        frame.setResizable(false);// Prevent frame from resizing
        frame.setSize(420, 420);// Set dimensions x and y
        frame.setVisible(true); // Make frame visible

        ImageIcon imageIcon = new ImageIcon("src/com/Hangman/Assets/icon.png"); //Create an ImageIcon
        frame.setIconImage(imageIcon.getImage()); //Change icon of frame
        frame.getContentPane().setBackground(Color.black);//Change color of background, New Color(0,0,0) takes Rbg value and hexidecimal values

        JLabel label = new JLabel();//Create label
        label.setText("HangMan");//Set text of label
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER)// Set Text LEFT, CENTER, Right of Image
        label.setVerticalTextPosition(JLabel.TOP)// Set Text TOP, CENTER, BOTTOM of Image
        label.setBackground(Color.black);// Set background color
         */

        JLabel label = new JLabel();//Create label
        label.setText("H a n g-M a n");//Set text of label
        label.setForeground(Color.white);//Set color
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBackground(Color.black);

        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP); //set vertical position
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,20,420,25);

        HangmanFrame frame = new HangmanFrame();

        frame.add(label);

    }
}
