import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonProject {
    public static void main(String[] args) {
        int exitC = 0;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Your Name Brave Traveler");

        String userName = userInput.nextLine();
        userName = userName.replaceAll("[^a-zA-Z]", "");

        System.out.println(MessageFormat.format("{0}, You are in a land full of Dragons. In front of you,", userName));
        System.out.println("You see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is gready and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2): ");

        try {
            String answer2 = getUserChoice(userInput.nextInt());
            String answer3 = level2(userInput.nextInt());
        } catch (InputMismatchException msg) {
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage());
        }
    }
    public static String getUserChoice (int s){
        try {
            if (s == 1) {
                System.out.println("\nYou approach the cave...");
                System.out.println("\nIt is dark and spooky...");
                System.out.println("\nA large dragon jumps out in front of you! He opens his jaws ");
                System.out.println("\nand...");

                return ("Cave 1 was selected, user died");
            }

            if (s == 2) {
                System.out.println("\nYou approach the cave...");
                System.out.println("\na colorfull landscape is seen... ");
                System.out.println("\nA beautiful dragon approaches you and offer you a flight");
                System.out.println("\nto an island gold grow as much as grass");
                System.out.println("\nor offers you a chest of gold filled to its rim (1 or 2) ");

                return ("Cave 2 was selected, user lived");
            }
            else {
                return ("you have entered a wrong value");
            }
        }
        catch (NumberFormatException msg) {
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage());
            return ("you have entered a wrong value");
        }
    }
    public static String level2 (int s){
        try {
            if (s == 1) {
                System.out.println("\nYou take the dragons back and the dragon takes off into the air");
                System.out.println("\nat the peak of the horizon... ");
                System.out.println("\nthe beautiful dragon spins and drops you to your death");
                System.out.println("\nThe dragon speaks and tell you as your falling ");
                System.out.println("\nyou became the greedy Beast");

                return ("Cave 1 was selected, user died");

            }
            else if (s == 2) {
                System.out.println("\nYou accepted the dragons chest and took the gold with you");
                System.out.println("\nGold in the chest was enough to last you a lifetime");
                System.out.println("\nYou have passed the trial of the caves");

                return ("Cave 2 was selected, user lived");
            }
            else {
                return ("you have entered a wrong value");
            }
        }
        catch (NumberFormatException msg) {
            System.out.println("ERROR! you have entered a wrong value type " + msg.getMessage());
        }
        return ("you have entered a wrong value");
    }
}


