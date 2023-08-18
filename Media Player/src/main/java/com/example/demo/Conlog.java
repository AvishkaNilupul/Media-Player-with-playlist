package com.example.demo;

import com.example.demo.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.scene.Node;


public class Conlog {

    




    @FXML
    private TextField password;

    @FXML
    private TextField email;

    private Scene scene;

    String username;
    String pass;

    String uName;



    public void mains (ActionEvent event) throws IOException {

        LogT log = new LogT();

        System.out.println(new LogT().a);




        username = String.valueOf(email.getText());
        pass = String.valueOf(password.getText());

        ID loga = new ID();

        HashMap<String, String> logininfo = loga.getLogininfo();



       if(logininfo.containsKey(username)) {

            if(logininfo.get(username).equals(pass)) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("playArea.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            }else {
                System.out.println("haaaa");
            }

            }
    }
}
