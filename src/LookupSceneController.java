import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.List;
import java.util.Objects;

public class LookupSceneController extends fxController {
    @FXML
    private ComboBox search_comboBox;
    @FXML
    private Button search_btn;
    private String word;
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
    private Label noWordFound;

    @FXML
    private Button bookmarked;
    @FXML
    private Button unbookmark;
    @FXML
    private ImageView bookmarked_view;
    @FXML
    private ImageView unbookmark_view;
    @FXML
    private Image bookmarked_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blue_bookmark_star.png")));
    @FXML
    private Image unbookmark_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/empty_bookmark_star.png")));

    private void displayBookmark(String word) {
        if (Account.savedWord((int) Scenes.getStage().getUserData(), word)) {
            bookmarked.setVisible(true);
            unbookmark.setVisible(false);
        } else {
            bookmarked.setVisible(false);
            unbookmark.setVisible(true);
        }
    }

    @FXML
    private void handleSearchEvent() {
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
    private void toogleVisible(boolean foundWord) {
        if (foundWord) {
            meaning_vbox.setVisible(true);
            noWordFound.setVisible(false);
        } else {
            meaning_vbox.setVisible(false);
            noWordFound.setVisible(true);
        }
    }

    /*
     * forceShowing is true when saved words are clicked to bypass the condition for showing the meaning pane in lookup scene,
     * in lookup scene, this parameter is always false.
     */
    @FXML
    public void changeData(String word, boolean forceShowing) {
        engWord = word;
        englishWord.setText(engWord);
        String meaning = Database.meaningOf(engWord);
        detail.setText(meaning);
        String pronounce = Database.phoneticOf(engWord);
        phonetic.setText(pronounce);
        if (forceShowing) {
            toogleVisible(true);
        } else if (!search_comboBox.getSelectionModel().isEmpty()) {
            toogleVisible(true);
        } else {
            toogleVisible(false);
        }
        displayBookmark(engWord);
    }

    @FXML
    public void initialize() {
        super.initialize();
        sp_lookup.setStyle("-fx-background-color: white;");
        detail.wrappingWidthProperty().bind(meaning_pane.widthProperty().subtract(20));
        line.startXProperty().bind(meaning_vbox.widthProperty().multiply(0));
        line.endXProperty().bind(meaning_vbox.widthProperty().multiply(0.95));

        bookmarked_view.setImage(bookmarked_image);
        unbookmark_view.setImage(unbookmark_image);

        // search preview

        toogleVisible(false);
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


        search_btn.setOnAction(actionEvent -> changeData(search_comboBox.getEditor().getText(), false));
        search_comboBox.setOnKeyPressed(keyEvent -> changeData(search_comboBox.getEditor().getText(), false));
//        search_comboBox.getSelectionModel().selectedItemProperty().

        pronounce.setOnAction(actionEvent -> Text2Speech.speak(engWord));


//        bookmarked, unbookmark;
        unbookmark.setOnAction(actionEvent -> {
            Account.addToSavedWords((int) Scenes.getStage().getUserData(), engWord);
            unbookmark.setVisible(false);
            bookmarked.setVisible(true);
        });

        bookmarked.setOnAction(actionEvent -> {
            Account.deleteSavedWord((int) Scenes.getStage().getUserData(), engWord);
            bookmarked.setVisible(false);
            unbookmark.setVisible(true);
        });
    }
}
