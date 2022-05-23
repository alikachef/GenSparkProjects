package HumanVSGoblin;

import java.util.Random;

public class Goblin {
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

    public Goblin(String type, int health, int gridPosX, int gridPosY, boolean isDead){
        this.type = type;
        this.health = health;
        this.isDead = isDead;
        this.x = gridPosX;
        this.y = gridPosY;
    }

    public void damagedByBareHand(Humans human){
        this.health -= 5;

        if(this.health <= 0){
            this.health = 0;
        }
        System.out.println(this.type + " Goblin Got hit by Bare hands." + this.type + " Goblin Health reduced by 15. " + " Goblin's Health " + this.health );

        if (this.health == 0){
            System.out.println(this.type + " Goblin is dead");
            this.isDead = true;
            this.bareHandDrop(human);
        }

    }

    public void damagedBySword(Humans human){
        this.health -= 15;

        if(this.health <= 0){
            this.health = 0;
        }
        System.out.println(this.type + " Goblin Got hit by Sword." + this.type + " Goblin Health reduced by 20. " + " Goblin's Health " + this.health );

        if (this.health == 0){
            System.out.println(this.type + " Goblin is dead");
            this.isDead = true;
            this.swordDrops(human);
        }
    }

    public void bareHandDrop(Humans human){
        if(isDead == true){
            Random dice = new Random();
            int ranNum = dice.nextInt(1,6);
            int ranNum1 = dice.nextInt(1,6);

            if (ranNum > ranNum1){
                human.setEquipment("Sword");
                System.out.println("Goblin Dropped Sword");
                System.out.println("Player Picked Sword Up");
            } else if (ranNum < ranNum1) {
                human.setHealth(human.getHealth() + 25);
                System.out.println("Goblin Dropped a Heart");
                System.out.println("Player Ate the Heart:");
                System.out.println("Player Health: " + human.getHealth());
            }

        }
    }

    public void swordDrops(Humans human){
        if(isDead == true){
            Random dice = new Random();
            int ranNum = dice.nextInt(1,6);
            int ranNum1 = dice.nextInt(1,6);

            if (ranNum > ranNum1){
                human.setHealth(human.getHealth() + 25);
                System.out.println("Goblin Dropped a Heart");
                System.out.println("Player Ate the Heart:");
                System.out.println("Player Health: " + human.getHealth());
            } else
                System.out.println("Goblin Have no drops");

        }
    }

    public void GoblinTurn(Humans human){
        if (this.isDead == false){
        this.GoblinMove(human);
        if(human.getX() == this.x && human.getY() == this.y) {
            Random dice = new Random();
            int ranNum = dice.nextInt(1, 6);
            int ranNum1 = dice.nextInt(1, 6);

            if (ranNum > ranNum1) {
                if (human.getEquipment() == "Sword") {
                    this.damagedBySword(human);
                } else
                    this.damagedByBareHand(human);
            } else {
                if (this.getType() == "Big") {
                    human.damageByBigGoblin();
                } else
                    human.damageBySmallGoblin();
            }
        }
        }
    }
    public void scout(Land land){

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
    }
    public void GoblinMove(Humans human){
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
