import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AccountSceneController extends fxController {
    @FXML
    private Label noSavedWord;

    @FXML
    private VBox wordList;

    public void getSavedWords() {
        LookupSceneController lookupSceneController = Scenes.getLookupLoader().getController();

        List<String> list = Account.getSavedWords((int) Scenes.getStage().getUserData());
        List<Hyperlink> hyperlinkList = new ArrayList<>();
        for (final String word : list) {
            Hyperlink tmp = new Hyperlink(word);
            tmp.setStyle("-fx-font-size: 16px;");
            tmp.setOnAction(actionEvent -> {
                lookupSceneController.changeData(tmp.getText(), true);
                Scenes.switchScene(Scenes.getLookupScene());
            });
            hyperlinkList.add(tmp);
        }
        wordList.getChildren().addAll(hyperlinkList);

        noSavedWord.setVisible(hyperlinkList.isEmpty());
    }

    @FXML
    public void initialize() {
        super.initialize();
        sp_account.setStyle("-fx-background-color: white;");

        if (Scenes.getStage().getUserData() != null) {
            getSavedWords();
        }

    }

}