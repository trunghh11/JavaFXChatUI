package com.chatui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * JavaFX App
 */
public class ChatApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("chatUI.fxml"));
            scene = new Scene(root);

            String cssPath = getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(cssPath);

            stage.setTitle("Chat UI By Nguyễn Tiến Trung - 22024527!");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                quit(stage);
            });

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void quit(Stage stage) { 
        Alert alertClose = new Alert(AlertType.CONFIRMATION);
        alertClose.setTitle("QUIT");
        alertClose.setHeaderText("Quit?");
        alertClose.setContentText("Are you sure you want to quit?");

        if (alertClose.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }


    public static void setRoot(Parent root) throws IOException {
        scene.setRoot(root);
    }

    public static void main(String[] args) {
        launch();
    }

}