public class DictionaryCommandLine {
    private DictionaryManagement dictMan;

    public DictionaryCommandLine(DictionaryManagement dictMan) {
        this.dictMan = dictMan;
    }

    public DictionaryCommandLine() {
        dictMan = new DictionaryManagement();
    }

    public void showAllWords() {
        String no = "No", english = "English", vietnamese = "Vietnamese";
        int[] columnWidths = {no.length(), english.length(), vietnamese.length()};

        int i = 1;
        for (Word word : dictMan.getDict().getWords()) {
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
        for (Word word : dictMan.getDict().getWords()) {
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
}
