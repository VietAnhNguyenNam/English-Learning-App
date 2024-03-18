public class Word {
    private String englishWord;
    private String meaning;

    /**
     * Contructor Word.
     *
     * @param englishWord : English word.
     * @param meaning     : meaning of the word.
     */


    public Word(String englishWord, String meaning) {
        this.englishWord = englishWord;
        this.meaning = meaning;

    }

    /**
     * Get the English Word.
     *
     * @return : English Word.
     */

    public String getEnglishWord() {
        return englishWord;
    }

    /**
     * Set the English Word.
     *
     * @param englishWord : english word.
     */

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    /**
     * Get the meaning of the word.
     *
     * @return : meaning of word.
     */

    public String getMeaning() {
        return meaning;
    }

    /**
     * Set the meaning of the word.
     *
     * @param meaning : meaning of word.
     */

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }


}
