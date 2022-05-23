package Hangman;

import javax.swing.*;
import java.awt.*;

public class HangmanFrame extends JFrame {
    HangmanFrame(){
        this.setTitle("Hangman");// Sets title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit application when X is pressed
        this.setResizable(false);// Prevent frame from resizing
        this.setSize(420, 420);// Set dimensions x and y
        this.setVisible(true); // Make frame visible
        this.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("src/com/Hangman/Assets/icon.png"); //Create an ImageIcon
        this.setIconImage(imageIcon.getImage()); //Change icon of frame
        this.getContentPane().setBackground(Color.black);//Change color of background, New Color(0,0,0) takes Rbg value and hexidecimal values


    }
}
