package com.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {


    public static void main(String[] args){

        launch(args);

}

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(""))

        stage.getIcons().add(new Image("C:\\Users\\Avishka\\Documents\\Java Applications\\test\\src\\main\\java\\com\\example\\test\\hi.png"));
        stage.setTitle("Stage Demo program");

        stage.setScene(new Scene(root, Color.BLACK));
        stage.show();


    }
}