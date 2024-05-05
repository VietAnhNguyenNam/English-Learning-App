import java.util.Scanner;
import java.util.Random;
public class Game2 extends Game{
    private Scanner scanner;
    private Random random;
    private String data[];
    private boolean weArePlaying;

    public void HangmanGame() {
        scanner = new Scanner(System.in);
        random = new Random();

        data = new String[]{
                "MEXICO COUNTRY",
                "HEDWIG BIRD",
                "KUAKATA BEACH",
                "CANADA COUNTRY",
                "DOCTOR PROFESSION",
                "FOOTBALL GAME",
                "TEACHER MENTOR",
                "LEOPARD ANIMAL",
                "BICYCLE TRANSPORT",
                "SALMON FISH",
                "SPARROW BIRD",
                "PARROTS BIRD",
                "EAGLE BIRD",
                "TRAIN TRANSPORT",
                "SHIP TRANSPORT",
                "ENGINEER PROFESSION",
                "BANKER PROFESSION",
                "CRICKET GAME"};
        weArePlaying = true;
    }

    @Override
    void playGame() {
        while (weArePlaying) {
            System.out.println("Let's Start Playing Hangman ver 0.1");
            int randomNumber = random.nextInt(data.length);
            char randomWordToGuess[] = data[randomNumber].toCharArray();
            int amountOfGuesses = randomWordToGuess.length;
            char playerGuess[] = new char[amountOfGuesses];

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfGuesses) {
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d amount of tries left.\n", amountOfGuesses - tries);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if (input == '-') {
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            }

            if (!wordIsGuessed) {
                System.out.println("You ran out of guesses.");
            }

            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if (choice.equals("no")) {
                weArePlaying = false;
            }
        }

        System.out.println("Game Over!");
    }

    public void print(char array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean isTheWordGuessed(char[] array) {
        for (char c : array) {
            if (c == '_') {
                return false;
            }
        }
        return true;

    }
}