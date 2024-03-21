import java.util.ArrayList;

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
}
