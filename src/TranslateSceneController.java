import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TranslateSceneController extends fxController {
    @FXML
    private Label label_left;

    @FXML
    private Label label_right;

    @FXML
    private ScrollPane edit;

    @FXML
    private TextArea content_edit;

    @FXML
    private ScrollPane show;
    @FXML
    private Text content_show;

    @FXML
    private Button switch_language;

    @FXML
    private Button submit;

    private boolean en2Vi = true;

    @FXML
    private void handleTranslation() {
        if (en2Vi) {
            content_show.setText(Translate.en2Vi(content_edit.getText()));
        } else {
            content_show.setText(Translate.vi2En(content_edit.getText()));
        }
    }

    @FXML
    public void initialize() {
        super.initialize();
        sp_translate.setStyle("-fx-background-color: white;");

        content_show.wrappingWidthProperty().bind(show.widthProperty().subtract(show.getPadding().getLeft() * 2 - 1));

        content_edit.setOnKeyPressed(keyEvent -> {
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.ENTER) {
                handleTranslation();
            }
        });
        submit.setOnAction(actionEvent -> handleTranslation());

        switch_language.setOnAction(actionEvent -> {
            if (en2Vi) {
                label_left.setText("Vietnamese");
                label_right.setText("English");
                en2Vi = false;
            } else {
                label_left.setText("English");
                label_right.setText("Vietnamese");
                en2Vi = true;
            }
        });

    }
}
