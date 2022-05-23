package HumanVSGoblin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Land playingFeild = new Land(5);
        Humans humans = new Humans("ali", "BareHands", 100, 0, playingFeild.getSize() -1);
        Goblin g1 = new Goblin("Small", 30, 3,2, false);
        Goblin g2 = new Goblin("BigScout", 70, playingFeild.getSize() - 2, 0, false);
        Goblin g3 = new Goblin("Big", 60, 0,0, false);

        playingFeild.initateGame();
        Scanner userInput = new Scanner(System.in);

        while (!humans.getIsDead()){
            playingFeild.generateLandE(humans, g1, g2, g3);
            System.out.println("Enter your next move... ");
            String pos = userInput.nextLine();
            humans.movePlayer(pos);
            g1.GoblinTurn(humans);
            g3.GoblinTurn(humans);
        }
        System.out.println("you lost");
    }
}
