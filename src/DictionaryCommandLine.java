import java.util.ArrayList;
import java.util.List;

public class DictionaryCommandLine {
    private DictionaryManagement dictMan;

    public DictionaryCommandLine(DictionaryManagement dictMan) {
        this.dictMan = dictMan;
    }

    public DictionaryCommandLine() {
        dictMan = new DictionaryManagement();
    }

    public DictionaryManagement getDictMan() {
        return dictMan;
    }

    public void showAllWords() {
        formatAndPrint(dictMan.getDict().getWords());
    }

    public void showListOfWords(ArrayList<Word> words) {
        formatAndPrint(words);
    }

    private void formatAndPrint(List<Word> words) {
        String no = "No", english = "English", vietnamese = "Vietnamese";
        int[] columnWidths = {no.length(), english.length(), vietnamese.length()};

        int i = 1;
        for (Word word : words) {
            int tmp = (int) (Math.log10(i) + 1);
            if (tmp > columnWidths[0]) {
                columnWidths[0] = tmp;
            }
            if (word.getEnglishWord().length() > columnWidths[1]) {
                columnWidths[1] = word.getEnglishWord().length();
            }
            if (word.getMeaning().length() > columnWidths[2]) {
                columnWidths[2] = word.getMeaning().length();
            }
            i++;
        }

        System.out.print("No");
        for (int j = 0; j < columnWidths[0] - no.length(); j++) {
            System.out.print(" ");
        }
        System.out.print(" | ");
        System.out.print("English");
        for (int j = 0; j < columnWidths[1] - english.length(); j++) {
            System.out.print(" ");
        }
        System.out.print(" | ");
        System.out.print("Vietnamese");
        for (int j = 0; j < columnWidths[2] - vietnamese.length(); j++) {
            System.out.print(" ");
        }
        System.out.println();

        i = 1;
        for (Word word : words) {
            System.out.print(i);
            for (int j = 0; j < columnWidths[0] - (int) (Math.log10(i) + 1); j++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.print(word.getEnglishWord());
            for (int j = 0; j < columnWidths[1] - word.getEnglishWord().length(); j++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.print(word.getMeaning());
            for (int j = 0; j < columnWidths[2] - word.getMeaning().length(); j++) {
                System.out.print(" ");
            }
            System.out.println();
            i++;
        }
    }

    public void dictionaryBasic() {
        dictMan.insertFromCommandline();
        showAllWords();
    }

    public void dictionarySearcher() {
        List<Word> words = getDictMan().dictionaryLookup();
        if (words.isEmpty()) {
            System.out.println("Word not found.");
        }
        else {
            formatAndPrint(words);
        }
    }

    public void game(Game game) {
        game.playGame();
    }

    public void dictionaryAdvanced() {
        System.out.println("Welcome to English Learning App!");
        do {
            System.out.println("\n[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
//        System.out.println("[5] Lookup");
            System.out.println("[5] Search");
            System.out.println("[6] Game");
            System.out.println("[7] Import from file");
            System.out.println("[8] Export to file");

            int choice;
            do {
                System.out.print("Your action: ");
                choice = Skanner.getScanner().nextInt();
                Skanner.getScanner().nextLine();
            } while (choice < 0 || choice > 9);

            switch (choice) {
                case 0:
                    return;
                case 1:
                    getDictMan().insertFromCommandline();
                    break;
                case 2:
                    System.out.print("Enter word to remove: ");
                    String word = Skanner.getScanner().nextLine();
                    boolean removed = getDictMan().removeWord(word);
                    if (removed) {
                        System.out.println("Word has been removed");
                    } else {
                        System.out.println("Word not found");
                    }
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 3:
                    System.out.println("1. Update english word");
                    System.out.println("2. Update Vietnamese meaning");
                    int updateChoice;
                    do {
                        System.out.print("Choice: ");
                        updateChoice = Skanner.getScanner().nextInt();
                        Skanner.getScanner().nextLine();
                    } while (updateChoice != 1 && updateChoice != 2);

                    if (updateChoice == 1) {
                        System.out.print("Enter english word to update: ");
                        String updateWord = Skanner.getScanner().nextLine();
                        List<Word> tmpList = getDictMan().findEnglishWords(updateWord);
                        System.out.println(tmpList.size() + " matched");
                        for (Word w : tmpList) {
                            System.out.println("Old word: " + w.getEnglishWord());
                            System.out.println("Meaning: " + w.getMeaning());
                            System.out.print("New word: ");
                            String newWord = Skanner.getScanner().nextLine();
                            getDictMan().editEnglishWord(w.getEnglishWord(), newWord, w.getMeaning());
                        }
                    } else {
                        System.out.print("Enter meaning word to update: ");
                        String updateMeaning = Skanner.getScanner().nextLine();
                        List<Word> tmpList = getDictMan().findVietnameseMeanings(updateMeaning);
                        System.out.println(tmpList.size() + " matched");
                        for (Word w : tmpList) {
                            System.out.println("Word: " + w.getEnglishWord());
                            System.out.println("Old meaning: " + w.getMeaning());
                            System.out.print("New meaning: ");
                            String newMeaning = Skanner.getScanner().nextLine();
                            getDictMan().editMeaning(w.getMeaning(), w.getEnglishWord(), newMeaning);
                        }
                    }
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 4:
                    showAllWords();
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 5:
                    dictionarySearcher();
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 6:
                    System.out.println("1. Game 1\n2. Game 2");
                    int gameChoice;
                    do {
                        System.out.print("Choice: ");
                        gameChoice = Skanner.getScanner().nextInt();
                        Skanner.getScanner().nextLine();
                    } while (gameChoice != 1 && gameChoice != 2);
                    Game game;
                    if (gameChoice == 1) {
                        game = new Game1();
                    } else {
                        game = new Game2();
                    }
                    game(game);
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 7:
                    if (getDictMan().insertFromFile()) {
                        System.out.println("Successfully imported from dictionaries.txt");
                    }
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                case 8:
                    System.out.println("1. Append\n2. Overwrite");
                    int exportChoice;
                    do {
                        System.out.print("Choice: ");
                        exportChoice = Skanner.getScanner().nextInt();
                        Skanner.getScanner().nextLine();
                    } while (exportChoice != 1 && exportChoice != 2);
                    boolean statusFlag;
                    if (exportChoice == 1) {
                        statusFlag = getDictMan().dictionaryExportToFile(true);
                    } else {
                        statusFlag = getDictMan().dictionaryExportToFile(false);
                    }
                    if (statusFlag) {
                        System.out.println("Successfully wrote to outputDictionary.txt");
                    }
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
                default:
                    System.out.println("Action not supported.");
                    System.out.println("\nPress any key to continue.");
                    Skanner.getScanner().nextLine();
                    break;
            }
        } while (true);

    }
}
