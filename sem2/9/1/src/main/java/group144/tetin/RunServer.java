package group144.tetin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunServer extends Application {
    private ControllerServer controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader (getClass().getResource("Server.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("You play as X");
        primaryStage.setScene(new Scene(root, 350, 300));
        primaryStage.show();
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(325);
    }

    @Override
    public void stop() throws Exception {
        controller.sendMessageAboutDisconnect();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
