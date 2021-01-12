package sample;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class Controller {
    public Timeline t = new Timeline();

    String[] button_state=new String[]{"off","off","off","off","off"};

    public ImageView button0;
    public ImageView button1;
    public ImageView button2;
    public ImageView button3;
    public ImageView button4;
    public ImageView right_hand;
    public ImageView left_hand;
    public ImageView radioHand;
    public ImageView start_button1;
    public ImageView start_button2;
    public Button gas_pedal;
    public ImageView speed;
    public ImageView gas_pedal_small;
    double previousSpeed;
    String start = "src/sample/brum.mp3";
    String blinkers = "src/sample/blinkers.mp3";
    String button = "src/sample/switch.mp3";
    int engine_started = 0;
    Duration animationTime;




    public void switchOnOffButtons(MouseEvent event){
        Media onoff = new Media(new File(button).toURI().toString());
        MediaPlayer switchSound = new MediaPlayer(onoff);
        switchSound.setVolume(0.5);
        Media blink = new Media(new File(blinkers).toURI().toString());
        MediaPlayer blinkSound = new MediaPlayer(blink);
        blinkSound.setCycleCount(50);
        switch (event.getPickResult().getIntersectedNode().getId()) {
            case "button0":
                if (button_state[0].equals("on")) {
                    button0.setImage(new Image("sample/buttonOFF.png"));
                    button_state[0] = "off";
                    t.playFrom(animationTime);

                } else {
                    button0.setImage(new Image("sample/ButtonON.png"));
                    button_state[0] = "on";
                    animationTime=t.getCurrentTime();
                    t.pause();
                }
                switchSound.play();
                break;
            case "button1":
                if (button_state[1].equals("on")) {
                    button1.setImage(new Image("sample/buttonOFF.png"));
                    button_state[1] = "off";
                    blinkSound.stop();
                } else {
                    button1.setImage(new Image("sample/ButtonON.png"));
                    button2.setImage(new Image("sample/buttonOFF.png"));
                    button_state[1] = "on";
                    button_state[2] = "off";
                    blinkSound.play();
                }

                break;
            case "button2":
                if (button_state[2].equals("on")) {
                    button2.setImage(new Image("sample/buttonOFF.png"));
                    button_state[2] = "off";
                    blinkSound.stop();
                } else {
                    button2.setImage(new Image("sample/ButtonON.png"));
                    button1.setImage(new Image("sample/buttonOFF.png"));
                    button_state[2] = "on";
                    button_state[1] = "off";
                    blinkSound.play();
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
                switchSound.play();
                break;
            case "button4":
                if (button_state[4].equals("on")) {
                    button4.setImage(new Image("sample/buttonOFF.png"));
                    button_state[4] = "off";
                } else {
                    button4.setImage(new Image("sample/ButtonON.png"));
                    button_state[4] = "on";
                }
                switchSound.play();
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
        engine_started=1;
        Media sound = new Media(new File(start).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(25);
        rotate.setDuration(Duration.millis(750));
        rotate.setDelay(Duration.millis(900));
        rotate.setNode(left_hand);
        rotate.play();
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0), new KeyValue(speed.rotateProperty(), -115.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(0), new KeyValue(left_hand.rotateProperty(), -125.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(speed.rotateProperty(), -60)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(4.6), new KeyValue(left_hand.rotateProperty(), 88.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(left_hand.rotateProperty(), -10.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(14), new KeyValue(speed.rotateProperty(), 0.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(13.2), new KeyValue(left_hand.rotateProperty(), 88.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(14), new KeyValue(left_hand.rotateProperty(), 0.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(35), new KeyValue(speed.rotateProperty(), 100.0)));
        t.getKeyFrames().add(new KeyFrame(Duration.seconds(35), new KeyValue(left_hand.rotateProperty(), 88.0)));
        //dać jakiś dzwięk
    }

    public void start_realased(MouseEvent mouseEvent) {
        start_button2.toBack();
        //dzwięk stop
    }
    public void accelerate(){
        t.setRate(4.0);
        if(button_state[0]=="on"){
            button0.setImage(new Image("sample/buttonOFF.png"));
            button_state[0] = "off";
            t.playFrom(animationTime);
        }
        else{
            t.play();
        }

    }
    public void slow_down(){
        t.setRate(-2.0);
        if(t.getCurrentTime()==Duration.seconds(35))t.play();
    }
    public void brake(){
        t.setRate(-4.0);
        if(button_state[0]=="on"){
            button0.setImage(new Image("sample/buttonOFF.png"));
            button_state[0] = "off";
            t.playFrom(animationTime);
        }
    }

}
