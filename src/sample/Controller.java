package sample;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class Controller {

    String[] button_state=new String[]{"off","off","off","off","off"};

    public ImageView button0;
    public ImageView button1;
    public ImageView button2;
    public ImageView button3;
    public ImageView button4;
    public ImageView right_hand;
    public ImageView radioHand;
    public ImageView start_button1;
    public ImageView start_button2;
    String musicFile = "src/sample/brum.mp3";     // For example




    public void switchOnOffButtons(MouseEvent event){

        switch (event.getPickResult().getIntersectedNode().getId()) {
            case "button0":
                if (button_state[0].equals("on")) {
                    button0.setImage(new Image("sample/buttonOFF.png"));
                    button_state[0] = "off";
                } else {
                    button0.setImage(new Image("sample/ButtonON.png"));
                    button_state[0] = "on";
                }
                break;
            case "button1":
                if (button_state[1].equals("on")) {
                    button1.setImage(new Image("sample/buttonOFF.png"));
                    button_state[1] = "off";
                } else {
                    button1.setImage(new Image("sample/ButtonON.png"));
                    button_state[1] = "on";
                }
                break;
            case "button2":
                if (button_state[2].equals("on")) {
                    button2.setImage(new Image("sample/buttonOFF.png"));
                    button_state[2] = "off";
                } else {
                    button2.setImage(new Image("sample/ButtonON.png"));
                    button_state[2] = "on";
                }
                break;
            case "button3":
                if (button_state[3].equals("on")) {
                    button3.setImage(new Image("sample/buttonOFF.png"));
                    button_state[3] = "off";
                } else {
                    button3.setImage(new Image("sample/ButtonON.png"));
                    button_state[3] = "on";
                }
                break;
            case "button4":
                if (button_state[4].equals("on")) {
                    button4.setImage(new Image("sample/buttonOFF.png"));
                    button_state[4] = "off";
                } else {
                    button4.setImage(new Image("sample/ButtonON.png"));
                    button_state[4] = "on";
                }
                break;
        }
    }
    @FXML
    public void leftHandMovement(KeyEvent keyEvent) {
        //System.out.println("znak: ");
        if (keyEvent.getCode()== KeyCode.W){
            if(right_hand.getRotate()+5<65){
                right_hand.setRotate(right_hand.getRotate()+7);
            }
        }
        else if (keyEvent.getCode()== KeyCode.S){
            if(right_hand.getRotate()-5>-65){
                right_hand.setRotate(right_hand.getRotate()-7);
            }

        }
        else if (keyEvent.getCode()== KeyCode.A){
            radioHand.setX(radioHand.getX()-5);
        }
        else if (keyEvent.getCode()== KeyCode.D){
            radioHand.setX(radioHand.getX()+5);
        }
    }

    public void start_clicked(MouseEvent mouseEvent) {
        start_button2.toFront();
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        //dać jakiś dzwięk
    }

    public void start_realased(MouseEvent mouseEvent) {
        start_button2.toBack();
        //dzwięk stop
    }
}
