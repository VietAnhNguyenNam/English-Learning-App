import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.collections.MapChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.mindrot.jbcrypt.BCrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scenes scenes = new Scenes(stage);

        stage.setTitle("English Learning App");
        stage.setScene(Scenes.getLoginScene());
        stage.show();

    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        DictionaryCommandLine dictCmd = new DictionaryCommandLine();
//        dictCmd.dictionaryAdvanced();
//    }
//
//
//}