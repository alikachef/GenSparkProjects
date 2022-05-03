package com.section2;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        Random num = new Random();
        int min = 1;
        int count = 1;
        int max = 20;
        int result = num.nextInt(max - min) + min;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello! Whats your name? ");
        String userName = "\033[1m" + userInput.nextLine();

        System.out.println("\nWell, " + userName + " I am thinking of a number between 1 to 20");
        System.out.println("Take a guess ");

        try {

            String answer = userInput.next();
            int ans = Integer.parseInt(answer);

            while (result != ans) {
                ans = Integer.parseInt(answer);
                if (ans > result) {
                    System.out.println("\nYour guess is too high ");
                    System.out.println("Guess again ");

                    answer = userInput.next();
                }
                else if (ans < result)
                {
                    System.out.println("\nYour guess is too low ");
                    System.out.println("Guess again ");

                    answer = userInput.next();
                }
                else
                {
                    System.out.println("\nCongratulation you have guessed the number");
                    System.out.println("It took you " + count + " tries to guess my number");
                }

                count++;
            }
        }
        catch (NumberFormatException msg){
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage() );
        }

    }
}