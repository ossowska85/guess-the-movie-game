import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class GuessTheMovieGame {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("movie");
        Scanner scanner = new Scanner(file);
        int numbersOfMovie = 0;

        while (scanner.hasNextLine()) {
            String movieName = scanner.nextLine();
            numbersOfMovie++;
        }

        int indexOfRandomMovie = (int) (Math.random() * numbersOfMovie);

        String randomMovie = "";
        Scanner scanner1 = new Scanner(file);
        int index =0;
        while (scanner1.hasNextLine()){
            String movieName = scanner1.nextLine();
            if(index==indexOfRandomMovie){
                randomMovie = movieName;
            }
            index++;
        }

        String guessMovie = "";
        for (int i = 0; i < randomMovie.length(); i++) {
            if (randomMovie.charAt(i) != ' ') {
                guessMovie = guessMovie + '-';
            } else {
                guessMovie = guessMovie + ' ';
            }
        }
        System.out.println(guessMovie);

        char[] guessMovieChars = guessMovie.toCharArray();
        char[] randomMovieChars = randomMovie.toCharArray();

        Scanner charScaner = new Scanner(System.in);

        int countWrongLetter=0;
        String wrongLetters = " ";
        boolean hasWon = false;
        while(countWrongLetter<10 && !hasWon){
            char givenLetter = charScaner.next().charAt(0);
            System.out.println("Guess a letter: " + givenLetter);
            boolean isLetter = false;
            for (int j = 0; j < randomMovieChars.length; j++) {
                if (givenLetter == randomMovieChars[j]) {
                    guessMovieChars[j] = givenLetter;
                    isLetter=true;
                    if (Arrays.equals(randomMovieChars, guessMovieChars)){
                        hasWon = true;
                        break;
                    }
                }
            }
            if(!isLetter){
                countWrongLetter++;
                wrongLetters= wrongLetters+givenLetter+' ';
            }
            System.out.println("You have guesses (" + countWrongLetter+") wrong letters: " + wrongLetters);
            System.out.println(new String(guessMovieChars));

        }

        if (hasWon){
            System.out.println("You win!!!");
            System.out.println("You guessed: "+ randomMovie +" correctly!");
        } else {
            System.out.println("You lose...");
            System.out.println("The right answer is: " + randomMovie);
        }

    }

}
