import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    public void initialize() {
        super.initialize();
        sp_home.setStyle("-fx-background-color: white;");

        goLookup.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getLookupScene()));
        goTranslate.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getTranslateScene()));
        goGame.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getGame1Scene()));
        goAssistant.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getAssistantScene()));
//        goAccount.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getAccountScene()));

    }
}
