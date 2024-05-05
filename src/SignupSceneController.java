import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SignupSceneController {
    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private Label invalid_label;

    @FXML
    private PasswordField password;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button submit_signup;

    @FXML
    private Hyperlink toLogInScene;

    @FXML
    private TextField username;

    @FXML
    private Label usernameLabel;

    private void signUp() {
        String accountUsername = username.getText();
        String enteredPassword = password.getText();
        String confirmedPassword = confirmPassword.getText();
        if (accountUsername.isBlank() || enteredPassword.isEmpty() || confirmedPassword.isEmpty()) {
            invalid_label.setText("Please fill out all the fields");
            invalid_label.setVisible(true);
        } else if (!enteredPassword.equals(confirmedPassword)) {
            invalid_label.setText("Confirm password does not match");
            invalid_label.setVisible(true);
        } else if (Account.alreadyExist(accountUsername)) {
            invalid_label.setText("This username already exists");
            invalid_label.setVisible(true);
        }else {
            Account.newAccount(accountUsername, enteredPassword);
            Scenes.switchScene(Scenes.getNewLoginScene());
        }
    }

    @FXML
    public void initialize() {
        invalid_label.setVisible(false);

        submit_signup.setOnAction(actionEvent -> signUp());
        username.setOnAction(actionEvent -> signUp());
        password.setOnAction(actionEvent -> signUp());
        confirmPassword.setOnAction(actionEvent -> signUp());

        toLogInScene.setOnAction(actionEvent -> Scenes.switchScene(Scenes.getNewLoginScene()));

    }
}
