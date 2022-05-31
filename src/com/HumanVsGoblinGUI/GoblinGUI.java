package HumanVsGoblinGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GoblinGUI {
    private int health;
    private String type;

    private boolean isDead;

    private boolean leftRight = false;

    private int x;
    private int y;

    public String getType(){return type;}
    public  void setType(String type){this.type = type;}

    public int getHealth(){return health;}
    public  void setHealth(int health){this.health = health;}

    public boolean getDead(){return isDead;}
    public  void setDead(boolean isDead){this.isDead = isDead;}

    public int getX(){return x;}
    public  void setX(int x){this.x = x;}

    public int getY(){return y;}
    public  void setY(int y){this.y = y;}

    public GoblinGUI(String type, int health, int gridPosX, int gridPosY, boolean isDead){
        this.type = type;
        this.health = health;
        this.isDead = isDead;
        this.x = gridPosX;
        this.y = gridPosY;
    }

    public void damagedByBareHand(HumansGUI human, JPanel label){
        JLabel label1 = new JLabel();
        label1.setText("<html>" + this.type + " Goblin Got hit by Bare hands.<br/>" + this.type + "Goblin Health reduced by 15. Goblin's Health " + this.health + "</html>");
        label1.setForeground(Color.white);
        this.health -= 5;

        if(this.health <= 0){
            this.health = 0;
        }
        label.add(label1);

        if (this.health == 0){
            JLabel label2 = new JLabel(this.type + "Goblin is dead");
            label2.setForeground(Color.white);
            label.add(label2);
            this.isDead = true;
            this.bareHandDrop(human, label);
        }

    }

    public void damagedBySword(HumansGUI human, JPanel label){
        this.health -= 15;
        JLabel label1 = new JLabel( );
        label1.setText("<html>"+this.type + "Goblin Got hit by Sword.<br/>" + this.type + "Goblin Health reduced by 20. Goblin's Health " + this.health+"</html>");
        label1.setForeground(Color.white);
        label.add(label1);

        if(this.health <= 0){
            this.health = 0;
        }
        System.out.println();

        if (this.health == 0){
            JLabel label2 = new JLabel(this.type + " Goblin is dead");
            label2.setForeground(Color.white);
            label.add(label2);
            this.isDead = true;
            this.swordDrops(human, label);
        }
    }

    public void bareHandDrop(HumansGUI human, JPanel label){
        if(isDead == true){
            Random dice = new Random();
            int ranNum = dice.nextInt(1,6);
            int ranNum1 = dice.nextInt(1,6);

            if (ranNum > ranNum1){
                human.setEquipment("Sword");
                JLabel label1 = new JLabel();
                label1.setForeground(Color.white);
                label1.setText("<html>Goblin Dropped Sword<br/>Player Picked Sword Up</html>");
                label.add(label1);
            } else if (ranNum < ranNum1) {
                human.setHealth(human.getHealth() + 25);
                JLabel label1 = new JLabel();
                label1.setForeground(Color.white);
                label1.setText("<html>Goblin Dropped a Heart<br/>Player Ate the Heart:<br/>Player Health: " + human.getHealth() + "</html>");
                label.add(label1);
            }

        }
    }

    public void swordDrops(HumansGUI human, JPanel label){
        if(isDead == true){
            Random dice = new Random();
            int ranNum = dice.nextInt(1,6);
            int ranNum1 = dice.nextInt(1,6);

            if (ranNum > ranNum1){
                human.setHealth(human.getHealth() + 25);
                JLabel label1 = new JLabel();
                label1.setForeground(Color.white);
                label1.setText("<html>Goblin Dropped a Heart<br/>Player Ate the Heart:<br/>Player Health: " + human.getHealth() + "</html>");
                label.add(label1);
            } else {
                JLabel label1 = new JLabel();
                label1.setForeground(Color.white);
                label1.setText("<html>Goblin Have no drops</html>");
                label.add(label1);

            }
        }
    }

    public void GoblinTurn(HumansGUI human, JPanel label){
        if (this.isDead == false){
        this.GoblinMove(human);
        if(human.getX() == this.x && human.getY() == this.y) {
            Random dice = new Random();
            int ranNum = dice.nextInt(1, 6);
            int ranNum1 = dice.nextInt(1, 6);

            if (ranNum > ranNum1) {
                if (human.getEquipment() == "Sword") {
                    this.damagedBySword(human, label);
                } else
                    this.damagedByBareHand(human,label);
            } else {
                if (this.getType() == "Big") {
                    human.damageByBigGoblin(label);
                } else
                    human.damageBySmallGoblin(label);
            }
        }
        }
        else
            label.removeAll();
    }
    public void scout(LandGUI land, HumansGUI human, JPanel label){

        if(!leftRight){
            this.setX(this.getX() - 1);
            if(this.getX() == 0 ){
                leftRight = true;
            }
        }
        if (leftRight){
            this.setX(this.getX() + 1);
            if(this.getX() == land.getSize() -1){
                leftRight = false;
            }
        }
        if(human.getX() == this.x && human.getY() == this.y) {
            Random dice = new Random();
            int ranNum = dice.nextInt(1, 6);
            int ranNum1 = dice.nextInt(1, 6);

            if (ranNum > ranNum1) {
                if (human.getEquipment() == "Sword") {
                    this.damagedBySword(human, label);
                } else
                    this.damagedByBareHand(human, label );
            } else {
                if (this.getType() == "Big") {
                    human.damageByBigGoblin(label);
                } else
                    human.damageBySmallGoblin(label);
            }
        }
    }

    private void GoblinMove(HumansGUI human){
        if(!this.type.equals("BigScout")) {
            int xd = this.x - human.getX();
            int yd = this.y - human.getY();
            if (xd > yd && xd > 0) {
                this.x -= 1;
            } else if (yd < xd && yd < 0) {
                this.y += 1;
            } else if (xd < yd && xd < 0) {
                this.x += 1;
            } else if (yd > xd && yd > 0) {
                this.y -= 1;
            }
        }


    }
}
