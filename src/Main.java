//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        // test game1
////        Game1 start = new Game1();
////        start.startGame();
//        // test game2
////        DictionaryCommandLine dictCMD = new DictionaryCommandLine();
////        dictCMD.dictionaryBasic();
////        ArrayList<Word> words = new ArrayList<>();
////        words.add(new Word("Fish", "cá"));
////        words.add(new Word("Cat", "mèo"));
////        words.add(new Word("Bird", "chim"));
////        words.add(new Word("Dog", "chó"));
////        words.add(new Word("Tiger", "hổ"));
////        words.add(new Word("Lion", "sư tử"));
////        words.add(new Word("Bear", "gấu"));
////        Dictionary dict = new Dictionary(words);
////
////
////        Game2 game = new Game2(dict);
////
////        game.playGame();
//
//        DictionaryCommandLine dictCMD = new DictionaryCommandLine();
//        dictCMD.dictionaryAdvanced();
//
//        Skanner.close();
//    }
//}


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // translate
        String text = "These are short, famous texts in English from classic sources like the Bible or Shakespeare. Some texts have word definitions and explanations to help you. Some of these texts are written in an old style of English. Try to understand them, because the English that we speak today is based on what our great, great, great, great grandparents spoke before! Of course, not all these texts were originally written in English. The Bible, for example, is a translation. But they are all well known in English today, and many of them express beautiful thoughts.";
        String text2 = "ông bụt chùa bùi cầm bùa đuổi chuột";
        System.out.println("Translated text: " + Translate.en2Vi(text));

        // dictionaryDB
        List<String> stringList = Database.findFirst10("app");
        for (final String word : stringList) {
            System.out.println(word);
        }
        System.out.println(Database.meaningOf("dictionary"));

        Skanner.close();
    }



}