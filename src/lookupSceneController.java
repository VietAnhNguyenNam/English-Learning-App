import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class lookupSceneController extends fxController {
    @FXML
    protected ComboBox search_comboBox;
    @FXML
    protected Button search_btn;
    protected String word;
    @FXML
    private VBox meaning_vbox;
    @FXML
    private Label englishWord;
    private String engWord;
    @FXML
    private Label phonetic;
    @FXML
    private Text detail;
    @FXML
    private Line line;
    @FXML
    private Button pronounce;
    @FXML
    private ScrollPane meaning_pane;


    @FXML
    protected void handleSearchEvent() {
        List<String> stringList = Database.findFirst10(word);
        search_comboBox.getItems().clear();
        if (search_comboBox.getItems().addAll(stringList)) {
            search_comboBox.hide();
            search_comboBox.setVisibleRowCount(stringList.size());
            search_comboBox.show();
        } else {
            search_comboBox.hide();
        }
    }

    @FXML
    protected void changeData() {
        engWord = search_comboBox.getEditor().getText();
        englishWord.setText(engWord);
        String meaning = Database.meaningOf(engWord);
        detail.setText(meaning);
        String pronounce = Database.phoneticOf(engWord);
        phonetic.setText(pronounce);
        if (!search_comboBox.getSelectionModel().isEmpty()) {
            meaning_vbox.setVisible(true);
        } else {
            meaning_vbox.setVisible(false);
        }
    }

    @FXML
    public void initialize() {
        super.initialize();
        sp_lookup.setStyle("-fx-background-color: white;");
        detail.wrappingWidthProperty().bind(meaning_pane.widthProperty().subtract(20));
        line.startXProperty().bind(meaning_vbox.widthProperty().multiply(0));
        line.endXProperty().bind(meaning_vbox.widthProperty().multiply(0.95));


        // search preview

        meaning_vbox.setVisible(false);
        sp_lookup.setStyle("-fx-background-color: white");

        PauseTransition pause = new PauseTransition(Duration.millis(200));
        search_comboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            pause.stop();
            pause.playFromStart();
        });

        pause.setOnFinished(event -> {
            word = search_comboBox.getEditor().getText();
            if (word.isBlank()) {
                search_comboBox.hide();
            } else if (search_comboBox.getSelectionModel().isEmpty()) {
                handleSearchEvent();
            } else {
                if (!search_comboBox.getSelectionModel().getSelectedItem().equals(word)) {
//                    search_comboBox.getSelectionModel().clearSelection();
                    handleSearchEvent();
                    search_comboBox.getEditor().setText(word);
                }
                search_comboBox.getEditor().positionCaret(word.length());
            }

        });




        search_btn.setOnAction(actionEvent -> changeData());
        search_comboBox.setOnKeyPressed(keyEvent -> changeData());
//        search_comboBox.getSelectionModel().selectedItemProperty().

        pronounce.setOnAction(actionEvent -> Text2Speech.speak(engWord));

    }
}
