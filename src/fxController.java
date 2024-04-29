import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class fxController {
    @FXML
    protected AnchorPane side_panel;

    @FXML
    protected Button sp_home;

    @FXML
    protected Button sp_lookup;

    @FXML
    protected Button sp_translate;

    @FXML
    protected Button sp_game;

    @FXML
    protected Button sp_assistant;

    @FXML
    public void initialize() {
        sp_home.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getHomeScene()));
        sp_lookup.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getLookupScene()));
        sp_translate.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getTranslateScene()));
        sp_game.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getGame1Scene()));
        sp_assistant.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getAssistantScene()));
    }

}
