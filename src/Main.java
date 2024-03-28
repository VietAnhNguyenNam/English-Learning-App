import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test game1
//        Game1 start = new Game1();
//        start.startGame();
        // test game2
        DictionaryCommandLine dictCMD = new DictionaryCommandLine();
        dictCMD.dictionaryBasic();
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Fish", "cá"));
        words.add(new Word("Cat", "mèo"));
        words.add(new Word("Bird", "chim"));
        words.add(new Word("Dog", "chó"));
        words.add(new Word("Tiger", "hổ"));
        words.add(new Word("Lion", "sư tử"));
        words.add(new Word("Bear", "gấu"));
        Dictionary dict = new Dictionary(words);


        Game2 game = new Game2(dict);

        game.playGame();

        Skanner.close();

    }
}