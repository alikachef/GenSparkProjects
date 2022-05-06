import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static Scanner userInput = new Scanner(System.in);
    static Random num = new Random();
    static int min = 1;
    static int max = 20;
    static int result = num.nextInt(max - min) + min;
    static int count = 0;

    public static void main(String[] args) {

        System.out.println("Hello! Whats your name? ");
        String userName = userInput.nextLine();
        userName = userName.replaceAll("[^a-zA-Z]", "");

        System.out.println("\nWell " + userName + ", I am thinking of a number between 1 to 20");
        System.out.println("Take a guess (enter a number between 1 to 20) ");


        try {
            String ans = getnumber(userInput.nextInt());
            while (Integer.parseInt(ans) != result) {
                ans = getnumber(userInput.nextInt());
            }
        }
        catch (InputMismatchException msg){
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage());
        }

    }


    public static String getnumber(int i) {
        count++;

        try {

            if (i > result) {
                System.out.println("\nYour guess is too high ");
                System.out.println("Guess again ");

                return Integer.toString(i);
            }
            else if(i < result)   {
                System.out.println("\nYour guess is too low ");
                System.out.println("Guess again ");

                return Integer.toString(i);
            }
            else {
                System.out.println("\nCongratulation you have guessed the number");
                System.out.println("It took you " + count + " tries to guess my number");
                return Integer.toString(i);
            }

        }
        catch (NumberFormatException msg) {
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage());
            return ("something went wrong");
        }

    }
}
