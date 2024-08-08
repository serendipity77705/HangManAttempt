import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FourLetters {
    private ArrayList<String> fourLetterWords = new ArrayList<>();
    private int length;

    public FourLetters(){
        this.fourLetterWords.addAll(Arrays.asList( "four", "meat", "meet", "acts", "fast", "fact", "ants", "pant", "sock", "shoe", "mole", "lion",
                "meal", "sand", "wets", "core", "curl", "boil", "bill", "sail", "bail", "fail", "hail", "vice", "fang", "sang",
                "play", "slay", "cast", "past", "lost", "cost"));
        this.length = fourLetterWords.size();
    }

    public ArrayList<String> getFourLetterWords(){
        return this.fourLetterWords;
    }

    public void setFourLetterWords(ArrayList<String> fourLetterWords){
        this.fourLetterWords = fourLetterWords;
    }

    public int getLength(){
        return this.length;
    }

    public String randomWordGenerator() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.length);
        return this.fourLetterWords.get(randomIndex);
    }

}
