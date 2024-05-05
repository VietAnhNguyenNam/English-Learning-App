
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class GameController extends fxController {
    private Stage stage;
    private Scene scene;
    @FXML
    protected ImageView quiz_view;
    @FXML
    protected Image quiz_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/quizgame.png")));
    @FXML
    protected ImageView hangman_view;
    @FXML
    protected Image hangman_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/hangman.png")));


    public void initialize() {
        super.initialize();
        sp_translate.setStyle("-fx-background-color: white;");

        quiz_view.setImage(quiz_image);
        hangman_view.setImage(hangman_image);

    }
    public void switchtoGame1(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("game1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void switchtoGame2(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("game2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
