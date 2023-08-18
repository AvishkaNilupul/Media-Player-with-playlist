package com.example.demo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        if (new LogT().a){

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("playArea.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Rexpotify");
                stage.centerOnScreen();
                scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
                stage.setScene(scene);
                //String css = this.getClass().getResource("app.css").toExternalForm();
                //scene.getStylesheets().add(css);
                stage.show();







        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Rexpotify");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) throws IOException {

            launch();



    }
}



class LogT {


    static char sdata ;
    boolean a = false;
    ID loga = new ID();

    HashMap<String, String> logininfo = loga.getLogininfo();


     LogT() throws IOException {

         BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\loginfo\\h.txt"));

        //FileReader reader = new FileReader();

         String ab = (reader.readLine());

         if (logininfo.containsKey(ab)){
             a= true;
         }

     }
}
