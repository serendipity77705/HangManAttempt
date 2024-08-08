import java.sql.Array;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuilder;


//make the PrintStatements variables instead of whole classes.
public class HangMan {
    // colors for guesses
    public static void main(String[] args) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";

        Scanner in = new Scanner (System.in);

        // string variables
        String choice = "Please make your choice:";
        String introduction = "Welcome! There are two ways of play: either play until you get the word right, or have a " +
                "limited number (5) of tries. Which would you like to do? \n " +
                "(u) unlimited tries \n " +
                "(f) five tries \n";
        String guessLengthChoices = "Please indicate how long you want the word you guess to be: \n" +
                " (4) letters long \n" +
                " (5) letters long \n" +
                " (6) letters long";
        String fourLetterPrintStatement = "Guess the 4-letter word letter by letter!";
        String fiveLetterPrintStatement = "Guess the 5-letter word letter by letter!";
        String sixLetterPrintStatement = "Guess the 6-letter word letter by letter!";
        StringBuilder fourLetterGuess = new StringBuilder("____");
        StringBuilder fiveLetterGuess = new StringBuilder("_____");
        StringBuilder sixLetterGuess = new StringBuilder("______");

        int wordLength;
        String gameChoice;

        FourLetters four = new FourLetters();
        PrintStatements statement = new PrintStatements();



        boolean correct;
        boolean wordGuessed = false;
        ArrayList<Character> lettersGuessed = new ArrayList<>();

        int guessesLeft = 5;
        int numberOfGuesses = 0;

        String guess;

        int guessIndex;
        int sizeOfGuesses;

        System.out.println(statement.getIntroduction());
        System.out.println(choice);
        gameChoice = in.next();
        if(gameChoice.equals("u")){
            System.out.println("Game choice: unlimited tries");
            System.out.println(statement.getGuesses());
            wordLength = in.nextInt();
            if(wordLength == 4) {
                String randomWord = four.randomWordGenerator();
//                System.out.println(randomWord);
                lengthOfWord(wordLength, statement, fourLetterGuess, four);
                while(fourLetterGuess.indexOf("_") != -1){
                    guess = in.next();
                    char guessedChar = guess.charAt(0);
                    if(!lettersGuessed.contains(guessedChar)){
                        lettersGuessed.add(guessedChar);
                        numberOfGuesses++;
                    } else {
                        System.out.println("You already guessed this");
                        continue;
                    }
                    System.out.println("Letters guessed so far: " + lettersGuessed);
                    System.out.println("Guesses so far: " + numberOfGuesses);
                    if(randomWord.contains(guess)) {
                        System.out.println(GREEN + "Correct!" + RESET);
                        for(int i = 0; i < wordLength; i++){
                            if(randomWord.charAt(i) == guessedChar){
                                fourLetterGuess.replace(i, i + 1, guess);
                            }
                        }
                        System.out.println(fourLetterGuess);
                    } else {
                        System.out.println(RED + "Incorrect. Try again." + RESET);
                    }
                }
                System.out.println("Congratulations! You guessed the right word! \nGuesses it took to reach final answer: " + numberOfGuesses);
            } else if(wordLength == 5){
                System.out.println(statement.getFive());
                System.out.println(fiveLetterGuess);
            } else if(wordLength == 6){
                System.out.println(statement.getSix());
                System.out.println(sixLetterGuess);
            }
        } else if(gameChoice.equals("f")){
            System.out.println("Game choice: five tries only.");
            System.out.println(statement.getGuesses());
            wordLength = in.nextInt();
            if(wordLength == 4){
                String randomWord = four.randomWordGenerator();
//                System.out.println(randomWord);
                lengthOfWord(wordLength, statement, fourLetterGuess, four);
                while(fourLetterGuess.indexOf("_") != -1){
                    if(guessesLeft > 0){
                        guess = in.next();
                        char guessedChar = guess.charAt(0);
                        guessesLeft = repeatGuess(wordLength, fourLetterGuess, randomWord, guess, guessedChar, guessesLeft, lettersGuessed);
                    } else if(guessesLeft == 0){
                        System.out.println("womp womp womp... you couldn't guess the word. it is: " + randomWord);
                        break;
                    }
                }
            }
        }
    }

    public static int repeatGuess(int wordLength, StringBuilder fourGuess, String randomWord, String guess, char guessedLetter, int left, ArrayList<Character> guesses){
        /*
         * what i want:
         * if: randowmword contains guess AND guess wasn't guessed before:
         * "Correct!"
         * else if: randomrod contains guess and guess WAS guessed before:
         * "you already guessed this and you can't guess it again", guesses left doesn't change
         * else if randomword DOESNT contain guess :
         * "you're wrong. guess again"
         */

        if (!guesses.contains(guessedLetter)){
            guesses.add(guessedLetter);
            if (randomWord.contains(guess)){
                System.out.println("Correct!");
                for(int i = 0; i < wordLength; i++){
                    if(randomWord.charAt(i) == guessedLetter){
                        fourGuess.replace(i, i+1, guess);
                    }
                }
            } else {
                System.out.println("Incorrect. Try again.");
                left--;
                System.out.println("Guesses left: " + left);
            }
        } else {
            System.out.println("You already guessed this.");
            System.out.println("Guesses left: " + left);
        }
        return left;
    }

    public static void lengthOfWord(int choice, PrintStatements statement, StringBuilder fourLetterGuess, FourLetters four){
        if(choice == 4){
            System.out.println(statement.getFour());
            System.out.println(fourLetterGuess);
        } else if(choice == 5){

        } else if(choice == 6){

        }
    }
}