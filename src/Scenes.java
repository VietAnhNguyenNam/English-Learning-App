import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class Scenes {
    private static Stage stage;
    private static FXMLLoader mainLoader;
//    private static Scene mainScene;
    private static FXMLLoader lookupLoader;
//    private static Scene lookupScene;

    public static Stage getStage() {
        return stage;
    }

    private static Scene getScene(FXMLLoader fxmlLoader, String cssFile) {
        try {
            Scene scene = new Scene(fxmlLoader.load());
            if (!cssFile.isBlank()) {
                scene.getStylesheets().add(cssFile);
            }
            return scene;
        } catch (IOException e) {
            System.out.println("Cannot create scene.");
            e.printStackTrace();
        }
        return null;
    }

    public static Scene getMainScene() {
//        return mainScene;
        return getScene(mainLoader, "style.css");
    }

    public static Scene getLookupScene() {
//        return lookupScene;
        return getScene(lookupLoader, "style.css");
    }

    public static FXMLLoader getMainLoader() {
        return mainLoader;
    }

    public static FXMLLoader getLookupLoader() {
        return lookupLoader;
    }

    public Scenes(Stage stage) throws IOException {
        Scenes.stage = stage;

        mainLoader = new FXMLLoader(Main.class.getResource("graphic.fxml"));
//        mainScene = new Scene(mainLoader.load());
//        mainScene.getStylesheets().add("style.css");

        lookupLoader = new FXMLLoader(Main.class.getResource("lookup.fxml"));
//        lookupScene = new Scene(lookupLoader.load());
//        lookupScene.getStylesheets().add("style.css");

    }

    public static void switchScene(Scene scene) {
        stage.setScene(scene);
    }
}
