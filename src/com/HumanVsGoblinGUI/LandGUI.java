package HumanVsGoblinGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class LandGUI {
    private int size;

    private  int goblinNumber;
    public int getSize(){return size;}

    public  void setSize(int size){this.size = size;}
    public LandGUI(int size){
        this.size = size;
    }

    public LandGUI(){}
    public void generateLandE(JLabel[][] labels, HumansGUI human, GoblinGUI g1, GoblinGUI g2, GoblinGUI g3){
        Random num = new Random();
        int ran = num.nextInt(0, this.size-1);
        int ranj = num.nextInt(0, this.size-1);

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                labels[i][j].setBackground(Color.green);
                labels[i][j].setIcon(null);
                if (i == ran && j == ranj ) {
                    labels[i][j].setIcon(new ImageIcon( new ImageIcon("src/com/HumanVsGoblinGUI/Assests/chest.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
                    if(human.getX()==ran && human.getY() == ran) {
                        treasurChest(human, g1, g2, g3);
                    }
                    continue;
                }
                if (i == g1.getY() && j == g1.getX() && !g1.getDead()) {
                    printGoblin(g1.getType(),labels[i][j]);
                    continue;
                }
                if (i == g3.getY() && j == g3.getX() && !g3.getDead()) {
                    printGoblin(g3.getType(),labels[i][j]);
                    continue;
                }
                if (i == g2.getY() && j == g2.getX() && !g2.getDead()) {
                    printGoblin(g2.getType(),labels[i][j]);
                    continue;
                }
                if (human.getY() == i && human.getX() == j) {
                    labels[i][j].setIcon(new ImageIcon( new ImageIcon("src/com/HumanVsGoblinGUI/Assests/knight.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
                    continue;
                }
            }
        }


    }
    public void printGoblin(String type, JLabel label){
        if(type.equals("Small")){
            label.setIcon(new ImageIcon( new ImageIcon("src/com/HumanVsGoblinGUI/Assests/small.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
        }
        else if (type.equals("Big")) {
            label.setIcon(new ImageIcon( new ImageIcon("src/com/HumanVsGoblinGUI/Assests/large.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
        }
        else if (type.equals("BigScout")) {
            label.setIcon(new ImageIcon( new ImageIcon("src/com/HumanVsGoblinGUI/Assests/scout.png").getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));

        } else
            System.out.println("Something Went Wrong");
    }

    public static int Dice(){
        Random dice = new Random();
        int ranNum = dice.nextInt(1,6);
        int ranNum1 = dice.nextInt(1,6);

        if (ranNum > ranNum1){
            return 1;
        }
        else
            return 2;
    }

    public static void treasurChest(HumansGUI human, GoblinGUI g1, GoblinGUI g2, GoblinGUI g3){
        human.setHealth(human.getHealth() + 5);
        g1.setHealth(g1.getHealth() - 5);
        g2.setHealth(g2.getHealth() - 5);
        g3.setHealth(g3.getHealth() - 2);
    }

    public void initateGame(){
        Scanner s = new Scanner(System.in);
        System.out.println("G o b l i n  V S  H u m a n");
        System.out.println();
        System.out.println("1. Start Game");
        System.out.println("2. How to Play");
        System.out.println("3. Exit");
        String userInput = s.next();
        while (!userInput.equals("1") ){
            if (userInput.equals("2")){
                System.out.println("|*| Player will Enter n for north, e for east, s for south and w for west");
                System.out.println("Any interaction with goblins will trigger an attack. multiple goblins can attach at once");
                System.out.println("|#| Small Goblin, |@| Big Goblin, |O| Scout Goblin");
                System.out.println("|U| Treasure Triggers will damage all goblin and add health to the player");
                System.out.println("");
                System.out.println("1. Start Game");
                System.out.println("3. Exit");
                userInput = s.next();
            }
            if (userInput.equals("3")){
                System.exit(0);
            }
        }
    }
}
