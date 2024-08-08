/**
 * it got too confusing and tiring to see all the print statements and their lengths, so I put them in a class.
 * was there a bettr way to do this? probably but i don't really care.
 */
public class PrintStatements {
    private String introduction;
    private String guesses;
    private String four;
    private String five;
    private String six;

    public PrintStatements(){
        this.introduction = "Welcome! There are two ways of play: either play until you get the word right, or have a " +
                "limited number (5) of tries. Which would you like to do? \n " +
                "(u) unlimited tries \n " +
                "(f) five tries \n";
        this.guesses = "Please indicate how long you want the word you guess to be: \n" +
                " (4) letters long \n" +
                " (5) letters long \n" +
                " (6) letters long";
        this.four = "Guess the 4-letter word letter by letter!";
        this.five = "Guess the 5-letter word letter by letter!";
        this.six = "Guess the 6-letter word letter by letter!";
    }

    public String getIntroduction(){
        return this.introduction;
    }

    public String getGuesses(){
        return this.guesses;
    }

    public String getFour(){
        return this.four;
    }

    public String getFive(){
        return this.five;
    }
    public String getSix(){
        return this.six;
    }
}
