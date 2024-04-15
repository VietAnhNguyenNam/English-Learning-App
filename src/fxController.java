import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class fxController {
    @FXML
    protected ComboBox search_comboBox;
    @FXML
    protected Button search_btn;
    protected String word;

    @FXML
    protected void onclickSearchBTN() throws IOException {
        if (word == null || word.isBlank()) {
            Scenes.switchScene(Scenes.getMainScene());
        } else if (!word.isBlank()) {
            Scenes.getStage().setUserData(word);
            System.out.println(1 + word);
            Scenes.switchScene(Scenes.getLookupScene());
//            FXMLLoader loader = new FXMLLoader(fxController.class.getResource("lookup.fxml"));
//            Scene lookupScene = new Scene(loader.load());
//            lookupScene.getStylesheets().add("style.css");
//            Scenes.getStage().setScene(lookupScene);


//            ComboBox tmp = (ComboBox) Scenes.getMainLoader().getNamespace().get("search_comboBox");
//            tmp.getEditor().clear();
        }
    }

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
    public void initialize() {
        PauseTransition pause = new PauseTransition(Duration.millis(350));
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

        search_btn.setOnAction(actionEvent -> {
            try {
                onclickSearchBTN();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
