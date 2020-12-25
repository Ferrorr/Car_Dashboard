package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Brum Brum..");
        Scene scene=new Scene(root, 1000, 580);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getRoot().requestFocus();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
