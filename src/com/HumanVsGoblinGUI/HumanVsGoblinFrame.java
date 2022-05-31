package HumanVsGoblinGUI;

import javax.swing.*;
import java.awt.*;

public class HumanVsGoblinFrame extends JFrame{
    JButton buttonN;
    JButton buttonE;
    JButton buttonS;
    JButton buttonW;
    JLabel[][] labels = new JLabel[5][5];
    JPanel land;
    JPanel gameTests = new JPanel();
    HumanVsGoblinFrame(){
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
        label.setFont(new Font("MV Boli", Font.PLAIN,50));
        label.setText("HangMan");//Set text of label
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER)// Set Text LEFT, CENTER, Right of Image
        label.setVerticalTextPosition(JLabel.TOP)// Set Text TOP, CENTER, BOTTOM of Image
        label.setBackground(Color.black);// Set background color
        label.setBounds(100,100,250,250); set position X and Y, and dimensions
        label.setBorder(border); // sets border of label
         */

        /*JPanel
        JPanel redPanel =  new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel =  new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel =  new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.setLayout(new BorderLayout());

         */

        JPanel buttons = new JPanel();
        land = new JPanel();


        buttonN = new JButton();
        buttonN.addActionListener(e-> System.out.println("n"));
        buttonN.setText("N");
        buttonN.setFocusable(false);
        buttonN.setBorder(BorderFactory.createEtchedBorder());
        buttonN.setFocusable(false);
        buttonN.setBackground(Color.white);
        buttonN.setForeground(Color.black);
        buttonN.setBorderPainted(false);


        buttonE = new JButton();
        buttonE.addActionListener(e-> System.out.println("e"));
        buttonE.setText("E");
        buttonE.setFocusable(false);
        buttonE.setBorder(BorderFactory.createEtchedBorder());
        buttonE.setFocusable(false);
        buttonE.setBackground(Color.white);
        buttonE.setForeground(Color.black);
        buttonE.setBorderPainted(false);


        buttonS = new JButton();
        buttonS.addActionListener(e-> System.out.println("s"));
        buttonS.setText("S");
        buttonS.setFocusable(false);
        buttonS.setBorder(BorderFactory.createEtchedBorder());
        buttonS.setFocusable(false);
        buttonS.setBackground(Color.white);
        buttonS.setForeground(Color.black);
        buttonS.setBorderPainted(false);


        buttonW = new JButton();
        buttonW.addActionListener(e-> System.out.println("w"));
        buttonW.setText("W");
        buttonW.setFocusable(false);
        buttonW.setBorder(BorderFactory.createEtchedBorder());
        buttonW.setFocusable(false);
        buttonW.setBackground(Color.white);
        buttonW.setForeground(Color.black);
        buttonW.setBorderPainted(false);



        buttons.setLayout(new GridLayout(1,0,5,0));
        buttons.setBounds(120,350,240,50);
        buttons.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttons.setBackground(Color.black);
        buttons.setOpaque(true);
        buttons.add(buttonN);
        buttons.add(buttonE);
        buttons.add(buttonS);
        buttons.add(buttonW);

        land.setLayout(new GridLayout(5, 5, 5,5));
        land.setBounds(115,75,250,250);
        land.setBackground(Color.black);
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                labels[i][j]  = new JLabel();
                labels[i][j].setBackground(Color.green);
                labels[i][j].setOpaque(true);
                land.add(labels[i][j]);
            }
        }



        gameTests.setBounds(42, 425, 400,120);
        gameTests.setBackground(Color.black);
        gameTests.setForeground(Color.white);
        gameTests.setLayout(new FlowLayout());
        gameTests.setOpaque(true);




        this.setTitle("Human Vs Goblins");// Sets title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit application when X is pressed
        this.setResizable(false);// Prevent frame from resizing
        this.setSize(500, 600);// Set dimensions x and y
        this.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("src/com/HumanVsGoblinGUI/Assests/sowrds.png"); //Create an ImageIcon
        this.setIconImage(imageIcon.getImage()); //Change icon of frame
        this.getContentPane().setBackground(Color.black);//Change color of background, New Color(0,0,0) takes Rbg value and hexidecimal values
        this.add(buttons);
        this.add(land);
        this.add(gameTests);
        this.setVisible(true);



    }


}
