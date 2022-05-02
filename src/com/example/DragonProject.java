package com.example;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonProject {
    public static void main(String[] args) {
        int exitC = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Your Name Brave Traveler! ");
        String userName = "\033[1m" + userInput.nextLine();

        System.out.println(MessageFormat.format("{0}, You are in a land full of Dragons. In front of you,", userName));
        System.out.println("You see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is gready and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2): ");

        try {
            String answer = userInput.next();
            exitC = Integer.parseInt(answer);

            while (exitC != 0) {
                if (exitC == 1) {
                    System.out.println("You approach the cave...");
                    System.out.println("\nIt is dark and spooky...");
                    System.out.println("\nA large dragon jumps out in front of you! He opens his jaws ");
                    System.out.println("and...");

                } else if (exitC == 2) {
                    System.out.println("\nYou approach the cave...");
                    System.out.println("\na colorfull landscape is seen... ");
                    System.out.println("\nA beautiful dragon approaches you and offer you a flight");
                    System.out.println("\nto an island gold grow as much as grass");
                    System.out.println("\nor offers you a chest of gold filled to its rim (1 or 2) ");

                    String answer2 = userInput.next();
                    exitC = Integer.parseInt(answer2);

                    if (exitC == 1) {
                        System.out.println("You take the dragons back and the dragon takes off into the air");
                        System.out.println("\nat the peak of the horizon... ");
                        System.out.println("\nthe beautiful dragon spins and drops you to your death");
                        System.out.println("\nThe dragon speaks and tell you as your falling ");
                        System.out.println(MessageFormat.format("{0}, you became the greedy Beast", userName));

                    } else if (exitC == 2) {
                        System.out.println("You accepted the dragons chest and took the gold with you");
                        System.out.println("Gold in the chest was enough to last you a lifetime");
                        System.out.println(MessageFormat.format("{0}, You have passed the trial of the caves", userName));

                    } else {
                        System.out.println("you have entered a wrong value");
                    }
                } else
                    System.out.println("you have entered a wrong value");

                exitC = 0;
            }
        }
        catch (NumberFormatException msg){
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage() );
        }
    }
}
