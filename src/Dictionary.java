import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words;

    /**
     * Constructs a Dictionary list of the words.
     *
     * @param words : list of words.
     */
    public Dictionary(ArrayList<Word> words) {
        this.words = words;
    }

    /**
     * Constructs Dictionary empty.
     */
    public Dictionary() {
        this.words = new ArrayList<>();
    }

    /**
     * an English Word object.
     *
     * @param englisWord : English word.
     * @return : list , null.
     */
    public Word getWord(String englisWord) {
        for (Word list : words) {
            if (list.getEnglishWord().equalsIgnoreCase(englisWord)) {
                return list;
            }
        }
        return null;
    }

    /**
     * a meaning Word object.
     *
     * @param meaning : meaning.
     * @return : list, null.
     */
    public Word getMeaning(String meaning) {
        for (Word list : words) {
            if (list.getMeaning().equalsIgnoreCase(meaning)) {
                return list;
            }
        }
        return null;
    }

    /**
     * List of words.
     *
     * @return : words.
     */
    public ArrayList<Word> getWords() {
        return words;
    }


}
