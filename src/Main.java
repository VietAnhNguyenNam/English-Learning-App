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


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application {

    public static void main(String[] args) {
//        System.out.println(Translate.en2Vi("English"));
        launch();

    }


    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader mainFXML = new FXMLLoader(Main.class.getResource("graphic.fxml"));
//        Scene mainScene = new Scene(mainFXML.load());
//        mainScene.getStylesheets().add("style.css");
//
//
//        stage.setScene(mainScene);
//        stage.show();
        FXMLLoader mainFXML = new FXMLLoader(Main.class.getResource("game1.fxml"));
        Scene mainScene = new Scene(mainFXML.load());



        stage.setScene(mainScene);
        stage.show();
    }
}