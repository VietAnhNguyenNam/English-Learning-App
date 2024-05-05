import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class homeSceneController extends fxController {
    @FXML
    private Button goAccount;

    @FXML
    private Button goAssistant;

    @FXML
    private Button goGame;

    @FXML
    private Button goLookup;

    @FXML
    private Button goTranslate;

    @FXML
    protected ImageView lookup_view;
    @FXML
    protected ImageView translate_view;
    @FXML
    protected ImageView game_view;
    @FXML
    protected ImageView assistant_view;
    @FXML
    protected ImageView account_view;
    @FXML
    protected Image lookup_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/home/lookup.png")));
    @FXML
    protected Image translate_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/home/translate.png")));
    @FXML
    protected Image game_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/home/game.png")));
    @FXML
    protected Image assistant_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/home/assistant.png")));
    @FXML
    protected Image account_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/home/account.png")));

    @FXML
    public void initialize() {
        super.initialize();
        sp_home.setStyle("-fx-background-color: white;");

        lookup_view.setImage(lookup_image);
        translate_view.setImage(translate_image);
        game_view.setImage(game_image);
        assistant_view.setImage(assistant_image);
        account_view.setImage(account_image);

        goLookup.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getLookupScene()));
        goTranslate.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getTranslateScene()));
        goGame.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getGameScene()));
        goAssistant.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getAssistantScene()));
        goAccount.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getNewAccountScene()));

    }
}
