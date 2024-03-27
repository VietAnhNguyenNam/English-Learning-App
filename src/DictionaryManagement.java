import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryManagement {
    private Dictionary dict;

    public Dictionary getDict() {
        return dict;
    }

    public DictionaryManagement(Dictionary dict) {
        this.dict = dict;
    }

    public DictionaryManagement() {
        dict = new Dictionary();
    }

    public void insertFromCommandline() {
        System.out.print("Enter number of words: ");
        int numberOfWords;
        numberOfWords = Skanner.getScanner().nextInt();
        Skanner.getScanner().nextLine();
        enterWords(numberOfWords);
    }

    public boolean addWord(String englishWord, String meaning) {
        return dict.getWords().add(new Word(englishWord, meaning));
    }

    public boolean removeWord(String englishWord) {
        return dict.getWords().removeIf(word -> word.getEnglishWord().equals(englishWord));
    }

    public boolean editEnglishWord(String oldEnglishWord, String newEnglishWord, String newMeaning) {
        boolean exist = false;
        for (Word w : dict.getWords()) {
            if (w.getEnglishWord().equals(oldEnglishWord)) {
                w.setEnglishWord(newEnglishWord);
                w.setMeaning(newMeaning);
                exist = true;
            }
        }
        return exist;
    }

    public boolean editMeaning(String oldMeaning, String newEnglishWord, String newMeaning) {
        boolean exist = false;
        for (Word w : dict.getWords()) {
            if (w.getMeaning().equals(oldMeaning)) {
                w.setEnglishWord(newEnglishWord);
                w.setMeaning(newMeaning);
                exist = true;
            }
        }
        return exist;
    }

    private void enterWords(int n) {
        String englishWord, meaning;
        for (int i = 0; i < n; i++) {
            System.out.print("Word: ");
            englishWord = Skanner.getScanner().nextLine();
            System.out.print("Meaning: ");
            meaning = Skanner.getScanner().nextLine();
            dict.getWords().add(new Word(englishWord, meaning));
        }
    }

    public boolean insertFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("text/dictionaries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split("\t+");
                if (str.length == 2) {
                    addWord(str[0], str[1]);
                }
            }
            return true;
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("File does not exist.");
            return false;
        }
    }

    public List<Word> dictionaryLookup() {
        int choice;
        do {
            System.out.println("1. Find by english word\n2. Find by Vietnamese word");
            choice = Skanner.getScanner().nextInt();
            Skanner.getScanner().nextLine();
        } while (choice != 1 && choice != 2 );

        String ref;
        System.out.println("Enter reference word: ");
        ref = Skanner.getScanner().nextLine();
        List<Word> filteredWords = null;
        switch (choice) {
            case 1:
                filteredWords = getDict().getWords().stream().
                        filter(w -> w.getEnglishWord().equals(ref)).toList();
                return filteredWords;
            case 2:
                filteredWords = getDict().getWords().stream().
                        filter(w -> w.getMeaning().equals(ref)).toList();
                return filteredWords;
            default:
                return null;
        }
    }

    public boolean dictionaryExportToFile(boolean append) {
        try (FileWriter writer = new FileWriter("text/outputDictionary.txt", append)) {
            for (final Word w : getDict().getWords()) {
                writer.write(w.getEnglishWord() + "\t" + w.getMeaning() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error occurred. Cannot write to file.");
            return false;
        }
    }
}
