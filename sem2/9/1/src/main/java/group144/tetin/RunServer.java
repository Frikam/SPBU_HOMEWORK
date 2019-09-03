package group144.tetin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RunServer extends Application {
    ControllerClient controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
        primaryStage.setTitle("You play as X");
        primaryStage.setScene(new Scene(root, 350, 300));
        primaryStage.show();
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(325);
    }

    @Override
    public void stop() {
        try {
            controller.sendMessageAboutDisconnect();
        } catch (IOException e) {
            System.out.println("ASDaD");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
