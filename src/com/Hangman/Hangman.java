package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.*;


public class Hangman {
    private  static HttpURLConnection connection;

    public static void main(String args[]) throws IOException {

        /*
        BufferedReader buff;
        String line;
        String test = "";
        StringBuffer response = new StringBuffer();
        ArrayList<String> new1 =new ArrayList<>();

        URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=e2ff427596ef51cec2bcc354273cfdd0");
        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = buff.readLine()) != null){
            System.out.println(line);
        }
         */

        int tries = 0;
        int exitCode = 1;
        String word = movieName();
        Scanner userInput = new Scanner(System.in);
        List<Character> playerGuess = new ArrayList<>();
        playerGuess.add(' ');
        playerGuess.add('\'');

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
        System.out.println("Press Enter to Start...");
        userInput.nextLine();

        printWordState(word, playerGuess, tries);
        while ( true){
            if(tries >= 6){
                System.out.println("You have lost");
                break;
            }
            if(!userGuess(userInput, word,playerGuess)){
                tries++;
            }
            if(printWordState(word, playerGuess, tries)){
                System.out.println("You Win!");
                break;
            }
        }

    }
    public static String movieName() throws FileNotFoundException {
        Random rand = new Random();
        Scanner scanner = new Scanner(new File("src/com/Hangman/moviesList.txt"));
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }

        String word = words.get(rand.nextInt(words.size())).toLowerCase();

        return word;
    }

    private static boolean printWordState(String word, List<Character> playerGuess, int tries){
        int correctCount = 0;
        System.out.println();

        switch (tries){
            case 0:
                System.out.println("       "+"+---+");
                System.out.println("       "+"    |");
                System.out.println("       "+"    |");
                System.out.println("       "+"    |");
                System.out.println("       "+"   ===");
                break;
            case 1:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("       "+"    |");
                System.out.println("       "+"    |");
                System.out.println("       "+"   ===");
                break;
            case 2:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("      \\"+"    |");
                System.out.println("       "+"    |");
                System.out.println("       "+"   ===");
                break;
            case 3:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("      \\"+" /  |");
                System.out.println("       "+"    |");
                System.out.println("       "+"   ===");
                break;
            case 4:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("      \\"+" /  |");
                System.out.println("       "+"|   |");
                System.out.println("       "+"   ===");
                break;
            case 5:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("      \\"+" /  |");
                System.out.println("       "+"|   |");
                System.out.println("      /"+"   ===");
                break;
            case 6:
                System.out.println("       "+"+---+");
                System.out.println("       "+"O   |");
                System.out.println("      \\"+" /  |");
                System.out.println("       "+"|   |");
                System.out.println("      /"+" \\ ===");
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

    private  static boolean userGuess(Scanner userInput, String word, List<Character> playerGuess){
        System.out.print("Enter a letter: ");
        String letterGuess = userInput.nextLine();
        playerGuess.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

}
