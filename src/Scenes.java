import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scenes {
    private static Stage stage;
    private static Scene mainScene;
    private static Scene loginScene;
    private static Scene signupScene;
    private static Scene homeScene;
    private static Scene lookupScene;
    private static Scene translateScene;
    private static Scene game1Scene;
    private static Scene assistantScene;


    public Scenes(Stage stage) throws IOException {
        Scenes.stage = stage;
//        stage.setUserData(2);
//        System.out.println(stage.getUserData());

//        mainScene = getNewMainScene();
        homeScene = getNewHomeScene();
        loginScene = getNewLoginScene();
        signupScene = getNewSignupScene();
        lookupScene = getNewLookupScene();
        translateScene = getNewTranslateScene();
        game1Scene = getNewGame1Scene();
        assistantScene = getNewAssistantScene();

//        FXMLLoader mainLoader = ;
//        mainScene = new Scene((new FXMLLoader(Scenes.class.getResource("graphic.fxml"))).load());
//        FXMLLoader lookupLoader = new FXMLLoader(Scenes.class.getResource("lookup.fxml"));
//        lookupScene = new Scene(lookupLoader.load());
//        FXMLLoader translateLoader = new FXMLLoader(Scenes.class.getResource("translate.fxml"));
//        translateScene = new Scene(translateLoader.load());
//        FXMLLoader game1Loader = new FXMLLoader(Scenes.class.getResource("game1.fxml"));
//        game1Scene = new Scene(game1Loader.load());

    }

    // get window
    public static Stage getStage() {
        return stage;
    }


    // get available scenes
    public static Scene getMainScene() {
        return mainScene;
    }

    public static Scene getHomeScene() {
        return homeScene;
    }

    public static Scene getLookupScene() {
        return lookupScene;
    }

    public static Scene getGame1Scene() {
        return game1Scene;
    }

    public static Scene getTranslateScene() {
        return translateScene;
    }

    public static Scene getAssistantScene() {
        return assistantScene;
    }

    public static Scene getLoginScene() {
        return loginScene;
    }

    public static Scene getSignupScene() {
        return signupScene;
    }

    // get new scenes
    public static Scene getNewMainScene() {
        mainScene = getScene("graphic.fxml", "style.css");
        return mainScene;
    }

    public static Scene getNewHomeScene() {
        homeScene =  getScene("home.fxml", "style.css");
        return homeScene;
    }

    public static Scene getNewLookupScene() {
        lookupScene = getScene("lookup.fxml", "style.css");
        return lookupScene;
    }

    public static Scene getNewGame1Scene() {
        game1Scene = getScene("game1.fxml", "style.css");
        return game1Scene;
    }

    public static Scene getNewTranslateScene() {
        translateScene = getScene("translate.fxml", "style.css");
        return translateScene;
    }

    public static Scene getNewAssistantScene() {
        assistantScene = getScene("assistant.fxml", "style.css");
        return assistantScene;
    }

    public static Scene getNewLoginScene() {
        loginScene = getScene("login.fxml", "style.css");
        return loginScene;
    }

    public static Scene getNewSignupScene() {
        signupScene = getScene("signup.fxml", "style.css");
        return signupScene;
    }

    public static void switchScene(Scene scene) {
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
    }

    private static Scene getScene(String fxmlFile, String cssFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Scenes.class.getResource(fxmlFile));
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
}
