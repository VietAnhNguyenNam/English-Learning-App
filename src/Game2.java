import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game2 extends Game {
    private Dictionary dict;

//    public Game2(Dictionary dictionary) {
//        this.dict = dictionary;
//    }



    public void playGame() {
        ArrayList<Word> words = dict.getWords();

        if (words.size() < 4) {
            System.out.println("Not enough words");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        Word wordChoice = words.get(randomIndex);
        String word = wordChoice.getEnglishWord();
        String definition = wordChoice.getMeaning();

        ArrayList<Word> choices = new ArrayList<>();
        choices.add(wordChoice);

        while (choices.size() < 4) {
            int randomChoiceIndex = random.nextInt(words.size());
            Word randomChoice = words.get(randomChoiceIndex);

            if (!choices.contains(randomChoice)) {
                choices.add(randomChoice);
            }
        }

        System.out.println("What is the definition of the word: " + word + "?");
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((char) ('A' + i) + ") " + choices.get(i).getMeaning());
        }

        System.out.print("Your choice [A/B/C/D]: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toUpperCase();

        int userChoiceIndex = userAnswer.charAt(0) - 'A';
        Word userChoice = choices.get(userChoiceIndex);

        if (userChoice.getEnglishWord().equalsIgnoreCase(word)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
            System.out.println("The correct answer is " + word + ": " + definition);
        }
    }
}