import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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
    protected Button sp_account;

    @FXML
    protected ImageView icon_home;
    @FXML
    protected ImageView icon_lookup;
    @FXML
    protected ImageView icon_translate;
    @FXML
    protected ImageView icon_game;
    @FXML
    protected ImageView icon_assistant;
    @FXML
    protected ImageView icon_account;

//    @FXML
//    protected Image icon_home_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panels_icons/home.png")));
//    @FXML
//    protected Image icon_lookup_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panels_icons/lookup.png")));
//    @FXML
//    protected Image icon_translate_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panels_icons/translate.png")));
//    @FXML
//    protected Image icon_game_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panels_icons/game.png")));
//    @FXML
//    protected Image icon_assistant_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panels_icons/assistant.png")));

    @FXML
    public void initialize() {
        try {
            Image icon_home_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/home.png")));
            Image icon_lookup_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/lookup.png")));
            Image icon_translate_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/translate.png")));
            Image icon_game_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/game.png")));
            Image icon_assistant_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/assistant.png")));
            Image icon_account_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/side_panel_icons/account.png")));

            icon_home.setImage(icon_home_image);
            icon_lookup.setImage(icon_lookup_image);
            icon_translate.setImage(icon_translate_image);
            icon_game.setImage(icon_game_image);
            icon_assistant.setImage(icon_assistant_image);
            icon_account.setImage(icon_account_image);
        } catch (NullPointerException e) {
            System.out.println("NULL POINTER CAUGHT!!");
//            e.printStackTrace();
        }


        sp_home.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getHomeScene()));
        sp_lookup.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getLookupScene()));
        sp_translate.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getTranslateScene()));
        sp_game.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getGameScene()));
        sp_assistant.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getAssistantScene()));
        sp_account.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getNewAccountScene()));
    }

}
