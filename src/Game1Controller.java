

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Game1Controller {

    @FXML
    private AnchorPane anchorGame1;


    @FXML
    private Button option1;

    @FXML
    private Button option2;

    @FXML
    private Button option3;

    @FXML
    private Button option4;

    @FXML
    private Label questionLabel;
    @FXML
    protected ImageView back_view;
    @FXML
    protected Image back_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/back.png")));
    private final String[] questions = {
            "What _ you doing?",
            "The little boy pleaded ___ not to leave him alone in the dark.",
            "___, the people who come to this club are in their twenties and thirties.",
            "The TV station, in _____ to massive popular demand, decided notto discontinue the soap opera",
            "His emotional problems _____ from the attitudes he encountered as a child, I think.",
            "Pete was born and brought up in Cornwall and he knows the place like the _______.",
            "British and Australian people share the same language, but in other respects they are as different as ___.",
            " Ancient Egyptians mummified their dead through the use of chemicals, _____ ancient Peruvians did through natural processes.",
            "Don’t ___ to any conclusion before you know the full facts.",
            "A few animals sometimes fool their enemies _____ to be dead.",
            "On no account __ in the office be used for personal materials.",
            "The __ of the bank where he worked was not in the center of the city.",
            "____ from Bill, all the students said they would go.",
            "Position of the main stress",
            "______ my opinion, French cheese is better than English cheese.",
            "When I bought the shoes, they _________ me well but later they were too tight at home",
            "The purpose of phonetics is __ an inventory and a description of the sounds found in speech",
            "They received a ten-year sentence for __armed robbery.",
            "_________ the hijacker plane landed, it was surrounded by police.",
            "This magazine is very good. If you like reading, you should______to it.",
            "In life ___can make a mistake ; We’re all human.",
            "Do you have any objections______this new road scheme?",
            "The police set a_________to catch the thieves.",
            "Although he was _______ , he agreed to play tennis with me",
            " _____ I didn’t know how to do the job. But now I am making progress.",
            "Language could _____ more quickly if there were more language exchange programs.",
            "She won the award for ______ her whole life to looking after the poor.",
            "Although the exam was difficult, ____ the students passed it.",
            "The mirror was ____ broken.",
            "But for his help, I _______",
            "I may look half asleep, but I can assure you I am ____ awake.",
            "Lefthand traffic, a custom existing in Britain only, _______ back to the days when English people went to and fro on horseback.",
            " “ I am sorry . I broke the vase.” – “_________________.”",
            "The tourists refused to ________ the poor service.",
            "I haven’t got the time to do my own work, _______ help you with yours.",
            "Professor Lockwood recommended that Michael _______ in chemistry.",
            "Luggage may be placed here ______ the owner’s risk.",
            "It’s a serious operation for a woman as old as my grandmother. She is very frail . I hope she ______",
            "______ any other politician would have given way to this sort of pressure years ago.",
            "After several months of hard work, the police are finally ______ somewhere with their investigation.",
            "There’s no danger in using this machine as long as you _______ to the safety regulations."
    };

    private final String[][] options = {
            {"are", "do", "is", "have"},
            {"on his mother", "his mother", "with his mother", "at his mother"},
            {"By and large", "Altogether", "To a degree", "Virtually"},
            {"reaction", "response", "answer", "rely"},
            {"stem", "flourish", "root", "sprout"},
            {"nose on his face", "tip of the tongue", "back of his hand", "hair on his head"},
            {"cats and dogs", "salt and pepper", "chalk and cheese", "here and there"},
            {"because", "whereas", "even though", "whether or not"},
            {"rush", "dive", "leap", "fly"},
            {"have been appearing", "to be appearing", "to appear", "by appearing"},
            {"the photocopy machines", "the photocopy machines should", "should the photocopy machines", "does the photocopy machines"},
            {"branch", "seat", "house", "piece"},
            {"Exept", "Only", "Apart", "Separate"},
            {"vacancy", "calculate", "delicious", "furniture"},
            {"For", "To", "By", "In"},
            {"matched", "fitted", "suited", "went with"},
            {"provide", "provided", "to provide", "being provided"},
            {"making", "doing", "committing", "practicing"},
            {"As soon as", "While", "Just", "Until"},
            {"buy", "subscribe", "contribute", "enroll"},
            {"anyone", "someone", "some people", "not anybody"},
            {"at", "with", "to", "for"},
            {"plan", "device", "snare", "trap"},
            {"exhaustion", "exhausted", "exhausting", "exhaustive"},
            {"First", "First of all", "At first", "At the first."},
            {"be learning", "have learned", "have learning", "be learned"},
            {"paying", "devoting", "causing", "attracting"},
            {"most of", "none of", "a few", "a lot"},
            {"accident", "accidental", "accidentally", "by accident"},
            {"would not have succeeded", "had not succeeded", "did not succeed", "would succeed"},
            {"broad", "full", "well", "wide"},
            {"dated", "dating", "dates back", "to date"},
            {"Don’t worry. Things break.", "OK. Go ahead.", "Yes, certainly.", "I’d rather not."},
            {"stand in for ", "put up with ", "get away from", "get on with "},
            {"leaving aside", "let alone", "apart from", "not counting"},
            {"not to major", "not major", "wouldn’t major", "isn’t majoring"},
            {"at", "by", "under", "with"},
            {"gets away", "comes round", "pulls through", "stands up"},
            {"Really", "Practically", "Actually", "Utterly"},
            {"getting", "going", "making", "doing"},
            {"comply", "adhere", "observe", "abide"}

    };

    private final String[] answers = {
            "A", "C", "A",
            "B", "A", "C", "C", "B", "C",
            "D", "C", "A", "C", "C", "D", "B",
            "C", "C", "A", "B", "A", "C", "D",
            "B", "C", "D", "B", "A", "C", "A",
            "D", "C", "A", "B", "C", "B", "A",
            "C", "B", "A", "B"
    };

    private int current = 0;
    private int score = 0;

    @FXML
    public void initialize() {
        back_view.setImage(back_image);
        showQuestion();
    }


    @FXML
    void option1(ActionEvent e) {
        checkAnswer(option1.getText());

    }

    @FXML
    void option2(ActionEvent e) {
        checkAnswer(option2.getText());

    }

    @FXML
    void option3(ActionEvent e) {
        checkAnswer(option3.getText());

    }

    @FXML
    void option4(ActionEvent e) {
        checkAnswer(option4.getText());

    }

    public void checkAnswer(String userChoice) {
        String correctAnswer = answers[current];
        String extractedLetter = userChoice.substring(0, 1);
        if (extractedLetter.equalsIgnoreCase(correctAnswer)) {
            score++;
        }
        current++;
        showQuestion();
    }

    public void showQuestion() {
        if (current < questions.length) {
            questionLabel.setText(questions[current]);
            option1.setText("A. " + options[current][0]);
            option2.setText("B. " + options[current][1]);
            option3.setText("C. " + options[current][2]);
            option4.setText("D. " + options[current][3]);
        } else {
            showResult();

        }

    }
    public void showResult() {
        Stage stage = (Stage) questionLabel.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Quiz Result");
        alert.setHeaderText(null);
        alert.setContentText("Quiz completed!\n" +
                "Total questions: " + questions.length + "\n" +
                "Correct answers: " + score + "\n" +
                "Incorrect answers: " + (questions.length - score));
        alert.setOnHidden(evt -> stage.close());
        alert.show();
    }
    public void back(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("game.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
