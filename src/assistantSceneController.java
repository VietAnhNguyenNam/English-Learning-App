import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.collections.MapChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class assistantSceneController extends fxController {
    @FXML
    private GridPane gridpane;

    @FXML
    private Label initMessage;

    @FXML
    private Label initRole;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextArea prompt_text;

    @FXML
    private Button send;

    @FXML
    private Button newChat;

    private ObjectBinding<Object> userData;

    private boolean loaded = false;

    private ObjectBinding<Object> userDataBinding(Stage stage) {
        Object[] keyHolder = new Object[1];
        stage
                .getProperties()
                .addListener(
                        new MapChangeListener<>() {
                            @Override
                            public void onChanged(Change<? extends Object, ? extends Object> change) {
                                keyHolder[0] = change.getKey();
                                change.getMap().removeListener(this);
                            }
                        });
        var oldUserData = stage.getUserData();
        stage.setUserData(new Object());
        stage.setUserData(oldUserData);
        return Bindings.valueAt(stage.getProperties(), keyHolder[0]);
    }

    private void addNewRow(String role, String message) {
        Label roleLabel = new Label(role);
        roleLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold");

        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-size: 15");
        messageLabel.setWrapText(true);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.TOP);
//        rowConstraints.setMinHeight(Region.USE_PREF_SIZE);
//        rowConstraints.setPrefHeight(Region.USE_COMPUTED_SIZE);
        gridpane.addRow(gridpane.getRowCount(), roleLabel, messageLabel);
        gridpane.getRowConstraints().add(rowConstraints);
    }

    private void showResponseMessage() {
        String promptMessage = prompt_text.getText();
        prompt_text.clear();
        if (promptMessage.isEmpty()) {
            return;
        }
        addNewRow("You", promptMessage);
        if (Scenes.getStage().getUserData() == null) {
            addNewRow("Chatbot", "You have to log in to use this service.");
        } else {
            addNewRow("Chatbot", Chatbot.responseTo((int) Scenes.getStage().getUserData(), promptMessage));
        }
//        String responseMessage = "This is response message";
    }

    @FXML
    public void initialize() {
        super.initialize();
        sp_assistant.setStyle("-fx-background-color: white;");

        userData = userDataBinding(Scenes.getStage());
        userData.addListener(
                (observableValue, oldVal, newVal) -> {
                    if (!loaded) {
                        if (newVal != null && newVal != oldVal) {
//                            System.out.println("user id: " + newVal);
                            List<String[]> list = Account.getConversation((int) Scenes.getStage().getUserData());
                            for (final String[] chat : list) {
                                if (chat[0].equals("user")) {
                                    addNewRow("You", chat[1]);
                                } else if (chat[0].equals("model")) {
                                    addNewRow("Chatbot", chat[1]);
                                }
                            }
                            loaded = true;
                        }
                    }
                });

        gridpane.heightProperty().addListener((observable, oldValue, newValue) -> {
            scrollpane.setVvalue(scrollpane.getVmax());
        });

//        System.out.println("1: " + (int) Scenes.getStage().getUserData());

//        SimpleObjectProperty<Object> userDataProperty = new SimpleObjectProperty<>(Scenes.getStage().getUserData());
//        userDataProperty.addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                List<String[]> list = Account.getConversation((int) newValue);
//                for (final String[] chat : list) {
//                    if (chat[0].equals("user")) {
//                    addNewRow("You", chat[1]);
//                    } else if (chat[0].equals("model")) {
//                        addNewRow("Chatbot", chat[1]);
//                    }
//                }
//            }
//            System.out.println("2:" + (int) Scenes.getStage().getUserData());
//        });



        send.setOnAction(actionEvent -> showResponseMessage());

        prompt_text.setOnKeyPressed(keyEvent -> {
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.ENTER) {
                showResponseMessage();
            }
        });

        newChat.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete chat?");
            alert.setHeaderText(null);
            alert.setContentText("This action cannot be undone. Are you sure you want to proceed?");

            // Set buttons
            ButtonType buttonTypeYes = ButtonType.YES;
            ButtonType buttonTypeCancel = ButtonType.CANCEL;
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);

            // Show the dialog and wait for a response
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == buttonTypeYes) {
                Account.deleteConversation((int) Scenes.getStage().getUserData());
                Scenes.switchScene(Scenes.getNewAssistantScene());
            }
        });
    }
}
