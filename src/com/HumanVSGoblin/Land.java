package HumanVSGoblin;

import java.util.Random;
import java.util.Scanner;

public class Land {
    private int size;

    private  int goblinNumber;
    public int getSize(){return size;}

    public  void setSize(int size){this.size = size;}
    public Land(int size){
        this.size = size;
    }

    public Land(){}
    public void generateLandE(Humans human, Goblin g1, Goblin g2, Goblin g3){
        Random num = new Random();
        int ran = num.nextInt(0, this.size-1);

        if (this.size <= 5) {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {

                    if (i == ran && j == ran ) {
                        System.out.print("|U|");
                        if(human.getX()==ran && human.getY() == ran) {
                            treasurChest(human, g1, g2, g3);
                        }
                        continue;
                    }

                    if (i == g1.getY() && j == g1.getX() && !g1.getDead()) {
                        printGoblin(g1.getType());
                        continue;
                    }

                    if (i == g3.getY() && j == g3.getX() && !g3.getDead()) {
                        printGoblin(g3.getType());
                        continue;
                    }
                    if (i == g2.getY() && j == g2.getX() && !g2.getDead()) {
                        printGoblin(g2.getType());
                        continue;
                    }

                    if (human.getY() == i && human.getX() == j) {
                        System.out.print("|*|");
                        continue;
                    }
                    System.out.print("|_|");
                }
                System.out.println();
            }
        }

    }
    public void printGoblin(String type){
        if(type.equals("Small")){
            System.out.print("|#|");
        }
        else if (type.equals("Big")) {
            System.out.print("|@|");
        }
        else if (type.equals("BigScout")) {
            System.out.print("|0|");
        } else
            System.out.println("S");
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

    public static void treasurChest(Humans human, Goblin g1, Goblin g2, Goblin g3){
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
