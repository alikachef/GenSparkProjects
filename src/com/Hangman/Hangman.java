package Hangman;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Hangman {
    private  static HttpURLConnection connection;

    public static void main(String args[]) throws IOException {




        int tries = 0;
        int exitCode = 1;
        int score = 0;
        String word = movieName();
        String test = "";
        List<Character> playerGuess = new ArrayList<>();

        playerGuess.add(' ');
        playerGuess.add('\'');
        Scanner userInput = new Scanner(System.in);
        Scanner toPrint = new Scanner(new File("src/com/Hangman/Assets/scores.txt"));

        System.out.print("Enter your name: ");
        String name = userInput.nextLine();
        System.out.println();
        System.out.println(String.format("Welcome %s To", name.trim() ));




        System.out.println("   "+"H A N G M A N");
        System.out.println("       "+"+---+");
        System.out.println("       "+"    |");
        System.out.println("       "+"    |");
        System.out.println("       "+"    |");
        System.out.println("       "+"   ===");
        if (toPrint.hasNext()) {
             test = toPrint.nextLine();
            System.out.println(test);
        }

        System.out.println("Press Enter to Start...");
        userInput.nextLine();


        printWordState(word, playerGuess, tries);
        while ( true){
            if(tries >= 6){
                System.out.println("You have lost");
                break;
            }
            if(!userGuess(userInput, word,playerGuess, score, name)){
                score -= 20;
                tries++;
            }
            else {
                score += 20;
            }
            if(printWordState(word, playerGuess, tries)){
                try {
                    if (Integer.parseInt(test.substring(test.lastIndexOf(" ")).trim()) < score) {
                        FileWriter toWrite = new FileWriter("src/com/Hangman/Assets/scores.txt");
                        toWrite.write("Highest Score: " + name + ", Score: " + score);
                        toWrite.close();
                    }
                }
                catch (Exception e){
                    System.out.println("Something went wrong");
                }
                System.out.println("You Win!");
                break;
            }
        }

    }
    public static String movieName() throws FileNotFoundException {
        Random rand = new Random();
        Scanner scanner = new Scanner(new File("src/com/Hangman/Assets/moviesList.txt"));
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }

        String word = words.get(rand.nextInt(words.size())).toLowerCase();

        return word;
    }

    private static boolean printWordState(String word, List<Character> playerGuess, int tries) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/com/Hangman/Assets/hangman.txt"));
        ArrayList<String> drawing = new ArrayList<>();
        while (file.hasNext()){
            drawing.add(file.nextLine());
        }
        int correctCount = 0;
        System.out.println();

        switch (tries){
            case 0:
                drawing.subList(0,5).forEach(System.out::println);
                break;
            case 1:
                drawing.subList(5,10).forEach(System.out::println);
                break;
            case 2:
                drawing.subList(10,15).forEach(System.out::println);
                break;
            case 3:
                drawing.subList(15,20).forEach(System.out::println);
                break;
            case 4:
                drawing.subList(20,25).forEach(System.out::println);
                break;
            case 5:
                drawing.subList(25,30).forEach(System.out::println);
                break;
            case 6:
                drawing.subList(30,35).forEach(System.out::println);
                break;
        }

        for( int i = 0; i < word.length(); i++){
            if(playerGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println();
        return (word.length() == correctCount);
    }

    private  static boolean userGuess(Scanner userInput, String word, List<Character> playerGuess, int score, String name){
        System.out.println(name + ", Score: " + score);
        System.out.print("Enter a letter: ");
        String letterGuess = userInput.nextLine();
        playerGuess.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }



}
