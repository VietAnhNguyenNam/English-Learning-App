import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scenes {
    private static Stage stage;

    private static Scene loginScene;
    private static Scene signupScene;
    private static Scene homeScene;
    private static Scene lookupScene;
    private static Scene translateScene;
    private static Scene gameScene;
    private static Scene assistantScene;
    private static Scene accountScene;

    // these loaders will get initialized with scenes in getNew...Scene() method
    private static FXMLLoader mainLoader;
    private static FXMLLoader loginLoader;
    private static FXMLLoader signupLoader;
    private static FXMLLoader homeLoader;
    private static FXMLLoader lookupLoader;
    private static FXMLLoader translateLoader;
    private static FXMLLoader gameLoader;
    private static FXMLLoader assistantLoader;
    private static FXMLLoader accountLoader;


    public Scenes(Stage stage) throws IOException {
        Scenes.stage = stage;

        homeScene = getNewHomeScene();
        loginScene = getNewLoginScene();
        signupScene = getNewSignupScene();
        lookupScene = getNewLookupScene();
        translateScene = getNewTranslateScene();
        gameScene = getNewGameScene();
        assistantScene = getNewAssistantScene();
        accountScene = getNewAccountScene();


    }

    // get window
    public static Stage getStage() {
        return stage;
    }

    // get loaders
    public static FXMLLoader getLoginLoader() {
        return loginLoader;
    }

    public static FXMLLoader getSignupLoader() {
        return signupLoader;
    }

    public static FXMLLoader getHomeLoader() {
        return homeLoader;
    }

    public static FXMLLoader getLookupLoader() {
        return lookupLoader;
    }

    public static FXMLLoader getTranslateLoader() {
        return translateLoader;
    }

    public static FXMLLoader getGameLoader() {
        return gameLoader;
    }

    public static FXMLLoader getAssistantLoader() {
        return assistantLoader;
    }

    public static FXMLLoader getAccountLoader() {
        return accountLoader;
    }

    // get available scenes
    public static Scene getHomeScene() {
        return homeScene;
    }

    public static Scene getLookupScene() {
        return lookupScene;
    }

    public static Scene getGameScene() {
        return gameScene;
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

    public static Scene getAccountScene() {
        return accountScene;
    }

    // get new scenes
    public static Scene getNewHomeScene() {
        Object[] res = getLoaderAndScene("home.fxml", "style.css");
        if (res != null) {
            homeLoader = (FXMLLoader) res[0];
            homeScene = (Scene) res[1];
        }
        return homeScene;
    }

    public static Scene getNewLookupScene() {
        Object[] res = getLoaderAndScene("lookup.fxml", "style.css");
        if (res != null) {
            lookupLoader = (FXMLLoader) res[0];
            lookupScene = (Scene) res[1];
        }
        return lookupScene;
    }

    public static Scene getNewGameScene() {
        Object[] res = getLoaderAndScene("game.fxml", "style.css");
        if (res != null) {
            gameLoader = (FXMLLoader) res[0];
            gameScene = (Scene) res[1];
        }
        return gameScene;
    }

    public static Scene getNewTranslateScene() {
        Object[] res = getLoaderAndScene("translate.fxml", "style.css");
        if (res != null) {
            translateLoader = (FXMLLoader) res[0];
            translateScene = (Scene) res[1];
        }
        return translateScene;
    }

    public static Scene getNewAssistantScene() {
        Object[] res = getLoaderAndScene("assistant.fxml", "style.css");
        if (res != null) {
            assistantLoader = (FXMLLoader) res[0];
            assistantScene = (Scene) res[1];
        }
        return assistantScene;
    }

    public static Scene getNewLoginScene() {
        Object[] res = getLoaderAndScene("login.fxml", "style.css");
        if (res != null) {
            loginLoader = (FXMLLoader) res[0];
            loginScene = (Scene) res[1];
        }
        return loginScene;
    }

    public static Scene getNewSignupScene() {
        Object[] res = getLoaderAndScene("signup.fxml", "style.css");
        if (res != null) {
            signupLoader = (FXMLLoader) res[0];
            signupScene = (Scene) res[1];
        }
        return signupScene;
    }

    public static Scene getNewAccountScene() {
        Object[] res = getLoaderAndScene("account.fxml", "style.css");
        if (res != null) {
            accountLoader = (FXMLLoader) res[0];
            accountScene = (Scene) res[1];
        }
        return accountScene;
    }

    public static void switchScene(Scene scene) {
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
    }

    private static Object[] getLoaderAndScene(String fxmlFile, String cssFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Scenes.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());
            if (!cssFile.isBlank()) {
                scene.getStylesheets().add(cssFile);
            }
            return new Object[]{fxmlLoader, scene};
        } catch (IOException e) {
            System.out.println("Cannot create scene.");
            e.printStackTrace();
        }
        return null;
    }
}
