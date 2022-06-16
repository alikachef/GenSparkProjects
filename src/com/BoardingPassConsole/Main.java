package BoardingPassConsole;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Name");
        String name = userInput.nextLine();

        System.out.println("Enter Gender");
        String gender = userInput.nextLine();

        System.out.println("Enter age");
        String age = userInput.nextLine();

        System.out.println("Enter Email");
        String email = userInput.nextLine();

        System.out.println("Enter Phone Number");
        String phone = userInput.nextLine();

        System.out.println("Choose Flight Class (B for Business or E for Economy)");
        String type = userInput.nextLine();

        System.out.println("Enter From Location");
        String from = userInput.nextLine();

        System.out.println("Enter Destination");
        String destination = userInput.nextLine();



       BoardingPass pass1 = new BoardingPass(type, name,  from, destination,age,email,gender, phone);
       pass1.generatePass();
       pass1.calculateEta();
       pass1.claculateCost();
       pass1.writeImage();

    }
}
