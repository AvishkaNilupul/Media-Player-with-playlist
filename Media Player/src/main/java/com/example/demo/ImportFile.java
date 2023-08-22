package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import java.io.*;
import javax.swing.*;


import java.io.File;


public class ImportFile {

    @FXML
    private Button Closebtn;


    @FXML
    private Button importbtn;

    @FXML
    void Closebtn(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("playArea.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void importbtn(ActionEvent event) throws IOException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File filepath = null;

                    String MName = null;

                    JFileChooser fileChooser = new JFileChooser();

                    fileChooser.setCurrentDirectory(new File(".")); //sets current directory

                    int response = fileChooser.showOpenDialog(null); //select file to open
                    //int response = fileChooser.showSaveDialog(null); //select file to save

                    if (response == JFileChooser.APPROVE_OPTION) {
                        filepath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        MName = filepath.getName();


                    }
                    File destFile = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\music\\" + MName);



                    FileInputStream fileInputStream = null;
                    FileOutputStream fileOutputStream = null;


                    fileInputStream = new FileInputStream(filepath);
                    fileOutputStream = new FileOutputStream(destFile);

                    int i = 0;

                    while ((i = fileInputStream.read()) !=-1){
                        fileOutputStream.write(i);

                    }

                }catch (IOException e){
                    throw new RuntimeException();
                }


            }
        });
        t1.start();


    }



}
