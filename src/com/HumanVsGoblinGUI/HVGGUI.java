package HumanVsGoblinGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HVGGUI implements ActionListener{
    static LandGUI playingFeild = new LandGUI(5);
    static HumansGUI humans = new HumansGUI("ali", "BareHands", 30, 0, playingFeild.getSize() -1);
    static GoblinGUI g1 = new GoblinGUI("Small", 40, 3,2, false);
    static GoblinGUI g2 = new GoblinGUI("BigScout", 60, 1, 0, false);
    static GoblinGUI g3 = new GoblinGUI("Big", 70, 0,0, false);
    static HumanVsGoblinFrame frame;

    HVGGUI() {

        JLabel label = new JLabel();//Create label
        label.setText("Humans VS Goblins");//Set text of label
        label.setForeground(Color.white);//Set color
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBackground(Color.black);
        label.setFont(new Font("MV Boli", Font.PLAIN,25));
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP); //set vertical position
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(22,20,420,50);

        frame  = new HumanVsGoblinFrame();
        frame.add(label);

        playingFeild.generateLandE(frame.labels,humans, g1, g2, g3);

        frame.buttonN.addActionListener(this);
        frame.buttonE.addActionListener(this);
        frame.buttonS.addActionListener(this);
        frame.buttonW.addActionListener(this);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == frame.buttonN) {
                frame.gameTests.removeAll();
                frame.gameTests.revalidate();
                frame.gameTests.repaint();
                humans.movePlayer("n");
                playingFeild.generateLandE(frame.labels, humans, g1, g2, g3);
                if(!g1.getDead()) {
                    g1.GoblinTurn(humans, frame.gameTests);
                }
                if(!g2.getDead()) {
                    g2.scout(playingFeild, humans, frame.gameTests);
                }
                if (!g3.getDead()) {
                    g3.GoblinTurn(humans, frame.gameTests);
                }
                checkIfDead(humans);

            }
            else if (e.getSource() == frame.buttonE) {
                frame.gameTests.removeAll();
                frame.gameTests.revalidate();
                frame.gameTests.repaint();
                humans.movePlayer("e");
                playingFeild.generateLandE(frame.labels, humans, g1, g2, g3);
                if(!g1.getDead()) {
                    g1.GoblinTurn(humans, frame.gameTests);
                }
                if(!g2.getDead()) {
                   g2.scout(playingFeild, humans, frame.gameTests);
                }
                if (!g3.getDead()) {
                    g3.GoblinTurn(humans, frame.gameTests);
                }
                checkIfDead(humans);
            }
            else if (e.getSource() == frame.buttonS) {
                frame.gameTests.removeAll();
                frame.gameTests.revalidate();
                frame.gameTests.repaint();
                humans.movePlayer("s");
                playingFeild.generateLandE(frame.labels, humans, g1, g2, g3);
                if(!g1.getDead()) {
                    g1.GoblinTurn(humans, frame.gameTests);
                }
                if(!g2.getDead()) {
                    g2.scout(playingFeild, humans, frame.gameTests);
                }
                if (!g3.getDead()) {
                    g3.GoblinTurn(humans, frame.gameTests);
                }
                checkIfDead(humans);

            }
            else if (e.getSource() == frame.buttonW) {
                frame.gameTests.removeAll();
                frame.gameTests.revalidate();
                frame.gameTests.repaint();
                humans.movePlayer("w");
                playingFeild.generateLandE(frame.labels, humans, g1, g2, g3);
                if(!g1.getDead()) {
                    g1.GoblinTurn(humans, frame.gameTests);
                }
                if(!g2.getDead()) {
                   g2.scout(playingFeild, humans, frame.gameTests);
                }
                if (!g3.getDead()) {
                    g3.GoblinTurn(humans, frame.gameTests);
                }
                checkIfDead(humans);
            }
    }
    public static Boolean checkIfDead(HumansGUI human){

        if (human.getIsDead()){
            frame.gameTests.removeAll();
            frame.gameTests.revalidate();
            frame.gameTests.repaint();
            JLabel lose = new JLabel();
            lose.setBackground(Color.black);
            lose.setForeground(Color.red);
            lose.setText("You Are Dead. You Lost ");
            lose.setFont(new Font("",0, 27));
            lose.setOpaque(true);
            frame.gameTests.add(lose);

            frame.buttonN.setEnabled(false);
            frame.buttonE.setEnabled(false);
            frame.buttonW.setEnabled(false);
            frame.buttonS.setEnabled(false);
            return true;
        }
        else if(g1.getDead() && g2.getDead() && g3.getDead()){
            frame.gameTests.removeAll();
            frame.gameTests.revalidate();
            frame.gameTests.repaint();
            JLabel lose = new JLabel();
            lose.setBackground(Color.black);
            lose.setForeground(Color.green);
            lose.setText("All Goblins Are Dead. You Won ");
            lose.setFont(new Font("",0, 27));
            lose.setOpaque(true);
            frame.gameTests.add(lose);
            frame.buttonN.setEnabled(false);
            frame.buttonE.setEnabled(false);
            frame.buttonW.setEnabled(false);
            frame.buttonS.setEnabled(false);
            return true;
        }
        else
            return false;
    }

}
