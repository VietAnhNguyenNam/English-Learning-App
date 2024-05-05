
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Game2Controller {
    @FXML
    protected ImageView image_view;

    @FXML
    protected Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test1.png")));
    protected Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test2.png")));
    protected Image image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test3.png")));
    protected Image image4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test4.png")));
    protected Image image5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test5.png")));
    protected Image image6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test6.png")));
    protected Image image7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/test7.png")));
    @FXML
    protected ImageView reset_view;
    @FXML
    protected Image reset_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/reset.png")));
    @FXML
    protected ImageView back_view;
    @FXML
    protected Image back_image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/back.png")));


    @FXML
    TextField tf1;
    @FXML
    TextField tf2;
    @FXML
    TextField tf3;
    @FXML
    TextField tf4;
    @FXML
    TextField tf5;
    @FXML
    TextField tf6;
    @FXML
    TextField tf7;
    @FXML
    TextField tf8;
    @FXML
    TextField input;
    @FXML
    Label hint;
    @FXML
    Label letter_count;
    @FXML
    Label hint_label;

    String[] data = {
            "MEXICO COUNTRY",
            "HEDWIG BIRD",
            "KUAKATA BEACH",
            "CANADA COUNTRY",
            "DOCTOR PROFESSION",
            "FOOTBALL GAME",
            "TEACHER MENTOR",
            "LEOPARD ANIMAL",
            "BICYCLE TRANSPORT",
            "SALMON FISH",
            "SPARROW BIRD",
            "PARROTS BIRD",
            "EAGLE BIRD",
            "TRAIN TRANSPORT",
            "SHIP TRANSPORT",
            "ENGINEER PROFESSION",
            "BANKER PROFESSION",
            "CRICKET GAME"
    };

    int random = new Random().nextInt(data.length);
    String word_hint = data [random];
    String[] split = word_hint.split(" ", 2);
    String word = split[0];
    String hint_str = split[1];
    int letter_size = word.length();

    public void initialize(){
        image_view.setImage(image1);
        reset_view.setImage(reset_image);
        back_view.setImage(back_image);
        setHint();
    }

    public void setHint(){
        hint.setText(hint_str);
        letter_count.setText(letter_size+" Letters");

        if(letter_size==7){
            tf8.setVisible(false);
        }
        if(letter_size==6){
            tf7.setVisible(false);
            tf8.setVisible(false);
        }
        if(letter_size==5){
            tf6.setVisible(false);
            tf7.setVisible(false);
            tf8.setVisible(false);
        }
        if(letter_size==4){
            tf5.setVisible(false);
            tf6.setVisible(false);
            tf7.setVisible(false);
            tf8.setVisible(false);
        }
    }


    public void CheckInput(){
        String str = input.getText();
        if (word.contains(str)) {
            int index = 0;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    setLetter(index, Character.toString(c));
                }
                index++;
            }
        }
        else {
            setImage();
        }
    }

    public void setLetter(int index,String str){
        if(index==0)
            tf1.setText(str);
        else if(index==1)
            tf2.setText(str);
        else if(index==2)
            tf3.setText(str);
        else if(index==3)
            tf4.setText(str);
        else if(index==4)
            tf5.setText(str);
        else if(index==5)
            tf6.setText(str);
        else if(index==6)
            tf7.setText(str);
        else if(index==7)
            tf8.setText(str);
    }

    int life=6;
    public void setImage(){
        if(life==6)
            image_view.setImage(image2);
        else if(life==5)
            image_view.setImage(image3);
        else if(life==4)
            image_view.setImage(image4);
        else if(life==3)
            image_view.setImage(image5);
        else if(life==2)
            image_view.setImage(image6);
        else if(life==1)
            image_view.setImage(image7);
        life--;
    }


    public void changeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("game.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
