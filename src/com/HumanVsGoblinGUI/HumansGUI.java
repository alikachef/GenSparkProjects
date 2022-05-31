package HumanVsGoblinGUI;

import javax.swing.*;
import java.awt.*;

public class HumansGUI {
    private int health;
    private String equipment;
    private String name;
    private boolean isDead = false;

    private int x;
    private int y;

    public String getName(){return name;}
    public  void setName(String name){this.name = name;}


    public String getEquipment(){return equipment;}
    public  void setEquipment(String equipment){this.equipment = equipment;}

    public int getHealth(){return health;}
    public  void setHealth(int health){this.health = health;}

    public int getX(){return x;}
    public  void setX(int x){this.x = x;}

    public int getY(){return y;}
    public  void setY(int y){this.y = y;}

    public boolean getIsDead(){return isDead;}
    public void setIsDead(boolean isDead){this.isDead = isDead;}

    public HumansGUI(String name, String equipment, int health, int gridPosX, int gridPosY){
        this.name = name;
        this.equipment = equipment;
        this.health = health;
        this.x = gridPosX;
        this.y = gridPosY;
    }

    public HumansGUI(){}

    public void damageBySmallGoblin(JPanel label){
        JLabel label1 = new JLabel();
        label1.setText("<html>Got hit by small Goblin. Health is reduced by 5.<br/>" + " Player Health is: " + this.health+ "</html>");
        label1.setForeground(Color.white);
        label.add(label1);
        this.health -= 5;
        if (this.health <= 0){
            this.health = 0;
        }
        System.out.println();

        if (this.health == 0){
            System.out.println("You are dead");
            this.isDead = true;
        }

    }
    public void damageByBigGoblin(JPanel label){
        this.health -= 10;
        if (this.health <= 0){
            this.health = 0;
        }
        JLabel label1 = new JLabel();
        label1.setText("<html>"+"Got hit by Big Goblin. Health is reduced by 10.<br/>Player Health is: " + this.health+ "</html>");
        label1.setForeground(Color.white);
        label.add(label1);
        System.out.println();

        if (this.health == 0){
            System.out.println("You are dead");
            this.isDead = true;
        }
    }
    public void movePlayer(String pos){
        if(pos.equals("n")){
            this.setY(this.getY() - 1);
        } else if (pos.equals("e")) {
            this.setX(this.getX() + 1);
        }else if (pos.equals("s")){
            this.setY(this.getY() + 1);
        }else {
            this.setX(this.getX() - 1);
        }
    }

}
