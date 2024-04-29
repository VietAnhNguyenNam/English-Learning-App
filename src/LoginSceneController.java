import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginSceneController {
    @FXML
    private PasswordField password;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button submit_login;

    @FXML
    private Hyperlink toSignUpScene;

    @FXML
    private TextField username;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label invalid_label;

    private void logIn() {
        String accountUsername = username.getText();
        String enteredPassword = password.getText();
        if (accountUsername.isEmpty() || enteredPassword.isEmpty()) {
            invalid_label.setVisible(true);
        } else {
            int userId = Account.checkPassword(accountUsername, enteredPassword);
            if (userId == -1) {
                invalid_label.setVisible(true);
            } else {
                Scenes.getStage().setUserData(userId);
                Scenes.switchScene(Scenes.getHomeScene());
            }
        }
    }

    @FXML
    public void initialize() {
        invalid_label.setVisible(false);

        submit_login.setOnAction(actionEvent -> logIn());
        username.setOnAction(actionEvent -> logIn());
        password.setOnAction(actionEvent -> logIn());

        toSignUpScene.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getNewSignupScene()));

    }
}
