package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller {

    String[] button_state=new String[]{"off","off","off","off","off"};

    public ImageView button0;
    public ImageView button1;
    public ImageView button2;
    public ImageView button3;
    public ImageView button4;

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
}
